package pindorama.requests;

import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pindorama.database.User;
import pindorama.database.services.UserService;

import java.io.*;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class TestUploadFile {


    @Autowired
    @Getter
    private UserService userService;

    @GetMapping(path = "getUser")
    public User getUser(@RequestParam("name") String name){
        return userService.getRepository().findByUsername(name).get();
    }

    @SneakyThrows
    @PostMapping(path = "picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateFile(@RequestParam("file") MultipartFile submissions){
       var base = Base64.getEncoder();

       var pic = base.encode(submissions.getBytes());

     var user =  userService.getUserByEmail("erickfthomaz@gmail.com");

     user.setPicture(pic);

     userService.getRepository().save(user);

    }

    @GetMapping(path = "getPic")
    public ResponseEntity<byte[]> getFile() throws IOException {
        var user =  userService.getUserByEmail("erickfthomaz@gmail.com");

        var base = Base64.getDecoder();
        var pic = base.decode(user.getPicture());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pic);

    }


}
