

/*
        We have to implement the arguments  -f and -d.
        For example: The command-line argument -f1,3 means
        you have  to print field 1 to 3, and -dxyx means
        the delimiter between two fields is the string xyx.

@author name: Khushal Pujara
@author name: Amogh Sirohi
        */

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;

public class Cut {
    public static void main(String args[]) throws FileNotFoundException {

        //Storing arguments passed by command line

        String length="";       //[-fn,k]
        String delemeter="";    //[-dtext]
        String file = "";       //[-input fileName]

        int strt;               // used to get the starting integer for -f
        int endt;               // used to get the ending integer for -f

        String output="";

        for(int i = 0; i< args.length;i++) //A for loop to read the input
        {
            if(args[i].charAt(1)=='f'&& args[i].charAt(0)=='-')       //if we observe an "f" then we add it to length
            {
                length = length + args[i];
            }
            else if(args[i].charAt(1)=='d' && args[i].charAt(0)=='-') //if we observe an "d" then we add it to delemeter
            {
                delemeter = delemeter +  args[i];
            }
            else                                                      //else we add it to file
            {
                file =file + args[i];
            }
        }

        //Input file name and scanner input
        File text = new File("/Users/khushalpujara/Desktop/"+file);
        Scanner scnr = new Scanner(text);
        String line = scnr.nextLine();
        System.out.println(line);

        //Setting values for first and last integer in above created variables
        strt = Character.getNumericValue(length.charAt(2));
        endt = Character.getNumericValue(length.charAt(4));

        //We create an array called myArray to store and print values
        String[] myArray= new String[line.length()];

        for(int index1=0;index1<line.length();index1++)
        {
            myArray[index1]="";
        }

        int index3=0;
        for(int index2 =0 ;index2<line.length();index2++)
        {
            if(line.charAt(index2)==delemeter.charAt(2))
            {
                index2++;
                index3++;
            }
            myArray[index3] = myArray[index3] + line.charAt(index2);
        }

        for (int index4=strt-1;index4<endt;index4++)
        {
            System.out.print(myArray[index4]+" ");
        }
    }
}