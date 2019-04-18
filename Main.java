package com.company;

import javafx.util.Pair;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, " +
                "faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum " +
                "eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor " +
                "lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel " +
                "odio nec mi tempor dignissim.";
        String[] answer = getMostInputWords(str);
        Arrays.stream(answer).forEachOrdered(System.out::println);
    }

    public static String[] getMostInputWords(String inputString) {
        inputString = inputString.replaceAll("[,.]", "").toLowerCase();
        String[] stringArr = inputString.split(" ");
        List<Pair<String, Integer>> pairList = new ArrayList();
        for (String currentString : stringArr) {
            int count = (int) Arrays.stream(stringArr).filter(currentString::equals).count();
            pairList.add(new Pair<>(currentString, count));
        }
        Comparator<Pair<String, Integer>> comparator = Comparator.comparing(Pair::getValue, Comparator.reverseOrder());
        comparator = comparator.thenComparing(Pair::getKey);
        pairList.sort(comparator);
        pairList = removeDuplicates((ArrayList<Pair<String, Integer>>) pairList);
        String[] answer = new String[10];
        for (int i = 0; i < 10; i++) {
            answer[i] = pairList.get(i).getKey();
        }
        return answer;
    }

    private static ArrayList removeDuplicates(ArrayList list) {
        ArrayList newList = new ArrayList();
        for (Object element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

}
