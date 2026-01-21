package com.gloriane.data;

import com.gloriane.exception.ContactStorageException;
import com.gloriane.exception.DuplicateContactException;
import com.gloriane.model.Contact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileContactDaoImpl {

    private Path path = Path.of("contacts.txt");

    public void addContact(Contact contact) throws ContactStorageException, DuplicateContactException {
        try {
            // Check if contact already exists
            if (contactExists(contact.getName())) {
                throw new DuplicateContactException(contact.getName());
            }

            //nConvert contact to text and write to file
            String contactData = contact.toString() + "\n";
            Files.write(path, contactData.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            throw new ContactStorageException("Failed to save contact", e);
        }
    }

    public Contact getContactByName(String contactName) throws ContactStorageException {
        try {
            if (!Files.exists(path)) {
                return null;
            }
            List<String> lines = Files.readAllLines(path);
            // Search logic would go here
            return null;
        } catch (IOException e) {
            throw new ContactStorageException("Error reading contacts", e);
        }
    }

    public List<Contact> getAllContacts() throws ContactStorageException {
        try {
            if (!Files.exists(path)) {
                return new ArrayList<>();
            }
            List<String> lines = Files.readAllLines(path);
            List<Contact> contacts = new ArrayList<>();
            for (String line : lines) {
                if (line.contains("name='") && line.contains("phoneNumber='")) {
                    String name = line.substring(line.indexOf("name='") + 6, line.indexOf("', phoneNumber"));
                    String phone = line.substring(line.indexOf("phoneNumber='") + 13, line.lastIndexOf("'"));
                    contacts.add(new Contact(name, phone));
                }
            }
            return contacts;
        } catch (IOException e) {
            throw new ContactStorageException("Failed to read contacts", e);
        }
    }

    private boolean contactExists(String name) throws ContactStorageException {
        try {
            if (!Files.exists(path)) {
                return false;
            }
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                if (line.contains("name='" + name + "'")) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new ContactStorageException("Error checking for duplicate contact", e);
        }
    }
}
