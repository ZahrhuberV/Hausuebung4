package com.beispiel2;

import com.beispeil1.DivideNumbersTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Beispiel2Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("n>");
        n = s.nextInt();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }

        final ExecutorService pool =
                Executors.newFixedThreadPool(n/100+1);

        final List<SumTask> callables = new ArrayList<>();

        for (int i = 0; i < n/100; i++) {
            List<Integer> chunk = numbers.subList(i * (n/100), (i+1) * n/100);
            callables.add(new SumTask(chunk));
        }

        try {
            for (final Future<Integer> future :
                    pool.invokeAll(callables)) {
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException ex) { }
        pool.shutdown();

    }
}
