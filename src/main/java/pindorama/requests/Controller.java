package pindorama.requests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.stereotype.Controller
@RequestMapping("/api/v1")
public class Controller {

    @GetMapping(path = "/")
    public String welcomePindoramaApi() {
        return "Pindorama API: 1.0v";
    }
}
