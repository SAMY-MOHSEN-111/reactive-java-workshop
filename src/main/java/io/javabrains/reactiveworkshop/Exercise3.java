package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> integers = ReactiveSources.intNumbersFlux().log().toStream().toList();
        System.out.println("numbers are: " + integers);   // blocking operation
        System.out.println("length: " + integers.size()); // blocking operation

        List<User> users = ReactiveSources.userFlux().toStream().toList();
        System.out.println("users are " + users);
        System.out.println("length: " + users.size());
//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
