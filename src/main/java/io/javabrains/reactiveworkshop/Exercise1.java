package io.javabrains.reactiveworkshop;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.javabrains.reactiveworkshop.StreamSources.intNumbersStream;
import static io.javabrains.reactiveworkshop.StreamSources.userStream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        intNumbersStream().filter(number -> number < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);

        intNumbersStream()
                .filter(number -> number > 5)
                .findAny()// will return any number that is greater than 5 else -1
                .orElse(-1);


        // Print first names of all users in userStream
        // TODO: Write code here
        userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);


        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        userStream()
                .filter(user -> intNumbersStream().anyMatch(id -> id == user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);

        /* test */
        Stream.iterate(0, i -> i + 2)
                .limit(10)
                .forEach(System.out::println);

        IntStream.range(0, 10)
                .boxed()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        // async ^_^
        CompletableFuture<Integer> integerAsync
                = CompletableFuture.supplyAsync(() -> 5);


    }

}
