/**
 * Created by Dachi on 16/8/2.
 *
 *
 */

import java.util.Scanner;
import java.util.HashMap;


public class WY_Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        HashMap map = new HashMap();
        int result = 0;
        for(int i = 0; i < str.length()-1; i++){
            for(int j = i + 1; j < str.length(); j++){
                String temp = str.substring(0,i) + str.substring(i+1,j) + str.substring(j+1);
                if(map.get(temp) == null){
                    map.put(temp,1);
                    result++;
                }
            }
        }

        System.out.println(result);

    }

}
