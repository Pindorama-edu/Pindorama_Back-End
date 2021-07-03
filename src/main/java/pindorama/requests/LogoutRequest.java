package pindorama.requests;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1")
public class LogoutRequest {

    @RequestMapping(method = RequestMethod.GET, path = "/logout")
    public void doLogout(HttpServletRequest request){
        var session = request.getSession(false);

        if(session != null){
            System.out.println(session.getAttribute("name")+" : "+session.getId());
            session.removeAttribute("name");
            session.invalidate();
        }
    }

}
