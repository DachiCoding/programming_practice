import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LeetCode {
	public static void main(String args[]){

		System.out.println(firstBadVersion(2126753390));
	}
	
	public static boolean isBadVersion(int i) {
		//int firstBadVersion = 1702766719;
		int firstBadVersion=1702766719;
		if (i < firstBadVersion)
			return false;
		else
			return true;
	}
	
	public static int firstBadVersion(int n) {
		if(n==1) return 1;
		int firstBadPosition = 1;
		int left = 1;
		int right = n;
		int checkPosition = (left + right) / 2;
		boolean ifFoundFirstBadVersion=false;
		while (!ifFoundFirstBadVersion) {
			if (isBadVersion(checkPosition)) {
				if(checkPosition>1){
					if(isBadVersion(checkPosition-1)){
						firstBadPosition = checkPosition;
						right = checkPosition;
						checkPosition =left+ (right-left) / 2; 
					} else{
						ifFoundFirstBadVersion=true;
						firstBadPosition = checkPosition;
					}
				} else {
					ifFoundFirstBadVersion=true;
					firstBadPosition = checkPosition;
				}
				
			} else {
				left = checkPosition + 1;
				checkPosition = left+ (right-left) / 2;
			}		
		}
		return firstBadPosition;
	}
	
    public static boolean isUniValueTree(TreeNode root){
        if(root == null) return false;
        if(root.left == null && root.right == null) return true;
        
        if(root.left != null && root.right != null){
            return (root.val == root.left.val && root.val == root.right.val && isUniValueTree(root.left) && isUniValueTree(root.right));
        } else if(root.left != null){
            return (root.val == root.left.val && isUniValueTree(root.left));
        } else {
            return (root.val == root.right.val && isUniValueTree(root.right));
        }
    }

    public static int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int lt = 0;
        int rt = 0;
        
        if(root.left != null && root.right != null){
            lt = countUnivalSubtrees(root.left);
            rt = countUnivalSubtrees(root.right);
            if(isUniValueTree(root.left) && isUniValueTree(root.right) && root.val == root.left.val && root.val == root.right.val) return lt+rt+1;
            else return lt+rt;
        } else if(root.left != null){
            lt = countUnivalSubtrees(root.left);
            if(isUniValueTree(root.left) && root.val == root.left.val) return lt + 1;
            else return lt;
        } else {
            rt = countUnivalSubtrees(root.left);
            if(isUniValueTree(root.right) && root.val == root.right.val) return rt + 1;
            else return rt;
        }
    }
	
    public static String multiply(String num1, String num2) {
        long d1 = Long.parseLong(num1);
        long d2 = Long.parseLong(num2);
        long d3 = d1 * d2;
        String str = Long.toString(d3);
        return str;
    }
    
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int m = nums.length;
        
        int[][] dp = new int[m][m];
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < m; j++){
        		dp[i][j] = 1;
        	}
        }
        
        for(int i = 0; i < m - 1; i++){
            for(int j = i + 1; j < m; j++){
                if(nums[j] > nums[i]){
                    if(nums[j] > nums[j-1]){
                        dp[i][j] = dp[i][j-1] + 1;    
                    } else {
                        dp[i][j] = dp[i][0] + 1;         
                    } 
                }  
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max,dp[i][j]);    
            }
        }
        
        return max;
    }
    
    public static int binarySearch(int[] array, int num, int beg){
        int end = array.length - 1;
        int mid = 0;
        
        while(beg <= end){
            mid = beg + (end - beg) / 2;
            if (array[mid] == num){
                return mid;
            } else if (array[mid] < num){
                beg = mid + 1; 
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    public static List<List<Integer>> threeSum2(int[] nums) {
        //O(n^2*log(n))
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int sum = nums[i] + nums[j];
                int third = binarySearch(nums,0-sum,j+1);
                if(third > 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[third]);
                    result.add(temp);
                }
            }
        }
        return result;
    }
	
    public static int nodeCount(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    
    public static ListNode getLast(ListNode head){
        while(head.next != null){
            head = head.next;
        }
        return head;
    }
    
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        int size = nodeCount(head);
        if(size <= 2) return head;
        
        int time = size / 2;
        if(size % 2 == 0) time--;
        
        ListNode node = head;
        
        while(time > 0){
            ListNode tail = getLast(node);
            tail.next = node.next;
            node.next = node.next.next;
            tail.next.next = null;
            node = node.next;
            time--;
        }
        
        if(size % 2 == 0){
            ListNode tail = getLast(node);
            tail.next = node.next;
            node.next = node.next.next;
            tail.next.next = null;
        }
        
        return head;
    }
	
    public static boolean verifyPreorder(int[] preorder) {
        /*
            Pre-order: root-left-right
        */
        if(preorder == null || preorder.length <= 1) return true;
        int numL = 1;
        int numR = 0;
        
        if(preorder[1] > preorder[0]){
        	numL = 0;
        } else {
            while(numL < preorder.length && preorder[numL] < preorder[0]){
                numL++;
            }
            numL--;
        }

        numR = preorder.length - 1 - numL;
        
        int[] leftTree = new int[numL];
        int[] rightTree = new int[numR];
        
        if(numL != 0){
            for(int i = 0; i < numL; i++){
                leftTree[i] = preorder[i+1];
            }    
        }
        if(numR != 0){
            for(int i = 0; i < numR; i++){
                rightTree[i] = preorder[i+1+numL];
            }
        }
        
        
        if(numL == 0){
            return (preorder[0] < preorder[1]) && verifyPreorder(rightTree);
        } else if (numR == 0){
            return (preorder[0] > preorder[1]) && verifyPreorder(leftTree);
        } else {
            return (preorder[0] < preorder[1]) && verifyPreorder(rightTree) &&
                   (preorder[0] > preorder[1]) && verifyPreorder(leftTree);
        }
        
    }
	
    public static int shortestWordDistance(String[] words, String word1, String word2) {
        /*
         Scen1: word1 != word2
         Scen2: word1 == word2
        */
        List<Integer> word1Idx = new ArrayList<Integer>();
        List<Integer> word2Idx = new ArrayList<Integer>();
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)) word1Idx.add(i);
            if(words[i].equals(word2)) word2Idx.add(i);
            if(!word1Idx.isEmpty() && !word2Idx.isEmpty()){
                if(Math.abs(word1Idx.get(word1Idx.size()-1) - word2Idx.get(word2Idx.size()-1)) < result)
                  result = Math.abs(word1Idx.get(word1Idx.size()-1) - word2Idx.get(word2Idx.size()-1));
            }
        }
        
        if(word1.equals(word2)){
            for(int i = 1; i < word1Idx.size();i++){
                if(result > (word1Idx.get(i) - word1Idx.get(i-1))){
                    result = word1Idx.get(i) - word1Idx.get(i-1);
                }
            }
        }
        
        return result;
    }
	
    public static int[][] multiply(int[][] A, int[][] B) {
        int row = A.length;
        int mid = A[0].length;
        int col = B[0].length;
        
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < mid; k++){
                    result[i][j] += A[i][k]*B[k][j];
                }
            }
        }
        return result;
    }
	
    public static void reverseWords(char[] s) {
        
        List<String> list = new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length; i++){
            if(s[i] != ' '){
                sb.append(String.valueOf(s[i]));
            } else {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        list.add(sb.toString());
        
        int count = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            String str = list.get(i);
            for(int j = 0; j < str.length();j++){
                s[count++] = str.charAt(j);
            }
            if(i != list.size() - 1) s[count++]=' ';
        }
    }
	
    public static int maxProduct(String[] words) {
        /*
        Cons1:
        Scen1: null array return 0
        Scen2: non null array
        Solu1: Brute-Force O(n^3)
        Solu2: O(n^2)
        */
                
        if(words == null || words.length == 0) return 0;
        int max = 0;
        int mul = 1;
        int noSameChar = 1;
        int mat[][] = new int[words.length][26];
        
        for(int i = 0; i < words.length - 1; i++){
            String str = words[i];
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j);
                mat[i][c-'a'] = 1;
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            noSameChar = 1;
            for(int j = 0; j < 26; j++){
                if((mat[i][j] & mat[i+1][j]) == 1) noSameChar = 0; 
            }
            mul = words[i].length()*words[i+1].length()*noSameChar;
            if(mul > max) max = mul;
        }
        
        return max;
        
    }
	
    public static List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //Null or empty array
        result.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return result;
        
        //Only one element in the array
        if(nums.length == 1){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        
        int[] partialNums = new int[nums.length-1];
        for(int i = 0; i < nums.length-1;i++){
            partialNums[i] = nums[i+1];
        }
        
        List<List<Integer>> temp = subsets(partialNums);
        
        for(int i = 0; i < temp.size(); i++){
            ArrayList<Integer> list1 = (ArrayList<Integer>) temp.get(i);
            ArrayList<Integer> list2 = new ArrayList<Integer>(list1);
            result.add(list1);
            list2.add(0,nums[0]);
            result.add(list2);
        }
        
        return result;
    }
	
    public static int findMin(int[] nums) {
        /*
        Assu1: asecending 
        Scen1: null or empty
        Scen2: not empty
            not rotated nums[0] < nums[1] < ... nums[n]
            rotated nums[x] < nums[n] < nums[0] < nums[1] ... where is x?
            
        Solu1: O(N) is too expensive, since array is already sorted
        */
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        
        int result = 0;
        int size = nums.length-1;
        
        if(nums[0] < nums[size]){
            return nums[0];
        } else {
            int beg = 0;
            int end = size;
            
            while(beg < size && end > 0){
                int mid = beg + (end-beg)/2;
                if(nums[mid] < nums[mid-1]){
                    result = nums[mid];       
                } else if (nums[mid] < nums[size]){
                    end = mid;
                } else {
                    beg = mid;
                }
            }
        }
        
        return result;
    }
    public static int bulbSwitch(int n) {
        /*
        Cons1:
        Scen1:
            lights[1,2,3,4,5,6,7,8,9,10...]
            r1: all on (true)
            r2: 2n => toggle (t-f, f-t)
            rn: n*n => toggle
        Solu1:
            add all lights[i] which is true
        */
        
        boolean lights[] = new boolean[n];
        int result = 0;
        
        for(int i = 0; i < lights.length; i++){
            lights[i] = true;
        }
        
        for(int i = 1; i < lights.length; i++){
            int step = i + 1;
            for(int j = i; j < lights.length; j+= step){
            	lights[i] = (lights[i] == true) ? false:true;
            }
        }
        
        for(int i = 0; i < lights.length; i++){
            if(lights[i] == true)
                result++;
        }
        
        return result;
    }
    
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
    public static int reverseBits(int n) {
        String str1 = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        String str2 = new StringBuilder(str1).reverse().toString();
        Long big = Long.parseLong(str2,2);
        return big.intValue();
    }
    
    public static String addBinary(String a, String b) {
        StringBuilder sb1 = new StringBuilder(a);
        StringBuilder sb2 = new StringBuilder(b);
        StringBuilder sb3 = new StringBuilder();
        String str1 = new String();
        String str2 = new String();
        
        if (a.length() > b.length()){
            for(int i = 0;  i < sb1.length() -sb2.length(); i++)
                sb2.insert(0,0);
        } else {
            for(int i = 0;  i < sb2.length() -sb1.length(); i++)
                sb1.insert(0,0);
        }
        str1=sb1.toString();
        str2=sb2.toString();
        
        int xor = 0;
        int int1 = 0;
        int int2 = 0;
        int result = 0;
        
        for(int i = str1.length() - 1; i >= 0 ; i--){
            int1 = Character.getNumericValue(str1.charAt(i));
            int2 = Character.getNumericValue(str2.charAt(i));
            result = ((int1-int2)^2-xor)^2;
            if(int1 == 1 && int2 == 1)
                xor = 1;
            else
                xor = 0;
            sb3.insert(0,Integer.toString(result));
        }
        
        if(int1 == 1 && int2 == 1)
          sb3.insert(0,1);

        return sb3.toString();    
    }
    
    public static void rotate(int[] nums, int k) {
        StringBuilder sb = new StringBuilder();
        int length = nums.length;
        
        for(int i = 0; i< length;i++)
          sb.append(Integer.toString(nums[i]));
        
        for(int i = 0; i < k; i++){
            char c = sb.charAt(length-1);
            sb.insert(0,c);
            sb.deleteCharAt(sb.length()-1);
        }
        
        for(int i = 0; i < sb.length()-1;i++){
            nums[i] = (int) sb.charAt(i);
        }
     }
    
    public static int titleToNumber(String s) {
        int result = 0;
        int length = s.length();
        for(int i = length-1; i >= 0; i--){
            int temp = (int) s.charAt(i) - 64;
            result += temp*(26^(length-1-i)); 
        }
        return result;
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    	LeetCode lc = new LeetCode();
    	
        ListNode Head = new ListNode(0);
        ListNode Move = Head;
        
        if(l1 == null && l2 == null)
            return null;
        
        while(l1 != null && l2 != null){
          if(l1 == null){
            Move.val = l2.val;
            Move.next = l2.next;
            return Head;
            
          } else if (l2 == null){
            Move.val = l1.val;
            Move.next = l1.next;
            return Head;
            
          } else if(l1.val >= l2.val){
              Move.val = l2.val;
              l2 = l2.next;
          } else {
              Move.val = l1.val;
              l1 = l1.next;  
          }
          Move.next = new ListNode(0);
          Move = Move.next;
        }
        
        return Head;
    }
    
    public static int compareVersion(String version1, String version2) {
        //Check if both null or empty
        //Check if only one of v1,v2 is null or empty
        //Compare when both are not empty, split the string by "."
        if (version1.equals(version2)){
            return 0;
        } else if (version1 == null || version1.trim()==""){
            return -1;   
        } else if (version2 == null || version2.trim()==""){
            return 1;
        } else {
            //both has .
            //only one has .
            //none has .
            int v1 = 0;
            int v2 = 0;
            String[] v1parts = null;
            String[] v2parts = null;
            
            if(version1.indexOf(".") < 0){
                v1 = Integer.parseInt(version1);
            } else {
                v1parts = version1.split("\\.");
            }
                
            if(version2.indexOf(".") < 0)
                v2 = Integer.parseInt(version2);
            else
                v2parts = version2.split("\\.");
                
            if(version1.indexOf(".") < 0 && version2.indexOf(".") < 0){
                float minus = (float) v1 - (float) v2;
                return (int)Math.signum(minus);
                
            } else if (version1.indexOf(".") < 0){
                v2 = Integer.parseInt(v2parts[0]);
                if(v1 == v2 && Integer.parseInt(v2parts[1]) != 0)
                	return -1;
                float minus = (float) v1 - (float) v2;
                return (int)Math.signum(minus);
                
            } else if (version2.indexOf(".") < 0){
                v1 = Integer.parseInt(v1parts[0]);
                if(v1 == v2 && Integer.parseInt(v1parts[1]) != 0)
                	return 1;
                float minus = (float) v1 - (float) v2;
                return (int)Math.signum(minus);
                
            } else {
                int length = Math.min(v1parts.length,v2parts.length);
                for(int i = 0; i < length; i++){
                    int n1 = Integer.parseInt(v1parts[i]);
                    int n2 = Integer.parseInt(v2parts[i]);
                    if(n1 > n2)
                        return 1;
                    else if (n1 < n2)
                        return -1;
                    else
                        continue;
                }
                if(v1parts.length > v2parts.length)
                    return 1;
                else if (v1parts.length < v2parts.length)
                    return -1;
                else
                    return 0;
            }
        }
    }
     public static class TreeNode {
    	     int val;
    	     TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }
    
    public static List<Integer> rightSideView(TreeNode root) {
        /*
        Solution: Recursive go through right path
        Scenario: null tree, right is null(endpoint), right is not null(keep going)
        Exception:
        */
        
        if (root == null)
            return new ArrayList();
            
        int value = root.val;
        List list1 = new ArrayList();
        list1.add(value);
            
        List result = new ArrayList();
        result.addAll(list1);
        
        if (root.right != null)
            result.addAll(rightSideView(root.right));
        
        return result;
        
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1 = 0;
        long n2 = 0;
        int ct = 0;
        
        while(l1 != null){
            n1 += Math.pow(10,ct)*l1.val;
            l1 = l1.next;
            ct++;
        }
        ct = 0;
        
        while(l2 != null){
            n2 += Math.pow(10,ct)*l2.val;
            l2 = l2.next;
            ct++;
        }
        
        long n3 = n1 + n2;
        
        ListNode l3 = new ListNode((int)n3%10);
        ListNode l4 = l3;
        n3 = n3/10;
        
        while(n3 >= 1){
            ListNode temp = new ListNode((int)n3%10);
            l3.next = temp;
            l3 = temp;
            n3 = n3/10;
        }
        return l4;
    }
  
    public static int factorial(int n){
        if(n == 0)
            return 1;
            
        int result = 1;
        while(n >= 1){
            result *= n;
            n--;
        }
        return result;
    }
    
    public static int permutation(int m,int n) {
        if(m == n || m == 0)
            return 1;
            
        return factorial(n)/(factorial(n-m)*factorial(m));
    }
    
    public static int climbStairs(int n) {
      /*
      Solution: 
        The options are actullay permutation question: how to insert x 1steps among y 2steps.
      x + 2y = n.
      
      4
      x:0 2 4
      y:2 1 0
      
      Scenario: 
        1.n if odd number: then x cannot be even
        2.n is even number: then x cannot be odd
        3.when computing: x >= y or x < y
      
      Excetpion:
      */
      int result = 0;
      int x, y;
      
      y = n / 2;
      if(n % 2 == 0)
        x = 0;
      else
        x = 1;
        
      if (n == 1)
        return 1;
        
      for( ; x <= n && y >= 0; x+=2,y--){
          if(x < y)
            result += permutation(x,y+1);
          else 
            result += permutation(y,x+1);
      }
     
      return result;
      
    }
    
    public static boolean wordPattern(String pattern, String str) {
        
        /*
        Solution:
        store letter in pattern to char array,
        split str to string array.
        put pat<i>,str<i> into hashMap.
          if key first appear, put
          if key is in map, check whether get(key) = words
        */
        
        Map wordMap = new HashMap();
        
        if(pattern == null || pattern.trim() == "" || str == null || str.trim() == "")
            return false;
        
        char[] pat = new char[pattern.length()];
        for(int i = 0; i < pattern.length(); i++){
            pat[i] = pattern.charAt(i);
        }
        
        String[] words = str.split(" ");
        
        if(pat.length != words.length)
            return false;
        
        for(int i = 0; i < pat.length; i++){
            if(wordMap.get(pat[i]) == null){
                wordMap.put(pat[i],words[i]);
            } else {
              if(wordMap.get(pat[i]) == words[i]){
                  continue;
              } else {
                  return false;    
              }
            }
        }
        
        return true;
    }
    
    public static int[] ShellSort(int[] nums){
        int size = nums.length;
        int h = 1;
        while (h < size/3){
            h = 3*h + 1;
        }
        while (h >= 1){
            for(int i = h; i < size; i++){
                for(int j = i; j >=h && nums[j] < nums[j-h]; j-=h){
                    int temp = nums[j];
                    nums[j] = nums[j-h];
                    nums[j-h] = temp;
                }
            }
            h = h/3;
        }
        return nums;
    }
    
    public static void wiggleSort(int[] nums) {
        int[] copy = nums;
        copy = ShellSort(copy);
        int lo = 0;
        int hi = copy.length-1;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = copy[lo];
                lo++;
            } else {
                nums[i] = copy[hi];
                hi--;
            }
        }
    }
    
    public static int shortestDistance(String[] words, String word1, String word2) {
        //brute-force: foreach word as word1, check foreach wordReamin as word2,calc distance
        
        List<Integer> word1Idx = new ArrayList<Integer>();
        List<Integer> word2Idx = new ArrayList<Integer>();
        
        for(int i = 0; i < words.length; i++){
            if(words[i] == word1){
                word1Idx.add(i);
                continue;
            }
            if(words[i] == word2){
                word2Idx.add(i);
                continue;
            }
        }
        
        int mini = words.length;
        int dist = 0;
        
        for(int i = 0; i < word1Idx.size(); i++){
            for(int j = 0; j < word2Idx.size(); j++){
                dist = Math.abs(word1Idx.get(i) - word2Idx.get(j));
                if (dist < mini){
                    mini = dist;
                }
            }
        }
        
        return mini;
        
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
        Cons1:
        
        Scen1: 
        
        Solu1: get the sum of every two numbers, put it in the map. <sum,[num1Idx,num2Idx]>
               loop thru each number and find the negative counterpart, and the idx of three number should not be same.
               T: O(n^2) S: O(n^2)
        */
        
        
        Map sumMap = new HashMap();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //O(n^2)
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int[] tempArr = {i,j};
                sumMap.put(nums[i]+nums[j],tempArr);
            }
        }
        
        //O(n), find negative counterpart comb for each number
        for(int i = 0; i < nums.length; i++){
            if(sumMap.get(0-nums[i]) != null){
                
                int[] temp = (int[])sumMap.get(0-nums[i]);
                
                if(i != temp[0] && i != temp[1]){
                    List<Integer> tempList = new ArrayList<Integer>();
                    if(nums[i] < nums[temp[0]] && nums[i] < nums[temp[1]]){
                        tempList.add(nums[i]);
                        tempList.add((nums[temp[0]] < nums[temp[1]]) ? nums[temp[0]]:nums[temp[1]]);
                        tempList.add((nums[temp[0]] < nums[temp[1]]) ? nums[temp[1]]:nums[temp[0]]);
                    } else if (nums[i] > nums[temp[0]] && nums[i] > nums[temp[1]] ){
                        tempList.add((nums[temp[0]] < nums[temp[1]]) ? nums[temp[0]]:nums[temp[1]]);
                        tempList.add((nums[temp[0]] < nums[temp[1]]) ? nums[temp[1]]:nums[temp[0]]);
                        tempList.add(nums[i]);
                    } else {
                        tempList.add((nums[temp[0]] < nums[temp[1]]) ? nums[temp[0]]:nums[temp[1]]);
                        tempList.add(nums[i]);
                        tempList.add((nums[temp[0]] < nums[temp[1]]) ? nums[temp[1]]:nums[temp[0]]);
                    }
                    result.add(tempList);
                }
            }
            
        }
        
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(result);
        result.clear();
        result.addAll(set);
        
        return result;
        
    }
    
    public static String convert(String s, int numRows) {
        //Calculate each char's row index in the zigzaged string, then collect char row by row.
        /*Pattern: 
        3row: 0,1,2,3z-4,5,6,7z
        4row: 0,1,2,3,4z,5z-6,7,8,9,10,11z,12z
        */                
        
        //Handle corner case
        if (s == null || s.trim() == ""){
            return "";
        }
        
        if(numRows == 1){ //if numRows is lower than 3 then it cannot be zigzag
            return s;
        } 
        
        //Setup variables
        int[] rowIdxs = new int[s.length()];
        
        int numOfMidChar = numRows - 2;
        int numOfCycleChar = numRows + numOfMidChar;
        
        if( numRows == 2){
            numOfCycleChar = 3;
        }
        StringBuffer sb = new StringBuffer();
        
        //Calcualte row index
        int cycle = 0;
        for(int i = 0; i < s.length(); i++){
            
            //Normalizing string index
            int temp = i - cycle*numOfCycleChar;
            int q = temp / numRows;
            int r = temp % numRows;
            
            if(numRows == 2){
                rowIdxs[i] = temp % 2;
                continue;
            }
            
            //Cycle +1
            if (q == 1 && r == 0){
                cycle++;
            }
            
            //Caluclate index
            if(q == 0){
                rowIdxs[i] = r;
            } else {
                rowIdxs[i] = numRows - (r+1);
            }
            
        }
        
        //Making string
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < rowIdxs.length; j++){
                if(rowIdxs[j] == i){
                    sb.append(String.valueOf(s.charAt(j)));
                }
            }
        }
        
        return sb.toString();
        
        
    }
    
    public static String intToRoman(int num) {
        /*
        Cons1: input is btw 1 and 3999
        Scen1: for each digit, find the corresponding roman numerals
        Scen2: replace 4,9,40,90,400,900 to subtractive notation (avoid 4 consectuvie same numerals)
               4*1,5+4*1,4*10,50+4*10,4*100,500+4*100
        Solu1: divide num by 10 each time and add the matching roman numerals to the sb 
        */
        
        //Establish number to roman numeral map
        int numArr[] = {1000,500,100,50,10,5,1};
        Map numMap = new HashMap();
        numMap.put(1,'I');
        numMap.put(5,'V');
        numMap.put(10,'X');
        numMap.put(50,'L');
        numMap.put(100,'C');
        numMap.put(500,'D');
        numMap.put(1000,'M');
        
        StringBuilder sb = new StringBuilder();
        
        int quo = 0, unit = 1000;
        
        for(int i = 0; i < 4; i++){
            quo = num / unit;
            num = num % unit;
            
            if(quo != 4 || quo != 9){
                //Scen1
                char numeral = (char)numMap.get(unit);
                for(int j = 0; j < quo; j++){
                    sb.append(String.valueOf(numeral));
                }
            } else {
                //Scen2
                if (quo == 4){
                    char numeral1 = (char)numMap.get(unit);
                    char numeral2 = (char)numMap.get(unit*5);
                    sb.append(String.valueOf(numeral1));
                    sb.append(String.valueOf(numeral2));
                } else if(quo == 9) {
                    char numeral1 = (char)numMap.get(unit);
                    char numeral2 = (char)numMap.get(unit*10);
                    sb.append(String.valueOf(numeral1));
                    sb.append(String.valueOf(numeral2));
                }
            }
            unit = unit / 10;
            
        }
        
        return sb.toString();
        
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        
        if(digits == null || digits.equals(""))
            return result;
            
        Map letterMap = new HashMap();
        letterMap.put(1,"");
        letterMap.put(2,"abc");
        letterMap.put(3,"def");
        letterMap.put(4,"ghi");
        letterMap.put(5,"jkl");
        letterMap.put(6,"mno");
        letterMap.put(7,"pqrs");
        letterMap.put(8,"tuv");
        letterMap.put(9,"wxyz");
        
        int num = digits.charAt(0) - '0';
        String str = (String) letterMap.get(num);
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            List<String> temp = letterCombinations(digits.substring(1));
            for(int j = 0; j < temp.size(); j++){
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(c));
                sb.append(temp.get(j));
                result.add(sb.toString());
            }
        }
        
        return result;
    }
    
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        /*
        Cons1: No
        Scen1: No overlap, r1.right is on left of r2.left, r1.bottom is top of r2.top
        Scen2: Partial overlap, what's the index of the overlapping rectangle.
        Scen3: Totally overlap
        */
        
        /* no overlap */
        if(A > G || C < E || B > H || F > D) return 0;
        
        /* total overlap */
        if(A == E && B == F && C == G && D == H) return (C-A)*(D-B);
        
        /* partial overlap */
        int h = 0;
        int v = 0;
        
        h = Math.min(C,G) - Math.max(A,E);
        v = Math.min(D,H) - Math.max(B,F);
        
        return Math.abs(h*v);
        
    }
    
}
