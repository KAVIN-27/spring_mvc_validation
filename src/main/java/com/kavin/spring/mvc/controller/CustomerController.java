package com.kavin.spring.mvc.controller;

import com.kavin.spring.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //add initbinder .... to convert trim input strings
    //remove leading and trailing whitespaces
    //resolve issur for validation

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @GetMapping(path = "/showCustomerForm")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());

        return "customer-form";
    }

    @PostMapping(path = "/processFrom")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult){

       // System.out.println("Last name: | "+customer.getLastName()+" |");
        System.out.println("Binding results: | "+ bindingResult.toString());

        if(bindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }

}
