/*
author name: Khushal Pujara
author name: Amogh Sirohi
*/


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WordSearch2 {

    public static void main(String[] args) throws FileNotFoundException {

        File text = new File("/Users/khushalpujara/Desktop/word_puzzle1.txt");

        //Creating Scanner instance to read File in Java
        Scanner scnr = new Scanner(text);
        Scanner sc = new Scanner(System.in);
        System.out.println("Word to search for");
        String stringg =  sc.nextLine() ;
        String rev = ".*" + new StringBuilder(stringg).reverse().toString() + ".*";
        String str = ".*" + stringg + ".*"  ;

        //Pattern Matcher
        Pattern pattern = Pattern.compile(str);
        int lineNumber = 0;
        while (scnr.hasNextLine()) {
            String line = scnr.nextLine();
            String reverse = new StringBuilder(line).reverse().toString();
            Matcher matcher = pattern.matcher(line);
            Matcher matcher1 = pattern.matcher(reverse);
            boolean matches = matcher.matches();
            boolean matches1 = matcher1.matches();

            if(matches == true || matches1 == true)
            {
                System.out.println("Found "  + stringg + " in row:" + lineNumber +" "+ line);
            }
            lineNumber++;

        }

        //Scanning columns
        for(int i=0;i<3;i++)
        {
            Scanner scnr1 = new Scanner(text);
            String line1="";
            while (scnr1.hasNextLine()) {
                line1 = line1 + scnr1.nextLine().charAt(i);
            }
            String reverse1 = new StringBuilder(line1).reverse().toString();
            Matcher matcher2 = pattern.matcher(line1);
            Matcher matcher3 = pattern.matcher(reverse1);
            boolean matches2 = matcher2.matches();
            boolean matches3 = matcher3.matches();
            if(matches2 == true || matches3 == true)
            {
                System.out.println("Found "  + stringg + " in column:" + i +" "+ line1);
            }
        }
    }
}