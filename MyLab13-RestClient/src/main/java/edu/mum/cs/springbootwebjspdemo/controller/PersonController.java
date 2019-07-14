package edu.mum.cs.springbootwebjspdemo.controller;

import edu.mum.cs.springbootwebjspdemo.domain.Person;
import edu.mum.cs.springbootwebjspdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/persons")
    private String getAll(Model model)
    {
        List<Person> personList= personService.getAll();
        model.addAttribute("persons",personList);
        return "personList";
    }
    @GetMapping("/person/{id}")
    private String getOne(@PathVariable Long id, Model model)
    {
        Person person= personService.get(id);
        model.addAttribute("person",person);
        model.addAttribute("msg","Update");
        return "personDetail";
    }
    @PostMapping("/person/{id}")
    public String update(@Valid Person person, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "personDetail";
        } else {
            personService.update(person);
            return "redirect:/persons";
        }

    }
    @PostMapping("/person/delete/{id}")
    public String update(@PathVariable Long id) {
            personService.delete(id);
            return "redirect:/persons";

    }
    @GetMapping("/person/add")
    public String viewAdd(@ModelAttribute Person person , Model model) {
        model.addAttribute("msg", "Add");
        return "personForm";
    }
    @PostMapping("/person/add")
    public String add(@Valid Person person, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "personForm";
        } else {
            //personService.add(person);
            Long id = personService.addRedirect(person);
            System.out.println(id);
            return "redirect:/persons";
        }
    }
}
