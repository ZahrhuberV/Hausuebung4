package com.beispiel2;

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
        int border;
        System.out.println("n>");
        n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        final ExecutorService pool;

        if(n%100 == 0){
            pool = Executors.newFixedThreadPool(n/100);
            border = n/100;
        } else {
            pool = Executors.newFixedThreadPool(n/100 +1);
            border = n/100+1;
        }


        final List<SumTask> callables = new ArrayList<>();

        for (int i = 0; i < border; i++) {
            List<Integer> chunk = numbers.subList(i * 100, (i+1) * 100);
            callables.add(new SumTask(chunk));
        }

        int sumAll = 0;

        try {
            for (final Future<Integer> future :
                    pool.invokeAll(callables)) {
                System.out.println(future.get());
                sumAll = sumAll + future.get();
            }
        } catch (ExecutionException | InterruptedException ex) { }
        pool.shutdown();

        System.out.println("Sum:" + sumAll);

    }
}
