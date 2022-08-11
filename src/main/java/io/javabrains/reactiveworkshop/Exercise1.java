package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        StreamSources.intNumbersStream().forEach(System.out::println);

        System.out.println("=====================");
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(i -> i < 5)
                .forEach(System.out::println);

        System.out.println("=====================");
        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("=====================");
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println(StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .findFirst()
                .orElse(-1));

        System.out.println("=====================");
        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));
        System.out.println("=====================");
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        System.out.println("=====================");
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

        System.out.println("=====================");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(integer -> integer == user.getId()))
                .forEach(System.out::println);
    }
}
