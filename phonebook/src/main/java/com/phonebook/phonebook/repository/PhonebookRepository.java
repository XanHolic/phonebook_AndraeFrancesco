package com.phonebook.phonebook.repository;


import com.phonebook.phonebook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonebookRepository extends JpaRepository<Contact, Long> {
}
