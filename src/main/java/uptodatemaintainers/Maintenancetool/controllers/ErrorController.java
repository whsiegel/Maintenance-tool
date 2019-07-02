package uptodatemaintainers.Maintenancetool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String getError(){
        // handles 403 error 'access denied'
        return "/error";
    }

}


