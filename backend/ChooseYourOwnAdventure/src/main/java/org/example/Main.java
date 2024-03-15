package org.example;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        System.out.println();
        System.out.println("Welcome to the start of your next adventure!");

        System.out.println("Choose your path:");
        Service service = new Service(); //Instantiates a service object for getAdventures() method.
        List<Adventure> adventureList = service.getAdventures();
        if (adventureList.isEmpty()) {
            System.out.println("No Adventures Available.");
        } else {
            AtomicInteger i = new AtomicInteger(1);
            adventureList.stream().forEach(adventure ->
                System.out.println(i.getAndIncrement() + ") " + adventure.getTitle())
            ); // Stream enables multiple functions on a list (only for LISTS).
        }
    }
}

// separate interactions with user from business logic