package com.company;

public class BalanceScale {

    public static void main(String[] args) {

        int[] myWeights= {1,6,9,24,110,115,62,202,203,204,205};
        int[] toWeigh = new int[]{ 1,5,8,12,35,61 };
        //int[] myWeights= { 1, 3, 4, 5, 7 };
        //int[] toWeigh = new int[]{ 1, 2, 3, 4, 5, 7, 8, 12, 20, 35, 61, 80 };


        for(int i=0;i< myWeights.length;i++)
        {
            int given_weight;
            given_weight=myWeights[i];
            outerloop:
            for(int first=0;first< toWeigh.length;first++)
            {
                if(given_weight == toWeigh[first])
                {
                    System.out.println(given_weight+"g:     yes; used myWeights = "+toWeigh[first]+"g");
                    break outerloop;
                }
                else
                {
                    int second;
                    second = toWeigh[first];
                    for(int z=first+1;z< toWeigh.length;z++)
                    {
                        int third=toWeigh[z];
                        if(second+third==given_weight)
                        {
                            System.out.println(given_weight+"g:     yes; used myWeights = "+third+"g "+second+"g" );
                            break outerloop;
                        }
                        else if(second+third<given_weight)
                        {
                            for(int l=z+1;l<toWeigh.length;l++)
                            {
                                int fourth=toWeigh[l];
                                if(second+third+fourth==given_weight)
                                {
                                    System.out.println(given_weight+"g:     yes; used myWeights = "+fourth+"g "+third+"g "+second+"g");
                                    break outerloop;
                                }
                                else if(second+third+fourth<given_weight)
                                {
                                    for(int c=z+1;c<toWeigh.length;c++)
                                    {
                                        int fifth=toWeigh[c];
                                        if(second+third+fourth+fifth==given_weight)
                                        {
                                            System.out.println(given_weight+"g:     yes; used myWeights = "+fifth+"g "+fourth+"g "+third+"g "+second+"g");
                                            break outerloop;
                                        }
                                        else if(second+third+fourth+fifth<given_weight)
                                        {
                                            for(int e=z+1;e<toWeigh.length-1;e++)
                                            {
                                                int f=toWeigh[e];
                                                if(second+third+fourth+fifth+f==given_weight)
                                                {
                                                    System.out.println(given_weight+"g:     yes; used myWeights = "+f+"g "+fifth+"g "+fourth+"g "+third+"g "+second+"g");
                                                    break outerloop;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
