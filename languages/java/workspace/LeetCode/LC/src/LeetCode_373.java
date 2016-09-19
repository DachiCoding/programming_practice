/**
 * Created by Dachi on 16/7/25.
 */

import java.util.*;

public class LeetCode_373 {
    public List<int[]> kSmallestPairsSolution1(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0 ) return result;

        k = Math.min(nums1.length*nums2.length,k);

        int i = 0, j = 0;

        while(k-- > 0){

            int[] arr = {nums1[i],nums2[j]};
            result.add(arr);

            if(i == nums1.length - 1){
                i = 0;
                j++;
            } else if(j == nums2.length - 1){
                j = 0;
                i++;
            } else if(nums1[i+1] <= nums2[j+1]){
                i++;
            } else {
                j++;
            }

        }

        return result;
    }

    public static void main(String[] args){
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 10;
        //kSmallestPairsSolution1(nums1,nums2,k);
    }


}
