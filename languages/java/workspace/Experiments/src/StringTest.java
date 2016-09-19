/**
 * Created by Dachi on 16/7/13.
 */
public class StringTest {

    public static void main(String args[]){
        String location = "Java";
        String greeting = "Hello" + location;

        int age = 42;
        String output = age + " years";
        System.out.println(output);

        location = "Hello, World!".substring(7,12);
        System.out.println(location);

        String names = "Peter,Paul,Mary";
        String[] result = names.split(",");

        /*
        String method list:
        startsWith
        endsWith
        contains

        indexOf
        lastIndexOf

        replace
        toUpperCase
        toLowerCase
        trim
         */

    }

}
