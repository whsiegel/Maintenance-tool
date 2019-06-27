package uptodatemaintainers.Maintenancetool.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uptodatemaintainers.Maintenancetool.models.Data.DepartmentDao;
import uptodatemaintainers.Maintenancetool.models.Department;

import javax.validation.Valid;

@Controller
public class DepatmentContoller {

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("department/add")
    public String displayDepartmentForm(Model model) {
        model.addAttribute("title", "Add Department");
        model.addAttribute(new Department());
        model.addAttribute("departments", departmentDao.findAll());
        return "Department/add";
    }

    @PostMapping("department/add")
    public String processDepartmentForm(@ModelAttribute @Valid Department newDepartment,
                                        Errors errors, Model model) {
        model.addAttribute("departments", departmentDao.findAll());

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Department");
            model.addAttribute(new Department());
            return "Department/add";
        }
        Department department = departmentDao.getByName(newDepartment.getName());
        if(department != null){

            model.addAttribute("title", "Add Department");
            model.addAttribute("error", "Already an entry" );
            return "Department/add";
        }

        departmentDao.save(newDepartment);
        model.addAttribute(new Department());
        model.addAttribute("title", "Add Department");
        return "Department/add";

    }

}
