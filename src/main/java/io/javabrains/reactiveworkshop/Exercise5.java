package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().subscribe(
//                item -> System.out.println(item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("complete")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }

}

/* very, very useful to control rate of the flow (controlling the back pressure) */
class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("subscription happened");
        request(1); /* give me an item when it is ready */
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value + " received");
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("completion happen");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("error happened " + throwable.getMessage());
    }
}