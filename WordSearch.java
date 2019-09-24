/*
author name: Khushal Pujara
author name: Amogh Sirohi
*/


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WordSearch {

    public static void main(String[] args) throws FileNotFoundException {
        
        File text = new File("/Users/khushalpujara/Desktop/word_puzzle.txt");
        
        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        Scanner sc = new Scanner(System.in);
        System.out.println("Word to search for");
        String stringg = sc.nextLine();
        String rev = new StringBuilder(stringg).reverse().toString();

        int lineNumber = 0;
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();

            if(line.contains(stringg) || line.contains(rev))
            {
                System.out.println("Found "  + stringg + " in row:" + lineNumber +" "+ line);
            }
            lineNumber++;

        }
        //Scanning columns
        for(int i=0;i<5;i++)
        {
            Scanner scnr1 = new Scanner(text);
            String line1="";
            while (scnr1.hasNextLine()) {
                line1 = line1 + scnr1.nextLine().charAt(i);
            }
            if(line1.contains(stringg) || line1.contains(rev))
            {
                System.out.println("Found "  + stringg + " in column:" + i +" "+ line1);
            }
        }
    }
}