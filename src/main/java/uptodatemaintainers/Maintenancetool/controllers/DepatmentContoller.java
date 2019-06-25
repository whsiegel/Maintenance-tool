package uptodatemaintainers.Maintenancetool.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uptodatemaintainers.Maintenancetool.models.Data.DepartmentDao;
import uptodatemaintainers.Maintenancetool.models.Department;

import javax.validation.Valid;


@Controller
public class DepatmentContoller {

    @Autowired
    DepartmentDao departmentdao;

    @GetMapping("department/add")
    public String displayDepartmentForm(Model model) {
        model.addAttribute("title", "Add Department");
        model.addAttribute(new Department());
        model.addAttribute("departments", departmentdao.findAll());
        return "Department/add";
    }

    @PostMapping("department/add")
    public String processDepartmentForm(@ModelAttribute @Valid Department newDepartment,
                                        Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Department");
            model.addAttribute(new Department());
            model.addAttribute("departments", departmentdao.findAll());
            return "Department/add";
        }
        departmentdao.save(newDepartment);
        return "redirect: Department/add";
    }

}
