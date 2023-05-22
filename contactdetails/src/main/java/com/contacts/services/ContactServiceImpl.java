package com.contacts.services;

import com.contacts.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ContactServiceImpl implements ContactService{

    //fake contact details of user
    List<Contact> list = List.of(
            new Contact(123L, "krishna@gmail.com", "krishna", 1344L),
            new Contact(124L, "krish@gmail.com", "krihna", 1344L),
            new Contact(125L, "krishna@gmail.com", "krina", 13445),
            new Contact(126L, "khna@gmail.com", "krishna", 13445),
            new Contact(127L, "krisa@gmail.com", "krish", 13446)
    );
    @Override
    public List<Contact> getUserContactList(long userId) {
        return list.stream()
                .filter(contact -> Long.valueOf(contact.getUserId()).equals(userId))
                .collect(Collectors.toList());
    }
}
