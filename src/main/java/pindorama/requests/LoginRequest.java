package pindorama.requests;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pindorama.database.repos.UserRepository;
import pindorama.database.services.UserService;
import pindorama.utils.PasswordUtils;

@RestController
@RequestMapping("/api")
public class LoginRequest {

    private static Logger logger = LoggerFactory.getLogger(LoginRequest.class);

    @Autowired
    @Getter
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity doLogin(@RequestParam String email,
                                  @RequestParam String pass) {
        try {
            var user = userRepository.findByEmail(email);


            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\n" +
                        "  \"logged\": false,\n" +
                        "  \"code\": 404,\n" +
                        "  \"message\": \"User not found.\"\n" +
                        "}");
            }

            boolean password = PasswordUtils.verifyUserPassword(pass, user.getPassword(), user.getSalt());
            if (password) {
                return ResponseEntity.status(HttpStatus.OK).body(user);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\n" +
                    "  \"logged\": false,\n" +
                    "  \"code\": 401,\n" +
                    "  \"message\": \"Password wrong.\"\n" +
                    "}");
        } catch (Exception ex) {
            logger.error("Erro ao logar", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\n" +
                    "  \"logged\": false,\n" +
                    "  \"code\": 500,\n" +
                    "  \"message\": \"Server internal error.\"\n" +
                    " \"exception:\" \"" + ex.getMessage() + "\"" +
                    "}");
        }
    }
}