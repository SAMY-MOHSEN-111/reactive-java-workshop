package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
        /*ReactiveSources.intNumbersFluxWithException()
                .doOnError(error -> System.out.println("error happened " + error.getMessage()))
                // won't handle the error and will pass it to the chain
                .subscribe(
                        System.out::println,
                        error -> System.out.println("error happened " + error.getMessage()) // will handle the error
                );*/

        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
        /*ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((error, item) -> System.out.println("Error!!! " + item))
                .subscribe();*/


        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2)) // acts as catch block
                .doFinally(signalType -> { // acts as finally block
                    if (signalType == SignalType.ON_COMPLETE) ;
                    if (signalType == SignalType.ON_ERROR) ;
                })
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
