package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.err.println(throwable.getMessage()),
                () -> System.out.println("Completed Flux"));

        ReactiveSources.userMono().subscribe(
                integer -> System.out.println(integer),
                throwable -> System.err.println(throwable.getMessage()),
                () -> System.out.println("Completed Mono"));

        System.out.println("=====================");
        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(new MySubscriber<User>());

        System.out.println("Press a key to end");
        System.in.read();
    }

    private static class MySubscriber<T> extends BaseSubscriber<T> {
        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscribe happened");
            request(1);
        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println(value + " - received");
            request(1);
        }
    }

}