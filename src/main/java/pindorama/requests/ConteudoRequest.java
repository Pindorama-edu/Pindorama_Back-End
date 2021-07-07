package pindorama.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pindorama.database.Conteudo;
import pindorama.database.Materias;
import pindorama.database.repos.ConteudoRepository;
import pindorama.database.repos.MateriasRepository;
import pindorama.utils.ProgressObservableInputStream;

import java.io.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/conteudo")
public class ConteudoRequest {

    private final static Logger logger = LoggerFactory.getLogger(ConteudoRequest.class);

    @Autowired
    private ConteudoRepository repository;

    @Autowired
    private MateriasRepository materias;

    @PostMapping(path = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createConteudo(@RequestParam("nome") String name,
                                                 @RequestParam("desc") String descricao,
                                                 @RequestParam("materia") int materiaId,
                                                 @RequestParam("professor") int professorId,
                                                 @RequestParam(value = "palavras", required = false) String palavras,
                                                 @RequestParam("file") MultipartFile file) {
        try {


            byte[] buffer = new byte[4096];

            String path = getDataFolder().getPath() + System.getProperty("file.separator") + UUID.randomUUID() + System.getProperty("file.separator") + file.getResource().getFilename();

            File files = new File(path);

            if (!files.exists()) {
                if (!files.getParentFile().exists()) {
                    if (files.getParentFile().mkdirs())
                        logger.info("Criando pasta {}", files.getParentFile().getName());
                }

                if (files.createNewFile())
                    logger.info("Criando arquivo {}...", file.getResource().getFilename());
            }

            InputStream in = file.getInputStream();

            ProgressObservableInputStream stream = new ProgressObservableInputStream(in, file.getSize());

            FileOutputStream fileOut = new FileOutputStream(path);

            int read;

            double cache = 0.0;

            while ((read = stream.read(buffer)) != -1) {
                fileOut.write(buffer, 0, read);

                double now = stream.getPercentage();
                if (now > cache)
                    logger.info("Recebendo o arquivo {} {}% \n  {}/{}", file.getResource().getFilename(), stream.getPercentage(), stream.getSize(fileOut.getChannel().size()), stream.getSize(file.getSize()));

                cache = now;
            }

            Conteudo conteudo = new Conteudo(name, descricao, materiaId, professorId, palavras, new Date(System.currentTimeMillis()), file.getContentType());


            conteudo.setVideo(path);

            repository.save(conteudo);

            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tentar enviar o arquivo");
        }
    }

    @Async
    @GetMapping("/getConteudo")
    public ResponseEntity<byte[]> getConteudo(long videoId) throws IOException {

        var file = repository.findConteudoById(videoId);

        if (file == null) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("video/mp4")).body(null);
        }

        FileInputStream inputStream = new FileInputStream(file.getVideo());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(300);

        byte[] bytes = new byte[4064];

        int read;
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        return ResponseEntity.ok().contentType(MediaType.valueOf(file.getMediaType())).body(outputStream.toByteArray());
    }

    @GetMapping("/conteudos")
    public ResponseEntity<List<Conteudo>> conteudos() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping("/materias")
    public ResponseEntity<List<Materias>> materias() {
        return ResponseEntity.ok().body(materias.findAll());
    }

    public static File getDataFolder() {
        return new File(System.getProperty("user.dir"), "data");
    }
}
