package com.gloriane.controller;

import com.gloriane.data.ContactDao;
import com.gloriane.exception.ContactStorageException;
import com.gloriane.exception.DuplicateContactException;
import com.gloriane.model.Contact;
import com.gloriane.view.ContactView;

public class ContactController {
    private final ContactDao contactDao;
    private final ContactView contactView;

    public ContactController(ContactDao contactDao, ContactView contactView) {
        this.contactDao = contactDao;
        this.contactView = contactView;
    }

    public void run() {
        boolean running = true;
        while (running) {
            contactView.displayMenu();
            String choice = contactView.getUserInput("Choose an option: ");

            switch (choice) {
                case "1" -> listContacts();
                case "2" -> addNewContact();
                case "3" -> {
                    running = false;
                    contactView.displayMessage("Goodbye!");
                }
                default -> contactView.displayError("Invalid option.");
            }
        }
    }

    private void listContacts() {
        try {
            contactView.displayContacts(contactDao.findAll());
        } catch (ContactStorageException e) {
            contactView.displayError(e.getMessage());
        }
    }

    private void addNewContact() {
        try {
            String name = contactView.getUserInput("Enter name: ");
            String phone = contactView.getUserInput("Enter phone (10 digits): ");

            Contact newContact = new Contact(name, phone);
            contactDao.save(newContact);
            contactView.displayMessage("Contact added successfully!");

        } catch (IllegalArgumentException | DuplicateContactException | ContactStorageException e) {
            contactView.displayError(e.getMessage());
        }
    }
}