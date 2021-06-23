package pindorama.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pindorama.database.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class Login {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ModelAndView doLogin(HttpServletResponse response, HttpServletRequest request, RedirectAttributes attributes,
                                @RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password) throws Exception {

        var user = userService.getUserByEmail(email);

        if (user == null) {
            attributes.addAttribute("userNotFound", true);
            return new ModelAndView("redirect:/login/logue.jsp");
        }

        if (user.getPassword().equals(password)) {

            HttpSession oldSession = request.getSession(false);

            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = request.getSession(true);

            newSession.setMaxInactiveInterval(7200);

            Cookie cookie = new Cookie("message", "welcome pindorama");
            response.addCookie(cookie);

            attributes.addAttribute("userLoginSuccess", true);
            return new ModelAndView("redirect:/login/logue.jsp");
        }
        attributes.addAttribute("userLoginFail", true);
        return new ModelAndView("redirect:/login/logue.jsp");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/forgot_pass")
    public String resetPassword(@RequestParam(value = "email") String email) {

        return "Done!";
    }

}
