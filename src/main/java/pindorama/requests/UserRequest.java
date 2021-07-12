package pindorama.requests;

import lombok.Getter;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pindorama.database.User;
import pindorama.database.repos.UserRepository;
import pindorama.utils.PasswordUtils;
import pindorama.utils.enums.Genero;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                          @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
        try {

            if (request.getSession(false) != null) {
                request.getSession(false).invalidate();
            }

            var session = request.getSession(true);

            var user = userRepository.findByEmail(email);
            if (user != null) {
                boolean pass = PasswordUtils.verifyUserPassword(password, user.getPassword(), user.getSalt());

                if (pass) {

                    session.setAttribute("user", user);

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

            if (password.length() > 16) {
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

    // Usuario

    @GetMapping({"/usuarios/{email}"})
    public ResponseEntity<User> getUser(@PathVariable(required = false) String email) {
        if (email == null) {
            return ResponseEntity.ok().body(null);
        }

        var user = userRepository.findByEmail(email);

        if (user != null)
            return ResponseEntity.ok(user);

        return null;
    }

    @GetMapping({"/usuario/{id}"})
    public ResponseEntity<User> getUser(@PathVariable(required = false) int id) {
        if (id == 0) {
            return ResponseEntity.ok().body(null);
        }

        var user = userRepository.findById(id);

        if (user != null)
            return ResponseEntity.ok(user);

        return null;
    }

    @PatchMapping(value = "usuario/update/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateUser(@PathVariable long id,
            @RequestBody String body, HttpServletRequest request) {
        try {
            System.out.println(body);
            JSONObject object = new JSONObject(body);

//            var session = request.getSession(false);

//            if(session.getAttribute("user") == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O usuario deve estar logado para isso!");
//
//            var user = (User) session.getAttribute("user");
//
//            if (user == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O usuario deve estar logado para isso!");
//            }

            var user = userRepository.findById(id);

            String email = null, password = null, birthdate = null;
            if (object.has("email")) {
                email = object.getString("email");
            }

            if (object.has("password")) {
                password = object.getString("password");
            }

            if (object.has("birthdate")) {
                birthdate = object.getString("birthdate");
            }

            if (email != null && !email.isEmpty()) {
                user.setEmail(email);
            }

            if (password != null && !password.isEmpty()) {
                var salt = PasswordUtils.getSalt(70);
                user.setSalt(salt);

                var pass = PasswordUtils.generateSecurePassword(password, salt);
                System.out.println("Senha: " + pass);

                user.setPassword(pass);
            }

            if (birthdate != null && !birthdate.isEmpty()) {
                user.setBirthDate(Date.valueOf(birthdate));
            }

            System.out.println("Salvando...");
            userRepository.save(user);


            return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).body("");
        } catch (JSONException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O body não é um json válido!");
        }
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


    @GetMapping(path = "/logout")
    public String doLogout(HttpServletRequest request) throws InterruptedException {
        var session = request.getSession(false);

        Thread.sleep(3000);

        if (session != null) {
            session.removeAttribute("name");
            session.invalidate();
        }

        return "redirect:/";
    }

}