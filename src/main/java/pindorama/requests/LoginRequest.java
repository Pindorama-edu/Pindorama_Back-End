package pindorama.requests;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;
import pindorama.utils.PasswordUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1")
public class LoginRequest {

    private static final Logger logger = LoggerFactory.getLogger(LoginRequest.class);

    @Autowired
    @Getter
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String doLogin(@RequestParam String email,
                          @RequestParam String password, HttpServletRequest request) {
        try {
            var session = request.getSession();
            var user = userRepository.findByEmail(email);
            if (user != null) {

                boolean pass = PasswordUtils.verifyUserPassword(password, user.getPassword(), user.getSalt());

                if (pass) {
                    session.setAttribute("user", user);
                    session.setAttribute("name", user.getEmail());
                    session.setMaxInactiveInterval(80 * 60);


                    return "redirect:/welcome.jsp";
                } else {
                    session.setAttribute("message", "Senha email/senha inválidos");


                    return "redirect:/index.jsp";
                }
            } else {
                session.setAttribute("message", "Senha email/senha inválidos");

                return "redirect:/index.jsp";
            }

        } catch (Exception ex) {
            logger.error("Erro ao logar", ex);
            request.getSession().setAttribute("message", ex);

            return "redirect:/index.jsp";
        }
    }
}