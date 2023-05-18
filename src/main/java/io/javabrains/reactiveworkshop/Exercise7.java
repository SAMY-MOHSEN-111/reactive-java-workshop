package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .log() // position of the log matters
                .subscribe(
                        System.out::println,
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("complete")
                );*/


        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .map(number -> number * 10)
                .subscribe(System.out::println);*/

        /*ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .map(number -> number * 10)
                .flatMap(number -> Flux.range(1, 10).map(i -> number)) // instead of IntStream.range()
                .subscribe(System.out::println);*/


        // Print 10 multiplied by each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .filter(number -> number > 5)
                .map(number -> number * 10)
                .take(3) // instead of limit
                .subscribe(System.out::println);*/


        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .filter(number -> number > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);*/


        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        /*ReactiveSources.intNumbersFlux()
                .flatMap(id -> ReactiveSources.userFlux().filter(user -> user.getId() == id).take(1))
                .subscribe(System.out::println);*/
        /*اللي راجع من الماب فلاكس و هيتحط جوا فلاكس*/


        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);


        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
