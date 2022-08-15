package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.models.Client;
import com.funsoft.cabinet.models.Doctor;
import com.funsoft.cabinet.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    // http://localhost:8082/clinique/clients/list
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getclients(){
        ModelAndView modelAndView = new ModelAndView();
        List<Client> clientList = clientService.getAll();
        modelAndView.addObject("mesclients",clientList);
        modelAndView.setViewName("clients");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addForm(){
        ModelAndView modelAndView = new ModelAndView();
        Client client = new Client();
        modelAndView.addObject("clientForm",client);
        modelAndView.setViewName("client");
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("clientForm") Client client, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return new ModelAndView("client");
        }
        else {
            clientService.saveOrupdate(client);
            return new ModelAndView("redirect:/clients/list");
        }
    }

    @RequestMapping(value = "/delete/{idc}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("idc") long idc){
        clientService.delete(idc);
        return new ModelAndView("redirect:/clients/list");
    }

    @RequestMapping(value = "/update/{idc}",method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("idc") long idc){
        // récupérer le client à partir de la base
        Client client = clientService.getClient(idc);
        // générer le formulaire de modification
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientForm",client);
        modelAndView.setViewName("client");
        return modelAndView;
    }
}
