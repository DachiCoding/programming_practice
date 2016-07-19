/**
 * Created by Dachi on 16/7/2.
 */
public class DataTypeTest {
    public static void main(String args[]){
        //Numerical
        //Byte, Short, Integer, Long, Float, Double
        byte b = 68;

        short s = 100;

        int dec = 100;
        int oct = 0144;
        int hex = 0x64;

        long l = 100;

        float f = 3.14159f;

        double d = 3.14159;

        //Alphabetic
        char c1 = '\u0001';
        String str1 = "\u0001";

        //Array
        char[] carr = {'H','e','l','l','o'};
        String str2 = new String(carr);

        //Casting
        double d1 = 3.2;
        double d2 = 3.9999;
        int i1 = (int) d1;
        int i2 = (int) d2;
        double d3 = (double) i2;

    }
}
