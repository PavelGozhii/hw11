package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] answer = newGetMostInputWordsN(in.nextLine());
        Arrays.stream(answer).forEachOrdered(System.out::println);
    }


    public static String[] newGetMostInputWordsN(String inputString) {
        List<String> answer = Stream.of(inputString.toLowerCase().split("(?:[!,.?^_]|-)"))
                .flatMap(n -> Arrays.asList(n.split(" ")).stream())
                .collect(Collectors.toList()).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (n1, n2) -> {
                                    throw new IllegalStateException();
                                },
                                LinkedHashMap::new)).keySet().stream().limit(10)
                .collect(Collectors.toList());

        String[] strings = new String[10];
        IntStream.range(0, answer.size()).forEach(i -> strings[i] = answer.get(i));
        return strings;
    }

}
