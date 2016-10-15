
public class LeetCode_33 {
	   public static int binarySearch(int[] nums, int target, int beg, int end){
		    
	        int mid = 0;
	        
	        while(beg <= end){
	            mid = beg + (end-beg)/2;
	            if(target == nums[mid]){
	                return mid;
	            } else if (target > nums[mid]){
	                beg = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	        
	        return -1;
	    }
	    
	    public static int binaryRotateSearch(int[] nums){
	        
	        int beg = 0;
	        int end = nums.length - 1;
	        int mid = 0;
	        
	        int begNum = nums[0];
	        int endNum = nums[nums.length-1];
	        
	        while(beg <= end){
	            mid = beg + (end-beg)/2;
	            
	            if(nums[mid] > nums[mid+1]){
	                return mid;
	            } else if (nums[mid] > endNum){
	                beg = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	        
	        return -1;
	    }
	    
	    public static int search(int[] nums, int target) {
	        /* 
	        original array = arr1 + arr2 
	        rotated array = arr2 + arr1
	        if (nums[length-1] < nums[0]) => rotated,must find the turning point
	            i is the turning point if arr[i] > arr[i+1]
	        else
	            binary search
	        */
	        
	        if(nums == null || nums.length == 0) return -1;
	        if(nums.length == 1){
	            return nums[0] == target ? 0:-1;
	        }
	        
	        int size = nums.length;
	        int result = 0;
	        
	        if(nums[0] < nums[size-1]){
	            //not rotated
	            result = binarySearch(nums,target,0,size-1);
	        } else {
	            //rotated
	            int rotate = binaryRotateSearch(nums);
	            
	            if(target < nums[0]){
	                result = binarySearch(nums,target,rotate+1,size-1);
	            } else {
	                result = binarySearch(nums,target,0,target);
	            }
	        } 
	         
	        return result;
	    }
	    
	    public static void main(String[] args){
	    	int[] arr = {3,1};
	    	search(arr,3);
	    }
}
