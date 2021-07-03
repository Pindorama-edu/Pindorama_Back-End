package pindorama.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;
import pindorama.utils.enums.Genero;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/api/v1")
public class RegisterRequest {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String doRegister(@RequestParam String nome, @RequestParam String email,
                             @RequestParam String password, @RequestParam String nacionalidade,
                             @RequestParam String genero, @RequestParam String nascimento, HttpServletRequest request) {

        var user = userRepository.findByEmail(email);

        var session = request.getSession(false);
        if (user == null) {
            createUser(new User(nome, email, password, convertGenero(genero), nacionalidade, Date.valueOf(formatDate(nascimento))));
            session.setAttribute("signupSuccess", "Cadastrado com sucesso");
            return "redirect:/index.jsp";
        } else if (user.getEmail().equals(email)) {
            session.setAttribute("signupError", "Esse email já está cadastrado.");
            return "redirect:/index.jsp";
        }

        session.setAttribute("message", "Esse email já está cadastrado.");
        return "redirect:/index.jsp";
    }

    private Genero convertGenero(String genero) {
        if (genero.equals("Masculino")) {
            return Genero.M;
        }
        if (genero.equals("Feminino")) {
            return Genero.F;
        }
        return Genero.O;
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
