

/*
 *
 * author_name: Amogh Sirohi
 * author_name: Khushal Pujara
 */

public class  Ex {

    String anOtherVariable;
    int[]  aVariable = { 4, 2 };

    public void test1(String arg ){
        arg = "b";
    }
    public void test2(int[] aVariable ){
        aVariable[1] = 3;
    }
    public void test1(){
        anOtherVariable = "a";
        System.out.println("1. " + anOtherVariable);
        test1(anOtherVariable);
        //Check
        System.out.println("2. " + anOtherVariable);
    }
    public void test2(){
        System.out.println("3. " + aVariable[0] + ", " + aVariable[1]);
        test2(aVariable);
        //Check
        System.out.println("4. " + aVariable[0] + ", " + aVariable[1]);

    }
    public static void main(String args[]){
        new Ex().test1();
        /* String is a non primitive data type. Strings are immutable in nature
         changing the string value changes the reference also and in
         pass-by-value(String) of parameter passing the reference of objects cannot be
         changed by the function.
         We can add 'this.anOtherVariable = arg' to actually gain access
         or return the string from test1(String) and accept it in anOtherVariable in test1()
        */
        new Ex().test2();
        /* If alterations are made to the element of an int array then changes shall be reflected as int is a primitive data type
           and as they are passed by reference of the int array to the function test2(int[]) but as we are modifying the value of
           an integer element at a single position and not the reference of the entire array so it is allowed.
         */
    }
}

