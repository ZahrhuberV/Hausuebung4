package com.beispiel3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamsTester {

    public static void main(String[] args) {
        String[] array =  {"Hallo", "Welt", "", "und", "Niklas", "ok", "",};
        List<String> list = new ArrayList<>();
        list.addAll(List.of(array));
        int[] arrayint = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> numberlist = new ArrayList<>(arrayint.length);
        for (int i : arrayint) {
            numberlist.add(Integer.valueOf(i));
        }
        System.out.println(numberlist);

        System.out.println(getCountEmptyString(list));
        System.out.println(getCountLength3(list));
        System.out.println(deleteEmptyStrings(list));
        System.out.println(getMergedString(list, ";"));
        System.out.println(getSquares(numberlist));
        System.out.println(getMax(numberlist));
        System.out.println(getMin(numberlist));
        System.out.println(getSum(numberlist));
        System.out.println(getAverage(numberlist));


    }

    private static int getCountEmptyString(List<String> strings){
        return (int) strings.stream().filter(String::isEmpty).count();
    }

    private static int getCountLength3(List<String> strings){
        return (int) strings.stream().filter(n -> n.length()==3).count();
    }

    private static List<String> deleteEmptyStrings(List<String> strings) {
        return strings.stream().filter(n -> !n.isEmpty()).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator) {
        return strings.stream().collect(Collectors.joining(separator));
    }

    private static List<Integer> getSquares(List<Integer> numbers) {
        return numbers.stream().map(n -> n*n).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(v -> v)
                .max().orElse(-1);
    }

    private static int getMin(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(v -> v)
                .min().orElse(-1);
    }

    private static int getSum(List<Integer> numbers) {
        return numbers.stream().mapToInt(n -> n).sum();
    }

    private static int getAverage(List<Integer> numbers) {
        return (int) numbers.stream().mapToDouble(n -> n).average().orElse(-1);
    }
}
