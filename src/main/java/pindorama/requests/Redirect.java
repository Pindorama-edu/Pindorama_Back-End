package pindorama.requests;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pindorama.database.User;
import pindorama.utils.enums.UserType;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class Redirect {

    @GetMapping("redirect/adm")
    public ModelAndView redirectToAdm(HttpServletRequest request) {

        var session = request.getSession(false);

        if(session == null){
            return new ModelAndView("redirect:/index.jsp");
        }

        var user = (User) session.getAttribute("user");

        if (user.getUserType() == UserType.ADM) {
            return new ModelAndView("redirect:/adm/adm.jsp");
        }

        return new ModelAndView("redirect:/index.jsp");
    }
}
