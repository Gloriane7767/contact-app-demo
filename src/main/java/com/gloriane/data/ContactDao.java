package com.gloriane.data;

import com.gloriane.model.Contact;

import java.util.List;

public interface ContactDao {
    public void addContact(Contact contact);
    public Contact getContactByName(int contactName);
    public List<Contact> getAllContacts();
}

// step1: build a basic interface for contact data access
// step2: implement the interface in FileContactDaoImpl class
// step3: test implementation using unit test or call the implemented methods in the main class (ContactApp)
// step4 and 5: implement the controller class adn view class

