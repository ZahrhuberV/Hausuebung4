package com.beispiel2;

import java.util.List;
import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {
    private List<Integer> numbers;

    public SumTask(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Integer call() throws Exception {
        return numbers.stream().mapToInt(n -> n).sum();
    }
}
