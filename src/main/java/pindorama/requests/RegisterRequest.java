package pindorama.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api")
public class RegisterRequest {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public String doRegister(@RequestParam String username, @RequestParam String email,
                             @RequestParam String password, @RequestParam String nascionalidade,
                             @RequestParam String sexo, @RequestParam String birthdate) {

        var user = userRepository.findByEmail(email);
        if (user.getEmail().equals(email)) {
            return "Esse usuario já está cadastrado!";
        }

        createUser(new User(username, email, password, convertGenero(sexo), nascionalidade, Date.valueOf(formatDate(birthdate))));
        return "Usuario registrado!";
    }

    private User.Genero convertGenero(String genero) {
        if (genero.equals("Masculino")) {
            return User.Genero.M;
        }
        if (genero.equals("Feminino")) {
            return User.Genero.F;
        }
        return User.Genero.O;
    }

    private final SimpleDateFormat inSDF = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-MM-dd");

    private String formatDate(String inDate) {
        String outDate = "";
        if (inDate != null) {
            try {
                java.util.Date date = inSDF.parse(inDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex) {
            }
        }
        return outDate;
    }

    private void createUser(User user) {
        userRepository.save(user);
    }
}
