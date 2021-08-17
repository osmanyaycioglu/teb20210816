package com.training.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.training.java.Car;

public class LambdaRun {

    public static void main(final String[] args) {

        int deneme = 10;
        final Car carLoc = new Car(100,
                                   100,
                                   "BMW");

        IGreet greetLoc = new GreetImpl();
        String greetStrLoc = greetLoc.greet("osman");
        System.out.println(greetStrLoc);

        IGreet greetLoc2 = new GreetTRImpl();
        String greetStrLoc2 = greetLoc2.greet("osman");
        System.out.println(greetStrLoc2);

        IGreet greetLoc3 = new IGreet() {

            @Override
            public String greet(final String nameParam) {
                carLoc.forward();
                return "hello " + deneme + " " + nameParam;
            }
        };
        String greetStrLoc3 = greetLoc3.greet("osman");
        System.out.println(greetStrLoc3);

        IGreet greetLoc4 = new IGreet() {

            @Override
            public String greet(final String nameParam) {
                carLoc.forward();
                return "merhaba " + deneme + " " + nameParam;
            }
        };
        String greetStrLoc4 = greetLoc4.greet("osman");
        System.out.println(greetStrLoc4);

        IGreet greetLoc5 = w -> "hello " + w;
        String greetStrLoc5 = greetLoc5.greet("osman");
        System.out.println("Lambda : " + greetStrLoc5);

        IGreet greetLoc6 = a -> "merhaba " + a;
        String greetStrLoc6 = greetLoc6.greet("osman");
        System.out.println("Lambda : " + greetStrLoc6);

        IGreet greetLoc7 = w -> {
            carLoc.forward();
            return "hello " + w;
        };
        String greetStrLoc7 = greetLoc7.greet("osman");
        System.out.println("Lambda : " + greetStrLoc7);

        IGreet greetLoc8 = w -> {
            carLoc.forward();
            return "merhaba " + w;
        };
        String greetStrLoc8 = greetLoc8.greet("osman");
        System.out.println("Lambda : " + greetStrLoc8);

        greet(w -> "hello " + w,
              "osman");
        greet(w -> "merhaba " + w,
              "ali");
        greet(e -> "ola " + e,
              "veli");
        greet(w -> "hi " + w,
              "ayşe");

        greet(LambdaRun::xyz,
              "ayşe");

        LambdaRun lr = new LambdaRun();

        greet(lr::abc,
              "ayşe");

        IGoodbye.greet((y,
                        m) -> "hello " + y + " " + m,
                       "osman",
                       "yaycıoğlu");

        Function<String, Integer> fc = o -> Integer.parseInt(o);
        int value = fc.apply("100");
        System.out.println("100 : " + value);

        Supplier<String> supplierLoc = () -> "osman";
        String stringLoc = supplierLoc.get();
        System.out.println("osman : " + stringLoc);

        Predicate<Integer> check100 = j -> j > 100;
        check100.and(m -> m < 100)
                .or(zz -> zz == 1000);
        System.out.println(" result : " + check100.test(101));

        Consumer<String> consumerLoc = df -> System.out.println("sonuç : " + df);
        consumerLoc.accept("test");
    }

    public static void greet(final IGreet greetParam,
                             final String name) {
        String greetStrLoc = greetParam.greet(name);
        System.out.println("Lambda with method : " + greetStrLoc);
    }

    public static String xyz(final String name) {
        return "Static Method mapping : Hello : " + name;
    }

    public String abc(final String name) {
        return "Method mapping : Hello : " + name;
    }


}
