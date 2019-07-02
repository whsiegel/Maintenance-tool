package uptodatemaintainers.Maintenancetool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uptodatemaintainers.Maintenancetool.models.Data.WorkOrderDao;
import uptodatemaintainers.Maintenancetool.models.WorkOrder;

@Controller
@RequestMapping(value="work-order")
public class WorkOrderController {

    @Autowired
    WorkOrderDao workOrderDao;

    @GetMapping("/add")
    public String createWorkOrder(Model model){
        model.addAttribute("title", "Add Work Order");
        model.addAttribute(new WorkOrder());

        return "/add";
    }


}
