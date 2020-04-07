package billionaires.springbootbillionaires.controllers;

import billionaires.springbootbillionaires.entities.Billionaire;
import billionaires.springbootbillionaires.repositories.BillionaireRepository;
import billionaires.springbootbillionaires.service.BillionaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BillionaireController {
    private final BillionaireService billionaireService;
   @Autowired
    public BillionaireController(BillionaireService billionaireService) {
       this.billionaireService = billionaireService;
   }

    @GetMapping("/")
    public String showBillionaires(Model model){
       model.addAttribute( "billionaires", billionaireService.sortBillionaires());
       return "index";
    }
    @GetMapping("/addBillionaire")
    public String showAddBillionaireForm(){
       return "add-billionaire";
    }
    @PostMapping("/addBillionaire")
    public String addBillionaire(@Valid Billionaire billionaire, BindingResult result,Model model){
        if (result.hasErrors()) {
            return "error";
        }

        billionaireService.saveBillionaire(billionaire);
        model.addAttribute("billionaires", billionaireService.sortBillionaires());
        return "index";
   }
   @GetMapping("/updateBillionaire/{id}")
   public String showUpdateBillionaireForm(@PathVariable("id") long id, Model model) {
       Billionaire billionaire = billionaireService.findBillionaire(id);
       model.addAttribute("billionaire", billionaire);
       return "update-billionaire";
   }
   @PostMapping("/updateBillionaire/{id}")
    public String updateBillionaire(@PathVariable("id") long id,@Valid Billionaire billionaire,BindingResult result,Model model){
       if (result.hasErrors()) {
           billionaire.setId(id);
           return "error";
       }

       billionaireService.saveBillionaire(billionaire);
       model.addAttribute("billionaires", billionaireService.sortBillionaires());
       return "index";
   }
    @GetMapping("/deleteBillionaire/{id}")
    public String deleteBillionaire(@PathVariable("id") long id, Model model) {
        Billionaire billionaire = billionaireService.findBillionaire(id);
        billionaireService.deleteBillionaire(billionaire);
        model.addAttribute("billionaires",billionaireService.sortBillionaires());
        return "index";
    }

}
