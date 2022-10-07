package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class DivideNumbersTask implements Runnable {
    private List<Integer> numbers;
    private int divider;

    public DivideNumbersTask(List<Integer> numbers, int divider) {
        this.numbers = numbers;
        this.divider = divider;
    }

    @Override
    public void run(){
        System.out.println(numbers.stream().filter(n -> n%divider == 0).collect(Collectors.toList()));
    }
}
