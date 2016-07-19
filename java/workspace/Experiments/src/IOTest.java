/**
 * Created by Dachi on 16/7/2.
 */

import java.io.*;
import java.util.Scanner;

public class IOTest {

    public static void scannerTest(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your age in years: ");
        double age = input.nextDouble();
        System.out.println("So you are " + age + " years old.");
    }

    public static void formatOutput(){
        //System.out.printf("%8.2f", 1000/3.0);

        Scanner in = new Scanner(System.in);

        System.out.println("What's your name?");
        String name =  in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        String message = String.format("Hello, %s. Next year, you'll be %d.\n", name,age);
        System.out.println(message);
    }

    public static void main(String args[]){

        //scannerTest();
        formatOutput();


    }
}
