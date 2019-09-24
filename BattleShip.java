

/*
        Implementation of a one person battleship game
        The ocean of the battleship scenario is square. It is up to you to create the battleship scenario;
        Your program should print the battleship scenario and then prompt the user for column/row position.
        The program ends when all parts of all boats are hit. A hit of the middle piece of a boat sinks the
        complete boat, if this is the first hit.

        Assumptions:
        1.  Water is represented by '0' and a boat is represented by '1'
        2.  For boats of odd size there is an option of bonus hit i.e if
        hit in the middle part and it is first hit then the boat sinks
        but can not be applied to even boat.

@author name: Khushal Pujara
@author name: Amogh Sirohi
        */

        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;

public class BattleShip {
    public static void main(String[] args) throws FileNotFoundException {

        //Input file name
        File text = new File("/Users/khushalpujara/Desktop/battle.txt");
        System.out.println("BattleField file name:" + text);

        //For reading from the given input file
        Scanner scanner1 = new Scanner(text);
        String line = scanner1.nextLine();
        int sizeOfMatrix = line.length();

        //For our ocean
        Scanner scanner2 = new Scanner(text);
        int[][] ocene = new int[sizeOfMatrix][sizeOfMatrix];

        //For manipulation of x coordinate and y coordinate
        Scanner scanner3 = new Scanner(System.in);

        //to convert the file into our desired format i.e '.' and 'X' or 'x'
        for (int i = 0; i < sizeOfMatrix; i++) {
            line = scanner2.nextLine();
            for (int j = 0; j < sizeOfMatrix; j++) {
                if (line.charAt(j) == '.') {
                    ocene[i][j] = 0;
                } else if (line.charAt(j) == 'X' || line.charAt(j) == 'x') {
                    ocene[i][j] = 1;
                }
            }
        }

        //As long as there are boats we enter the while loop
        int flag = counts(ocene);
        while(flag!=0) {

            //In case if you want to view the ocean
            for(int i = 0;i < sizeOfMatrix ; i++)
            {
                for(int j = 0; j< sizeOfMatrix ; j++)
                {
                    System.out.print(ocene[i][j]);
                }
                System.out.println();
            }

            //Assigning value to x coordinate
            System.out.println("row coordinate (0 <= row    < 2):");
            int xco = scanner3.nextInt();

            //Assigning value to y coordinate
            System.out.println("row coordinate (0 <= column < 2):");
            int yco = scanner3.nextInt();

            /*
            Here we declare 4 variables which help us traverse to an adjacent location
            and scan for a boat and if a boat is found we set their value to 1.
            xright - to move right on x-axis
            xleft - to move left on x-axis
            ytop - to move up on y-axis
            ybottom - to move down on y-axis
            */

            int xright=0,xleft=0,ytop=0,ybottom=0;
            for (int i = 0; i < sizeOfMatrix; i++) {
                for (int j = 0; j < sizeOfMatrix; j++) {
                    if (ocene[xco][yco] == 1) {
                        //If coorindate is 1 print "HIT"
                        System.out.println("HIT");

                        //To check edge cases for x i.e if x coordinate is at a corner of a matrix
                        if(xco!=sizeOfMatrix-1) {
                            if (xco == sizeOfMatrix-2) {
                                if (ocene[xco + 1][yco] != 0)
                                    ytop = 1;
                            } else
                                for (int in = xco + 1; ocene[in][yco] != 0 && in <= sizeOfMatrix-1 && in >= 0; in++) {
                                    //System.out.println(in);
                                    if (in == sizeOfMatrix-1)
                                        break;
                                    ytop++;
                                }
                        }

                        //Generic case for x
                        if(xco!=0) {
                            if (xco == 1) {
                                if (ocene[xco - 1][yco] != 0)
                                    ybottom = 1;
                            }
                            else
                            {
                                for (int in = xco - 1; ocene[in][yco] != 0 && in <= sizeOfMatrix-1 && in >= 0; in--) {
                                    ybottom++;
                                }
                            }
                        }

                        //To check edge cases for y i.e if y coordinate is at a corner of a matrix
                        if(yco!=sizeOfMatrix-1) {
                            if (yco == sizeOfMatrix-2) {
                                if (ocene[xco][yco + 1] != 0)
                                    xright = 1;
                            }
                            else
                            {
                                for (int in = yco + 1; ocene[xco][in] != 0 && in <= sizeOfMatrix-1 && in >= 0; in++) {

                                    xright++;
                                }
                            }
                        }

                        //Generic case for y
                        if(yco!=0) {
                            if(yco == 1)
                            {
                                if(ocene[xco][yco-1]!=0)
                                    xleft=1;
                            }
                            else {
                                for (int in = yco - 1; ocene[xco][in] != 0 && in <= sizeOfMatrix-1 && in >= 0; in--) {

                                    xleft++;
                                }
                            }
                        }

                        //To check if the y coordinate is at the middle of the boat
                        if (xright == xleft ) {
                            for (int del = 1; del <= xright ; del++) {
                                ocene[xco][yco + del] = 0;
                                ocene[xco][yco - del] = 0;
                            }
                        }

                        //To check if the x coordinate is at the middle of the boat
                        if (ytop == ybottom && ytop!=0) {
                            for (int del = 1; del <= xright  ; del++) {
                                ocene[xco + del][yco] = 0;
                                ocene[xco - del][yco] = 0;
                            }
                        }
                        ocene[xco][yco] = 0;
                        System.out.println();
                    }
                }
            }

            flag = counts(ocene);
            if(flag == 0) //if no more boats are left then it gives this alert
            {
                System.out.println("No boat left");
            }
        }
    }

    //To maintain the count of the boats
    public static int counts(int[][] ocene )
    {
        int countz=0;
        for(int i = 0;i < ocene.length ; i++)
        {
            for(int j = 0; j< ocene.length ; j++)
            {
                if(ocene[i][j]==1)
                {
                    countz++;
                }
            }
        }
        return countz;
    }
}
