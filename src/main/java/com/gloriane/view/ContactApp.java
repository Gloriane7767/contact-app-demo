package com.gloriane.view;

import com.gloriane.controller.ContactController;
import com.gloriane.data.ContactDao;
import com.gloriane.data.FileContactDaoImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ContactApp {
    public static void main(String[] args) {

        ContactController controller = new ContactController(new FileContactDaoImpl(), new ContactView());
        controller.run();

        }
    }

