/**
 * Created by Dachi on 16/7/23.
 */

import java.util.*;

public class LeetCode_18 {

    public static boolean bs(int[] nums, int target, int beg){
        int end = nums.length - 1;
        int mid = 0;

        while(beg <= end){
            mid = beg + (end-beg)/2;
            if(nums[mid] == target){
                return true;
            } else if (nums[mid] < target){
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums == null || nums.length < 4) return result;

        Arrays.sort(nums);

        int sum;
        List<Integer> list;

        for(int i = 0; i < nums.length - 3; i++){
            sum = 0;
            list = new ArrayList<Integer>();
            list.add(nums[i]);

            for(int j = i + 1; j < nums.length - 2; j++){

                list.add(nums[j]);

                for(int k = j + 1; k < nums.length - 1; k++){
                    list.add(nums[k]);
                    sum = nums[i] + nums[j] + nums[k];
                    if(bs(nums,target-sum,k+1)){
                        list.add(target-sum);
                        result.add(new ArrayList<Integer>(list));
                        list.remove(list.size()-1);
                    }
                    list.remove(list.size()-1);
                }

                list.remove(list.size()-1);
            }

            list.remove(list.size()-1);
        }

        return result;

    }

    public static void main(String[] args){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        fourSum(nums,target);
    }


}
