package pindorama.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pindorama.database.Conteudo;
import pindorama.database.Materias;
import pindorama.database.repos.ConteudoRepository;
import pindorama.database.repos.MateriasRepository;
import pindorama.utils.ProgressObservableInputStream;
import pindorama.utils.RandomString;

import java.io.*;
import java.sql.Date;
import java.util.List;

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

            String path = getDataFolder().getPath() + System.getProperty("file.separator") + new RandomString().nextString() + System.getProperty("file.separator") + file.getResource().getFilename();

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
                    logger.debug("Recebendo o arquivo {} {}% \n  {}/{}", file.getResource().getFilename(), stream.getPercentage(), stream.getSize(fileOut.getChannel().size()), stream.getSize(file.getSize()));

                cache = now;
            }

            Conteudo conteudo = new Conteudo(name, descricao, materiaId, professorId, palavras, new Date(System.currentTimeMillis()), file.getContentType());


            conteudo.setVideo(path.replace(getDataFolder().getAbsolutePath(), ""));

            repository.save(conteudo);

            return ResponseEntity.ok().body("Sucess");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro ao tentar enviar o arquivo");
        }
    }

    @Async
    @GetMapping("/getConteudo/{id}")
    public ResponseEntity<ResourceRegion> getConteudo(@PathVariable("id") long videoId, @RequestHeader HttpHeaders headers) throws IOException {

        var file = repository.findConteudoById(videoId);

        if (file == null) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("video/mp4")).body(null);
        }

        var video = new UrlResource("file:"+ getDataFolder().getAbsolutePath() + file.getVideo());
        var region = resourceRegion(video, headers);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(region);
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

    private ResourceRegion resourceRegion(UrlResource video, HttpHeaders headers) throws IOException {
        var contentLength = video.contentLength();
        var range = headers.getRange().stream().findFirst().orElse(null);

        if(range != null){
            var start = range.getRangeStart(contentLength);
            var end = range.getRangeEnd(contentLength);
            var rangeLength = Math.min(1000000L, end - start + 1);
            return new ResourceRegion(video, start, rangeLength);
        }

        var rangeLength = Math.min(1000000L, contentLength);

        return new ResourceRegion(video, 0, rangeLength);
    }
}
