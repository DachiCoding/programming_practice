/**
 * Created by Dachi on 16/8/2.
 */


import java.util.Scanner;

public class WY_Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int k = str.length()/2;
        int i = k;
        int j = k + 1;
        int ltIdx = i;
        int rtIdx = j;
        int ltCnt = 0;
        int rtCnt = 0;

        while(ltIdx >= 0){
            if (str.charAt(ltIdx) == '0') ltCnt++;
            else ltCnt--;
            if(ltCnt > 0) i = ltIdx;
            ltIdx--;
        }

        while(rtIdx < str.length()){
            if (str.charAt(rtIdx) == '1') rtCnt++;
            else rtCnt--;
            if(rtCnt > 0) j = rtIdx;
            rtIdx++;
        }

        int result = 0;

        if(i == k && j == k + 1) result = 0;
        else result = j - i + 1;

        System.out.println(result);

    }

}
