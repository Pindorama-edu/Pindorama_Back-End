package pindorama.requests;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pindorama.database.User;
import pindorama.database.services.UserService;

import java.io.*;
import java.util.Base64;

@Controller
@RequestMapping("/api/v1")
public class TestUploadFile {


    @Autowired
    @Getter
    private UserService userService;

    @GetMapping(path = "/getUser")
    public User getUser(@RequestParam("name") String name){
        return userService.getRepository().findByUsername(name).get();
    }

    @PostMapping(path = "/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> updateFile(@RequestParam("file") MultipartFile submissions) throws IOException {
       var base = Base64.getEncoder();

       var pic = base.encode(submissions.getBytes());

     var user =  userService.getUserByEmail("erickfthomaz@gmail.com");

     user.setPicture(pic);

     userService.getRepository().save(user);
        return ResponseEntity.ok().body("Success");

    }

    @GetMapping(path = "getPic", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getFile(@RequestParam String email) {
        var user =  userService.getUserByEmail(email);

        if(user == null){
            return null;
        }

        if(user.getPicture() == null){
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(null);
        }
        var base = Base64.getDecoder();
        var pic = base.decode(user.getPicture());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(pic);
    }


}
