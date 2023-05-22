package com.contacts.services;

import com.contacts.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getUserContactList(long userId);
}
