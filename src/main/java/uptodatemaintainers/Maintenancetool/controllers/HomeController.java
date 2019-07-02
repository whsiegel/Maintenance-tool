package uptodatemaintainers.Maintenancetool.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uptodatemaintainers.Maintenancetool.models.MyUserPrincipal;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index (Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof MyUserPrincipal) {
            username = ((MyUserPrincipal)principal).getUsername();
        } else {
            username = principal.toString();
        }

        model.addAttribute("username", username);



        return "index";
    }

}
