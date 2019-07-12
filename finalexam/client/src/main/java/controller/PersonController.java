package controller;

import domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import service.PersonService;

import java.util.List;

@Controller
public class PersonController {


    //@Autowired
    //private PersonService personService;


    //@GetMapping("/")
    @RequestMapping("/abc")
    private String index()
    {
        return "index1";
    }

    /*
    @GetMapping("/")
    private String getAll(Model model)
    {
        List<Person> personList= personService.getAll();
        model.addAttribute("persons",personList);
        return "personList";
    }

     */
}
