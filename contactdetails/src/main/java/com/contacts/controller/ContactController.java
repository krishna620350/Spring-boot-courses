package com.contacts.controller;

import com.contacts.entity.Contact;
import com.contacts.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @RequestMapping("/user/{userid}")
    public List<Contact> getContact(@PathVariable("userid") long userid){
        return this.contactService.getUserContactList(userid);
    }
}
