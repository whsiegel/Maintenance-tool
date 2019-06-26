package uptodatemaintainers.Maintenancetool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uptodatemaintainers.Maintenancetool.models.Asset;
import uptodatemaintainers.Maintenancetool.models.Data.AssetDao;
import uptodatemaintainers.Maintenancetool.models.Data.DepartmentDao;
import uptodatemaintainers.Maintenancetool.models.Department;

import javax.validation.Valid;


@Controller
public class AssetController {

    @Autowired
    AssetDao assetDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("asset/add")
    public String userSignupForm(Model model) {
        model.addAttribute("title", "Add Asset");
        model.addAttribute(new Asset());
        model.addAttribute("departments", departmentDao.findAll());
        return "Asset/add";
    }

    @PostMapping("asset/add")
    public String AddAssetForm(@ModelAttribute @Valid Asset newAsset,
                                       Errors errors, @RequestParam int departmentId, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Asset");
            model.addAttribute(new Asset());
            model.addAttribute("departments", departmentDao.findAll());
            return "Asset/add";
        }

        Asset asset = assetDao.getByName(newAsset.getName());
        if(asset != null){

            model.addAttribute("title", "Add Department");
            model.addAttribute("error", "Already an entry" );
            model.addAttribute("departments", departmentDao.findAll());
            return "Asset/add";
        }

        Department dep = departmentDao.findOne(departmentId);
        newAsset.setDepartment(dep);
        assetDao.save(newAsset);
        model.addAttribute("departments", departmentDao.findAll());

        return "Asset/add";

    }



}
