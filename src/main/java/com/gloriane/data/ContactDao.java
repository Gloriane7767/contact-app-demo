package com.gloriane.data;

import com.gloriane.exception.ContactStorageException;
import com.gloriane.exception.DuplicateContactException;
import com.gloriane.model.Contact;

import java.util.List;

public interface ContactDao {
    List<Contact> findAll() throws ContactStorageException;
    void save(Contact contact) throws ContactStorageException, DuplicateContactException;
    Contact findByName(String name) throws ContactStorageException;
}

