
/*
 *
 * @author_name: Amogh Sirohi
 * @author_name: Khushal Pujara
 */
public class  Ex1  {

    int          instanceVariable;
    static    int  classVariable;
    static    int  itIsMe;
    final     int  finalVariable;
    volatile  int  volatileVariable;
    transient int  transientVariable;


    public Ex1()   {
        finalVariable = 42;
    }
    public Ex1(int aLocalVariable) {
        itIsMe = 1;
        finalVariable = 43;
    }
    public Ex1(int aLocalVariable, int itIsMe) {
        finalVariable = 43;       // explain the error if this would be commented out
        // The error would be finalVariable might not have been initialized.
        // We have initialise all final variable in all constructors if not already initialised.
        itIsMe = aLocalVariable;
    }
    void instanceMethod()  {
        instanceVariable = 22;
        classVariable = 33;
    }
    static void classMethod()  {
        classVariable = 3;
    }

    public static void main(String args[] )    {
        Ex1 aEx1 = new Ex1();
        Ex1 bEx1 = new Ex1();
        Ex1 cEx1 = new Ex1(1);
        Ex1 dEx1 = new Ex1(1, 2);


        aEx1.instanceMethod();
        //instanceMethod();         // Will this compile? No!

        // If not explain the compiler error in your own words
        // We will need an object of the class to access this method.
        // Thus, we make it a class method to make it accessible by giving an object.

        // Modification to not give error, as
        bEx1.instanceMethod();

        bEx1.classMethod();

        /* What are the values of all instance variables of aEx1 and bEx1
          aEx1
            instanceVariable = 22
            classVariable = 3
            (static)itIsMe = 1
            finalVariable = 42
            volatileVariable = 0
            transientVariable = 0

          bEx1
            instanceVariable = 22
            classVariable = 3
            (static)itIsMe = 1
            finalVariable = 42
            volatileVariable = 0
            transientVariable = 0

         What is the value of aEx1.finalVariable?
         42
         What is the value of bEx1.finalVariable?
         42
         What is the value of cEx1.finalVariable?
         43
         What is the value of dEx1.finalVariable?
         43
         */
    }
}

