package pindorama.requests;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pindorama.database.repos.UserRepository;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1")
public class UploadFiles {


    @Autowired
    @Getter
    private UserRepository userService;

    @PostMapping(path = "/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateFile(@RequestParam("file") MultipartFile submissions,
                                             @RequestParam("email") String email)throws IOException {
        var base = Base64.getEncoder();

        var pic = base.encode(submissions.getBytes());

        var user = userService.findByEmail(email);

        if (user == null) {
            return ResponseEntity.ok().body("User not found.");
        }

        if (pic == null) {
            return ResponseEntity.ok().body("Cannot covert picture.");
        }

        user.setPicture(pic);
        user.setMediaType(submissions.getContentType());

        userService.save(user);
        return ResponseEntity.ok().body("Success");
    }

    @GetMapping(path = "getPicture")
    public ResponseEntity<byte[]> getFile(@RequestParam String email) {
        var user = userService.findByEmail(email);

        if (user == null) {
            return null;
        }

        if (user.getPicture() == null) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(null);
        }
        var base = Base64.getDecoder();
        var pic = base.decode(user.getPicture());

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(user.getMediaType())).body(pic);
    }

}
