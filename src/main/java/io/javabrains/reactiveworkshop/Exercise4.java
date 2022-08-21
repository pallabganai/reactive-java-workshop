package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer number = ReactiveSources.intNumberMono().block(); //blocking, not to be used
        Optional<Integer> numberOp = ReactiveSources.intNumberMono().blockOptional();
        System.out.println(number);
        numberOp.ifPresent(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
