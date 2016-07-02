
public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        for(int i = 0; i < numbers.length; i++){
            //use binary search
            int cursor = numbers[i];
            int search = target-numbers[i];
            numbers[i] = -1;
            
            int lo = 0;
            int hi = numbers.length;
            int mid = 0;
            while(lo < hi){
                mid = lo + (hi - lo)/2;
                if(numbers[mid] == search){
                    indexs[0] = i+1;
                    indexs[1] = mid + 1;
                    return indexs;
                } else if (search < numbers[mid]){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            
            numbers[i] = cursor;
        }
        return indexs;
    }
}
