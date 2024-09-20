package com.phonebook.phonebook.controller;


import com.phonebook.phonebook.model.Contact;
import com.phonebook.phonebook.service.PhonebookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PhonebookController {
    private final PhonebookService service;

    public PhonebookController(PhonebookService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contacts", service.findAll());
        model.addAttribute("contact", new Contact()); // Add a new Contact object
        return "phonebook";
    }


    @PostMapping("/add")
    public String addContact(Contact contact) {
        service.save(contact);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteContact(@RequestParam Long id) {
        service.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        Contact contact = service.findById(id);
        model.addAttribute("contact", contact);
        return "edit"; // New edit template
    }

    @PostMapping("/update")
    public String updateContact(Contact contact) {
        service.save(contact);
        return "redirect:/";
    }
}
