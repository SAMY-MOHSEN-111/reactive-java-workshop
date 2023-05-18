package io.javabrains.reactiveworkshop;

import java.io.IOException;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        /* when ever you get a number I want you to run the function that I will provide you */
        intNumbersFlux().subscribe(
                item -> System.out.println(item), // item emit
                error -> System.out.println(error.getMessage()), // failure event
                () -> System.out.println("complete") // completion event
        );

        /*integerFlux.subscribe(System.out::println); // one call back
        integerFlux.subscribe(number -> System.out.println(number + " another 1")); // another call back*/


        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
//        userFlux().subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }

}
