package com.funsoft.cabinet.controller;

import com.funsoft.cabinet.models.Doctor;
import com.funsoft.cabinet.models.SearchDoctor;
import com.funsoft.cabinet.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/doctors")
public class DoctorController {

    private static final Logger log = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    DoctorService doctorService;

    // http://localhst:8082/doctors/list
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView doctors(){
        List<Doctor> doctorList = doctorService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("doctors",doctorList);
        modelAndView.setViewName("doctors");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addForm(){
        //instancier le model
        Doctor doctor = new Doctor();
        // display add form
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("doctorForm",doctor); // Model
        modelAndView.setViewName("doctor"); // la page HTML Vue
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute("doctorForm") Doctor doctor, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return new ModelAndView("doctor");
        }
        else {
            doctorService.saveOrupdate(doctor);
            return  new ModelAndView("redirect:/doctors/list");
        }

    }

    @RequestMapping(value = "/delete/{idc}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("idc") long id){
        doctorService.delete(id);
        return new ModelAndView("redirect:/doctors/list");
    }

    @RequestMapping(value = "/update/{idc}",method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("idc") long id){
        // récupérer le modéle
        Doctor doctor = doctorService.get(id);
        // display add form
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("doctorForm",doctor); // Model
        modelAndView.setViewName("doctor"); // la page HTML Vue
        return modelAndView;

    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView searchForm(){
        ModelAndView modelAndView = new ModelAndView();
        SearchDoctor searchDoctor = new SearchDoctor();
        modelAndView.addObject("searchForm",searchDoctor);
        modelAndView.setViewName("search");
        return modelAndView;
    }

    @RequestMapping(value = "/advanced",method = RequestMethod.POST)

    public ModelAndView search(@ModelAttribute("searchForm") SearchDoctor searchDoctor){
        ModelAndView modelAndView = new ModelAndView();
        log.info("Search for doctors with fields {}  and {}",searchDoctor.getSpeciality(), searchDoctor.getPseudo());
        List<Doctor> doctorList = doctorService.advancedSearch(searchDoctor.getSpeciality(), searchDoctor.getPseudo());
        searchDoctor.setDoctors(doctorList);
        modelAndView.addObject("searchForm",searchDoctor);
        modelAndView.setViewName("search");
        return modelAndView;
    }



}
