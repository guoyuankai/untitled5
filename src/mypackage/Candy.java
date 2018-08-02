package mypackage;

import java.io.Serializable;

public class Candy implements Serializable{
    private String mystring;
    public void myprint()
    {
        System.out.println("this is method ");
    }
    public static void myprint2()
    {
        System.out.println("this is static method ");
    }
    static
    {
        System.out.println("Loading candy from Static block");
    }
    public  static void main(String[] args)
    {
        System.out.println("Loading candy from main method");
    }
}
