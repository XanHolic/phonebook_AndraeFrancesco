package com.phonebook.phonebook.service;


import com.phonebook.phonebook.model.Contact;
import com.phonebook.phonebook.repository.PhonebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonebookService {
    private final PhonebookRepository repository;

    public PhonebookService(PhonebookRepository repository) {
        this.repository = repository;
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }
    public Contact findById(Long id) {
        return repository.findById(id).orElse(null);
    }


    public void save(Contact contact) {
        repository.save(contact);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
