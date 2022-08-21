package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here
        Flux<Integer> stream = ReactiveSources.intNumbersFlux();
        stream.subscribe(System.out::println);
        stream.subscribe(integer -> System.out.println("Hello - " + integer));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(System.out::println);

        System.out.println("Press a key to end");

        //Thread.sleep(15000);
        System.in.read();
    }

}
