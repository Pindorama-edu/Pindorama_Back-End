package pindorama.requests;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Teste {

    @RequestMapping(value = {"", "index", "home", "login"})
    public String home() {
        return "index";
    }

    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/controller/panel")
    public String controller() {
        return "adm/adm";
    }
}
