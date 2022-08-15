package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.models.Client;
import com.funsoft.cabinet.service.ClientService;
import com.funsoft.cabinet.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController // controleur 2 génération  : page web, text , json xml (REST API)
//@Controller // controleur MVC ( page web)
public class welcome {

    @Autowired
    ClientService clientService;

    // request / response (ModelAndView   ---> HTML )

    // http://localhost:8082/clinique
   /*@RequestMapping(value = "/",method = RequestMethod.GET)
     public String hello(){
        return "Hello Mahran, it's your first spring boot application";
    }*/

    // MVC Model View Controller

    // http://localhost:8082/clinique
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView welcomepage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // localhost:8082/clinique/test
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        Client client = new Client();
        client.setFirstname("mahran");
        client.setLastname("Farhat");
        client.setEmail("farhatmahran@gmail.com");
        client.setPhone("002165295894");
        clientService.saveOrupdate(client);
        return "Client ajouté";
    }


}
