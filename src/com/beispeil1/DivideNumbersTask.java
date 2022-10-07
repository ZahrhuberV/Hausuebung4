package com.beispeil1;

import java.util.List;
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
