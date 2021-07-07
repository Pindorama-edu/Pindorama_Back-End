package pindorama.requests;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pindorama.database.repos.ProfessorRepository;

@Controller
@RequestMapping("/api/v1/professor")
public class ProfessorRequest {

    @Autowired
    @Getter
    private ProfessorRepository userRepository;

    public String doRegister(){
        return "redirect:/";
    }
}
