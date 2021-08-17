package com.training.java.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRun {

    public static void main(final String[] args) {
        List<String> asListLoc = Arrays.asList("osman",
                                               "ali",
                                               "veli",
                                               "ayşe",
                                               "fatma",
                                               "osman",
                                               "ali",
                                               "su",
                                               "abc",
                                               "dfg",
                                               "hakkı");
        for (String stringLoc : asListLoc) {
            System.out.println("liste item : " + stringLoc);
        }
        System.out.println("--------------------------------------------------");
        asListLoc.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Stream<String> streamLoc = asListLoc.stream();
        streamLoc.filter(a -> a.length() == 5)
                 .distinct()
                 .sorted()
                 .forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        boolean anyMatchLoc = asListLoc.stream()
                                       .distinct()
                                       .anyMatch(s -> "osman".equals(s));

        System.out.println("--------------------------------------------------");

        asListLoc.stream()
                 .distinct()
                 .sorted()
                 .parallel()
                 .skip(3)
                 .limit(4)
                 .peek(g -> System.out.println("Geçen data : "
                                               + g
                                               + " Thread : "
                                               + Thread.currentThread()
                                                       .getName()))
                 .map(p -> p.length())
                 .filter(l -> l > 3)
                 .forEach(g -> System.out.println("String length : "
                                                  + g
                                                  + " Thread : "
                                                  + Thread.currentThread()
                                                          .getName()));
        List<Integer> collectLoc = asListLoc.stream()
                                            .distinct()
                                            .sorted()
                                            .parallel()
                                            .skip(3)
                                            .limit(4)
                                            .peek(g -> System.out.println("Geçen data : "
                                                                          + g
                                                                          + " Thread : "
                                                                          + Thread.currentThread()
                                                                                  .getName()))
                                            .map(p -> p.length())
                                            .filter(l -> l > 3)
                                            .collect(Collectors.toList());
        Integer reduceLoc = asListLoc.stream()
                                     .distinct()
                                     .sorted()
                                     .parallel()
                                     .skip(3)
                                     .limit(4)
                                     .peek(g -> System.out.println("Geçen data : "
                                                                   + g
                                                                   + " Thread : "
                                                                   + Thread.currentThread()
                                                                           .getName()))
                                     .map(p -> p.length())
                                     .filter(l -> l > 3)
                                     .reduce(0,
                                             (a,
                                              b) -> a + b);

        System.out.println(reduceLoc);

        IntSummaryStatistics summaryStatisticsLoc = asListLoc.stream()
                                                             .distinct()
                                                             .sorted()
                                                             .parallel()
                                                             .skip(3)
                                                             .limit(4)
                                                             .peek(g -> System.out.println("Geçen data : "
                                                                                           + g
                                                                                           + " Thread : "
                                                                                           + Thread.currentThread()
                                                                                                   .getName()))
                                                             .mapToInt(s -> s.length())
                                                             .summaryStatistics();
        System.out.println(summaryStatisticsLoc);

    }


}
