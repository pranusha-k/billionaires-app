package billionaires.springbootbillionaires.controllers;


import billionaires.springbootbillionaires.entities.Billionaire;
import billionaires.springbootbillionaires.repositories.BillionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class BillionaireController {
    private final BillionaireRepository billionaireRepository;
   @Autowired
    public BillionaireController(BillionaireRepository billionaireRepository) {
        this.billionaireRepository = billionaireRepository;
    }

    @GetMapping("/")
    public String showBillionaires(Model model){
       model.addAttribute( "billionaires",billionaireRepository.findAll());
       return "index";
    }
    @GetMapping("/addBillionaire")
    public String showAddBillionaireForm(Billionaire billionaire){
       return "add-billionaire";
    }
    @PostMapping("/addBillionaire")
    public String addBillionaire(@Valid Billionaire billionaire, BindingResult result,Model model){
        if (result.hasErrors()) {
            return "add-billionaire";
        }

        billionaireRepository.save(billionaire);
        model.addAttribute("billionaires", billionaireRepository.findAll());
        return "index";
   }
   @PutMapping("/updateBillionaire/{id}")
   public String showUpdateBillionaireForm(@PathVariable("id") long id, Model model) {
       Billionaire billionaire = billionaireRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid billionaire Id:" + id));
       model.addAttribute("billionaire", billionaire);
       return "update-billionaire";
   }
   @PostMapping("/updateBillionaire/{id}")
    public String updateBillionaire(@PathVariable("id") long id,@Valid Billionaire billionaire,BindingResult result,Model model){
       if (result.hasErrors()) {
           billionaire.setId(id);
           return "update-billionaire";
       }

       billionaireRepository.save(billionaire);
       model.addAttribute("billionaires", billionaireRepository.findAll());
       return "index";
   }
    @DeleteMapping("/deleteBillionaire/{id}")
    public String deleteBillionaire(@PathVariable("id") long id, Model model) {
        Billionaire billionaire = billionaireRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid billionaire Id:" + id));
        billionaireRepository.delete(billionaire);
        model.addAttribute("billionaires", billionaireRepository.findAll());
        return "index";
    }

}
