/**
 * Created by Dachi on 16/8/2.
 */

import java.util.Scanner;

public class WY_Q2 {
    public static void main(String[] args) {

        public static boolean moreZeros(String str){
            int cnt = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '0') cnt++;
                else cnt--;
                return cnt > 0;
            }
        }

        public static boolean moreOnes(String str){
            int cnt = 0;
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == '1') cnt++;
                else cnt--;
                return cnt > 0;
            }
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String str = in.next();
            int result = 0;

            int i = 0;
            int j = str.length();

            for(int k = 0; k < str.length() - 1; k++){
                if( moreZeros(str.substring(i,k)) && moreOnes(str.subtring(k,j)) ){
                    if ((j - i + 1) > result) result = j - i + 1;
                } else if( moreZeros(str.substring(i,k)) ) {
                    i++;
                } else if( moreOnes(str.subtring(k,j)) ){
                    j--;
                } else {
                    i++;
                    j--;
                }
            }

            System.out.println(result);

        }

    }
}
