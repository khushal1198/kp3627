package com.company;

public class StringThing {
    public static void method(String id, String literal, String aNewString)	{
        System.out.println(id + ".	" + (literal == aNewString ));
    }
    public static void main( String args[] ) {
        String aString = "654";
        String bString = "654";
        String cString = "6" + "54";

        System.out.println("I.	" +     bString == aString   ); // Concatenation happens before the reference comparision (Flase - new strings generated)
        System.out.println("II.	" +     ( bString == aString )   ); // String reference comparison happens before concatenation (True - No new string generated)
        System.out.println("III	" +     ( bString  + "" == aString )   ); //
        System.out.println("IV.	" +     ( ( bString  + "" ) == aString )   ); //Same as above - New literal generated
        System.out.println("V.	" +     ( ( "" + bString  ) == aString )   ); //Same as above - New literal generated


        System.out.println("a.	" +     "654" == aString   ); // Left to right reading - no new literal generated
        System.out.println("b.	" +   ( "65" + 4 == aString ) ); // Concatenation of "65" and 4, gives 654 which holds the same memory address as astring - No new literals
        System.out.println("c.	" +   aString  + 6 * 54 ); // Computation of multiplication happens first, then concatenation takes place - no new Literal
        System.out.println("d.	" +   654 + 4  + aString  ); // As string occured first, everything will be treated as a string so 654 + 4 = 6544
        System.out.println("e.	" +   ( 654 + 4 ) + aString   ); // As there are parenthesis is the expression, it'll be given higher priority - New String
        System.out.println("f.	" +   ( 654 - 5 + "" +  4 + aString )  ); // NEW LITERAL Computation occurs left to right, as there are no strings before numbers , arithimatic operations can take place - New String
        System.out.println("g.	" +   654 * 4 + aString  ); // Multiplication is given higer priority over concatenation - New String
        System.out.println("h.	" +   654 / 1 + aString  ); // Division is given higer priority over concatenation - New String
        System.out.println("i.	" +   ( 654 - 0 )  + aString  );// As there are parenthesis is the expression, it'll be given higher priority - New String
        System.out.println("j.	" +     ( "654" == aString )   ); //Same literal
        System.out.println("g.	" +     ( "65" + "4" == "654"  )   );  //Concatenation happens first in runtime, then comparision
        System.out.println("h.	" +     ( "654" == cString )   );//Concatnation happens first in runtime, then comparision

        method("1", "xyz", "x" + "yz");
        method("2", "xyz", "x" + "y" +"z");
        method("3", "6" + "5" + "4", "6" + 5 * 6 + 4);
        method("4", "xyz", new String("x") + "yz" );
        method("5", "6" + "5" + "4", "6" + (4 - 6)  + 4);
        method("6", "6" + "5" + "4", "6" + 5 + 4);
    }
}
