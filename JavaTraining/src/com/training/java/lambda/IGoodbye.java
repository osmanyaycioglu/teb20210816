package com.training.java.lambda;


@FunctionalInterface
public interface IGoodbye {

    String goodbye(String name,
                   String surname);

    public static void greet(final IGoodbye greetParam,
                             final String name,
                             final String surname) {
        String greetStrLoc = greetParam.goodbye(name,
                                                surname);
        System.out.println("Goodbye with default method : " + greetStrLoc);
    }

}
