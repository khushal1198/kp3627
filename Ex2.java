
/*
 * @author_name: Amogh Sirohi
 * @author_name: Khushal Pujara
 */
public class  Ex2  {
    int          instanceVariable;
    static    int  classVariable;
    static    int  itIsMe;
    final     int  finalVariable = 3;
    volatile  int  volatileVariable;
    transient int  transientVariable;


    public Ex2()   {
        //finalVariable = 42;     // why does this not compile?
        // Value of final variable has already been initialised and it can not be changed
    }
    public Ex2(int aLocalVariable) {
        itIsMe = 1;
        Ex1 aEx1 = new Ex1();     // is this valid? if yes why? Yes, as we have a public class is valid so creating its instance is valid
        Ex2 aEx2 = new Ex2();     // is this valid? if yes why? Yes, as we have a public class is valid so creating its instance is valid
    }
    public Ex2(int aLocalVariable, int itIsMe) {
        this.instanceMethod1();       // is this valid? if yes why?
        // Valid because instanceMethod1() calls constructor of public class

        //this = new Ex2();       // is this valid? if yes why?
        //Keyword THIS is a reference variable in Java that refers to the current object i.e the object whose method or constructor is being called.
        //By using this we can refer to any member of the current object from within an instance method or a constructor .
        itIsMe = aLocalVariable;
    }
    Ex1 instanceMethod1()  {
        new Ex1(2, 3);
        return new Ex1(2, 3);
    }
    Ex2 instanceMethod2()  {
        return new Ex2(2, 3);
    }
    static void classMethod()  {
        classVariable = 3;
    }

    public static void main(String args[] )    {
        Ex2 aEx2 = new Ex2();
        Ex2 bEx2 = new Ex2();
        Ex2 cEx2 = new Ex2(1);
        Ex2 dEx2 = new Ex2(1, 2);  // Q:how many objects do exist at this point in time?
        // A:  4 objects aEx2, bEx2, cEx2 and dEx2 remain in stack rest all
        //     were created and then marked for garbage collection as they
        //     are not used any further

        Ex1 aEx1 = aEx2.instanceMethod1(); // how many instance variable do exist  at this point in time
        // 16 instance variables of Ex2 objects and 4 instance variables of Ex1 object
        // Thus total of 20

        Ex2 eEx2 = aEx2.instanceMethod2(); // how many instance variable do exist  at this point in time
        // 20 plus 4 instance variables of Ex2 object
        // Thus total is 24

        for ( int index = 0; index < 10; index ++ )    {
            eEx2 = new Ex2(index, index * index);
        }
        // how many instance variable do exist  at this point in time?
        // On each iteration a new object is created and replaces the earlier object reference of eEx2
        // Old objects will be marked for garbage collection.
        // So instance variables number will remain constant which is 24
    }
}

