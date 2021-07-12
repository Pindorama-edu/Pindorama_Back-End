package pindorama.requests;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RedirectFiles {

    @RequestMapping(value = {"", "index", "home", "login"})
    public String home() {
        return "index";
    }

    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/materias/painel")
    public String controller() {
        return "adm/adm";
    }

    @RequestMapping("/materias")
    public String materias() {
        return "/materias/modulos";
    }

    @RequestMapping("/aula")
    public String aula() {
        return "/materias/aula";
    }

    @RequestMapping("/sobre")
    public String about() {
        return "/about/sobre";
    }

    @RequestMapping("/perfil")
    public String perfil() {
        return "/perfil/perfil";
    }

    @RequestMapping("/materia/{nome}")
    public String materia(@PathVariable String nome) {
        return "/materias/" + nome;
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/api/v1/logout";
    }

}
