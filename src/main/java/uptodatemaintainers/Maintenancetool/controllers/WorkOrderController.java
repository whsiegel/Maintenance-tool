package uptodatemaintainers.Maintenancetool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uptodatemaintainers.Maintenancetool.models.Data.AssetDao;
import uptodatemaintainers.Maintenancetool.models.Data.WorkOrderDao;
import uptodatemaintainers.Maintenancetool.models.WorkOrder;

@Controller
@RequestMapping(value="work-order")
public class WorkOrderController {

    @Autowired
    AssetDao assetDao;

    @Autowired
    WorkOrderDao workOrderDao;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/add")
    public String createWorkOrder(Model model){
        model.addAttribute("title", "Add Work Order");
        model.addAttribute(new WorkOrder());
        model.addAttribute("assets", assetDao.findAll());

        return "WorkOrder/add";
    }


}
