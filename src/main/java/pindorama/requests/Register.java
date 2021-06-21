package pindorama.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pindorama.database.User;
import pindorama.database.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class Register {

    @Autowired
    private UserService userService;

   @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String doRegister(@RequestParam(value = "email") String email,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "pass") String password){

       for(var user : userService.getAllUsers()){
           if(user.getEmail().equals(email)){
               return "Esse usuario já está cadastrado!";
           }
       }

       userService.createUser(new User(name, email, password));
       return "Usuario registrado!";
    }
}
