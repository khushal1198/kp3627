/**
 * This is a program which can determine if a combination
 * for all n ∈ givenWeight a combination elements ∈ of
 * weightSet exist, so such that the elements of the
 * givenWeight when added prints a possible combination
 * from the weightSet but the restriction that the unknown
 * weight on the left,and all other weights have to be
 * positioned on the right side of the scale does not apply
 *
 * @author      Khushal Pujara
 * @author      Amogh Sirohi
 */
​
package com.company;
​
public class BalanceScaleLeftRight {
​
    public static void main(String[] args) {
        int[] originalWeights = {5, 8, 12, 35, 61, 150, -5, -8, -12, -35, -61, -150};
        int[] toWeigh = {2, 3, 4, 8, 9, 40, 150, 151, 152};
​
​
        for(int weigh=0;weigh<toWeigh.length;weigh++) {
            int count = (int) Math.pow(2, originalWeights.length); //Power set i.e set of all subsets and int casting (int) for integer result
            outerloop:
            for (int index1 = 0; index1 < count; index1++) {
                int[] storage = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                int flag = 0;
                for (int index2 = 0; index2 < originalWeights.length; index2++) {
                    if ((index1 & (1 << index2)) > 0) {
                        for (int index3 = 0; index3 < originalWeights.length; index3++) {
                            if (storage[index3] == Math.abs(originalWeights[index2])){ //Absolute value of argument is returned to check if repeated
                                //System.out.println("Yes it got repeated");
                                break;
                            } else {
                                storage[flag] = originalWeights[index2];
                                flag++;
                                break;
                            }
                        }
                    }
                }
                int temp = 0;
                for (int index4 = 0; index4 < storage.length; index4++) {
                    if (storage[index4] != 0) {
                        temp = temp + storage[index4];
                    }
                }
                if(toWeigh[weigh]==temp) {
                    System.out.print(toWeigh[weigh]+"g:     yes; used myWeights = ");
                    for(int index5=0;index5<storage.length;index5++) {
                        if(storage[index5] != 0) {
                            System.out.print(storage[index5] + "g ");
                        }
                    }
                    System.out.println("");
                    break outerloop;
                }
            }
        }
    }
}