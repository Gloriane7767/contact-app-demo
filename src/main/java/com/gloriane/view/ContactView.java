package com.gloriane.view;

import com.gloriane.model.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactView {
    Scanner scanner = new Scanner(System.in);

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void displaymenu() {
        System.out.println("\n Contact App Menu");
        System.out.println("1. Display All Contact");
        System.out.println("2. Add New Contact");
        System.out.println("3. Exit");
    }

    public void displayContacts(List<Contact> contacts) {
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContact List:");
            contacts.forEach(System.out::println);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void displayMenu() {
    }
}
