package uptodatemaintainers.Maintenancetool.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uptodatemaintainers.Maintenancetool.models.Data.UserDao;
import uptodatemaintainers.Maintenancetool.models.User;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("signup")
    public String userSignupForm(Model model){
        model.addAttribute("title", "Sign up");
        model.addAttribute(new User());
        return "signup";
    }

    @PostMapping("signup")
    public String processSignupForm(@ModelAttribute @Valid User newUser,
                                    Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Sign up");
            return "signup";
        }

        userDao.save(newUser);
        return "index";
    }

}
