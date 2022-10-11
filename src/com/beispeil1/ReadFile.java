package com.beispeil1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public ArrayList<Integer> readNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("numbers.csv"))){
           while(true) {
               line = br.readLine();
               String[] parts = line.split(":");
               for(int i = 0; i < parts.length; i++) {
                   try {
                       numbers.add(Integer.parseInt(parts[i]));
                   } catch (NumberFormatException nfe){
                       continue;
                   }
               }
           }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.out.println("NullPointException");
        }

        return numbers;
    }
}
