package uptodatemaintainers.Maintenancetool.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index () {
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return auth.getName();
    }


    @RequestMapping("logout")
    public String logoutHandler() {

        SecurityContextHolder.clearContext();

        return "redirect:/";
    }
}
