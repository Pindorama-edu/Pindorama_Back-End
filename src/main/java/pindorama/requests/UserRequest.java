package pindorama.requests;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;
import pindorama.utils.PasswordUtils;
import pindorama.utils.enums.Genero;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
@RequestMapping("/api/v1")
public class UserRequest {

    private static final Logger logger = LoggerFactory.getLogger(UserRequest.class);

    @Autowired
    @Getter
    private UserRepository userRepository;


    //LOGIN

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String doLogin(@RequestParam String email,
                          @RequestParam String password, HttpServletRequest request) {
        try {

            if (request.getSession(false) != null) {
                request.getSession(false).invalidate();
            }

            var session = request.getSession();

            var user = userRepository.findByEmail(email);
            if (user != null) {

                boolean pass = PasswordUtils.verifyUserPassword(password, user.getPassword(), user.getSalt());

                if (pass) {
                    session.setAttribute("user", user);
                    session.setAttribute("name", user.getEmail());
                    session.setMaxInactiveInterval(80 * 60);


                    return "redirect:/materias";
                } else {
                    session.setAttribute("message", "Senha email/senha inválidos");


                    return "redirect:/";
                }
            } else {
                session.setAttribute("message", "Senha email/senha inválidos");

                return "redirect:/";
            }

        } catch (Exception ex) {
            logger.error("Erro ao logar", ex);
            request.getSession().setAttribute("message", ex);

            return "redirect:/";
        }
    }


    //Register


    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public String doRegister(@RequestParam String nome, @RequestParam String email,
                             @RequestParam String password, @RequestParam String nacionalidade,
                             @RequestParam String genero, @RequestParam String nascimento, HttpServletRequest request, Model model) {


        if (request.getSession(false) != null) {
            request.getSession(false).invalidate();
        }

        var user = userRepository.findByEmail(email);

        var session = request.getSession();
        model.addAttribute("id", "cadastro");
        if (user == null) {

            if(password.length() > 16){
                session.setAttribute("signupError", "A senha não pode ser maior que 16 caracteres.");
                return "redirect:/";
            }

            createUser(new User(nome, email, password, convertGenero(genero), nacionalidade, Date.valueOf(nascimento)));
            session.setAttribute("signupSuccess", "Cadastrado com sucesso");
            return "redirect:/";

        } else if (user.getEmail().equals(email)) {
            session.setAttribute("signupError", "Esse email já está cadastrado.");
            return "redirect:/";
        }

        session.setAttribute("signupError", "Internal Server Error!");
        return "redirect:/";
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

    private void createUser(User user) {
        userRepository.save(user);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/logout")
    public void doLogout(HttpServletRequest request) {
        var session = request.getSession(false);

        if (session != null) {
            System.out.println(session.getAttribute("name") + " : " + session.getId());
            session.removeAttribute("name");
            session.invalidate();
        }
    }

}