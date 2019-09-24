//package com.company;

import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        for (int i = 1; i <= 15; i++) {

            int l = i;
            int factor1 = 0, factor2 = 0;
            outerloop:
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    factor1 = j;
                    i = i / factor1;
                    for (int k = j; k < l; k++) {

                        if (i % k == 0) {
                            factor2 = k;
                            i = i / factor2;
                            for (int x = k; x < l; x++) {
                                if (i % x == 0) {
                                    //System.out.println("k not 2");
                                    factor1 = 0;
                                    factor2 = 0;
                                    break outerloop;
                                }

                            }
                        }
                    }
                }
            }
            if (factor1 == 0) {

            } else {
                System.out.println("The sum of all prime factors of  " + l + ":   " + (factor1 + factor2) + " ( " + factor1 + " + " + factor2 + " )");
            }
            i=l;
        }
    }
}
