package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        newGetMostInputWordsN(in.nextLine());
    }


    public static void newGetMostInputWordsN(String inputString) {
        Arrays.stream(inputString
                .toLowerCase()
                .replaceAll("(?:[!,.?^_]|-)", " ")
                .split(" "))
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(11)
                .map(Map.Entry::getKey)
                .forEachOrdered(System.out::println);
    }

}
