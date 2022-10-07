package com.beispeil1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int divider = 0;
        int chunks = 0;
        ReadFile readFile =  new ReadFile();
        ArrayList<Integer> numbers = readFile.readNumbers();


        while(true){
            try{
                System.out.print("Chunks:");
                chunks = Integer.parseInt(s.nextLine());
                System.out.print("Divider:");
                divider = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e){
                System.out.println("Keine Richtige Zahl");
                continue;
            }


        }
        ThreadPoolExecutor executor = (ThreadPoolExecutor)
                Executors.newFixedThreadPool(chunks);

        for (int i = 0; i < chunks; i++) {
            List<Integer> chunk = numbers.subList(i * (numbers.size()/chunks), (i+1) * (numbers.size()/chunks));
            DivideNumbersTask task = new DivideNumbersTask(chunk, divider);
            executor.execute(task);
        }
        executor.shutdown();

    }
}
