package me.jrmensah.addressbookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String listNames(Model model){
        model.addAttribute("person", personRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String bookForm(Model model){
        model.addAttribute("person", new Person());
        return "bookform";
    }

    @GetMapping("/process")
    public String processForm(@Valid Person person, BindingResult result)
    {
        if(result.hasErrors()){
            return "bookform";
        }
            personRepository.save(person);
            return "redirect:/";

    }
    @RequestMapping("/detail/{id}")
    public String showPerson(@PathVariable("id") long id, Model model){
    model.addAttribute("person", personRepository.findOne(id));
    return "show";
    }
    @RequestMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepository.findOne(id));
        return "bookform";
    }
    @RequestMapping("/delete/{id}")
    public String delPerson(@PathVariable("id") long id){
        personRepository.delete(id);
        return "redirect:/";
    }
}

