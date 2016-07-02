import java.awt.List;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.function.IntPredicate;

import javax.swing.text.ChangedCharSetException;
import javax.swing.tree.TreeNode;

public class AmazonOA {
	
	public static class CPoints {
		int x;
		int y;
		
		public CPoints(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static class ListNode {
		
		ListNode next;
		int val;
		
		public ListNode(int x){
			this.val = x;
		}
	}
	
	public static class LRUNode {
		int val;
		int key;
		LRUNode prev;
		LRUNode next;
		
		public LRUNode(int val, int key){
			this.val = val;
			this.key = key;
		}
	}
	
	public static class LRUCache {
		int capactiy;
		int count;
		Map map;
		LRUNode head;
		LRUNode next;
		
		public LRUCache(int capactiy){
			
		}
		
		public void deleteNode(LRUNode node){
			
		}
		
		public void addToHead(LRUNode node){
			
		}
		
		public int get(int key){
			return -1;
		}
		
		public void set(int key, int value){
			
		}
		
	}
	
	public static class RectNode {
		int x;
		int y;
		
		public RectNode(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		
		public TreeNode(int x){
			this.val = x;
		}
	}
	
	public static class Container {
		public double first;
		public double second;
		
		public Container(double x, double y){
			this.first = x;
			this.second = y;
		}
	}
	
	public static class Process {
		public int aTime;
		public int eTime;
		
		public Process(int ATime, int ETime){
			aTime = ATime;
			eTime = ETime;
		}
	}
	
	public static void showChar(String[] strs){
		for(String s1: strs){
			for(int i = 0; i < s1.length();i++)
				System.out.print(Integer.toString(s1.charAt(i)-'A'+1)+",");
			System.out.println();
		}
	}	
	
	public static CPoints[] kCloestPoints(CPoints[] carr, int k){
		CPoints[] result = new CPoints[k];
		if (carr == null) return result;
		Comparator<CPoints> cmp = new Comparator<CPoints>() {
			public int compare(CPoints cp1, CPoints cp2){
				double d1 = cp1.x^2 + cp1.y^2;
				double d2 = cp2.x^2 + cp2.y^2;
				if (d1 > d2){
					return 1;
				} else if (d1 == d2){
					return 0;
				} else {
					return -1;
				}
			}
		};
		
		PriorityQueue<CPoints> pq = new PriorityQueue<AmazonOA.CPoints>(k,cmp);
		for(CPoints c: carr){
			pq.offer(c);
		}
		
		for(int i = 0; i < k; i++){
			result[i] = pq.poll();
		}
		
		return result;
	}
	
	public static void kCloestPointsTest(){
		CPoints[] carr = new CPoints[10];
		Random r = new Random();
		for(int i = 0; i < carr.length;i++){
			carr[i] = new CPoints(r.nextInt(10)+1, r.nextInt(10)+1);
			System.out.println(carr[i].x^2+carr[i].y^2);
		}
		System.out.println("---------------");
		
		CPoints[] sorted = kCloestPoints(carr,4);
		for(int i = 0; i < sorted.length;i++){
			System.out.println(sorted[i].x^2+sorted[i].y^2);
		}
	}
	
	public static boolean overlapRect(RectNode Atl, RectNode Abr, RectNode Btl, RectNode Bbr){
		if(Atl == null || Abr == null || Btl == null || Bbr == null) return false;
		
		if(Atl.x > Bbr.x || Abr.x < Btl.x || Atl.y < Bbr.y || Abr.y > Btl.y){
			return false;
		} else {
			return true;
		}
	}
	
	public static void overlapRectTest(){
		RectNode a1 = new RectNode(0, 2);
		RectNode a2 = new RectNode(3, 0);
		RectNode b1 = new RectNode(4, 0);
		RectNode b2 = new RectNode(6, -2);
		System.out.println(overlapRect(a1,a2,b1,b2));
		
		RectNode c1 = new RectNode(1, 5);
		RectNode c2 = new RectNode(3, 2);
		RectNode d1 = new RectNode(4, 2);
		RectNode d2 = new RectNode(5, -2);
		System.out.println(overlapRect(c1,c2,d1,d2));
	}
	
	public static String longestPalindromicString(String s){
		if(s == null || s.length() == 0) return "";
		int sz = s.length();
		boolean[][] dp = new boolean[sz][sz];
		
		int beg = 0;
		int end = 0;
		int max = 0;
		
		for(int i = 0; i < sz; i++){
			for(int j = 0; j < i; j++){
				dp[j][i] = (s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1]));
				if (dp[j][i] && max < i - j + 1){
					beg = j;
					end = i;
					max = i - j + 1;
				}
			}
		}
		return s.substring(beg,end+1);
	}
	
	public static void longestPalindromicStringTest(){
		String[] sarr = {"abc","aba","aaaaaabcdaaabbaaa"};
		for(String s: sarr){
			System.out.println(longestPalindromicString(s));
		}
	}
	
	public static ArrayList<Integer> windowSum(){
		return new ArrayList<Integer>();
	}
	
	public static int twoSumCount(int[] nums, int target){
		if(nums == null || nums.length == 0) return 0;
		int result = 0;
		Map map = new HashMap();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++){
			if(map.get(target-nums[i])!=null && ((int)map.get(target-nums[i]) != -1)){
				map.put(nums[i], -1);
				result += 1;
			}
		}
		return result;
	}
	
	public static void twoSumCountTest(){
		int[] arr1 = {1,2,3,4,5,6};
		System.out.println(twoSumCount(arr1,7));
	}
	
	public static ListNode mergeLinkedList(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null) return null;
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2=l2.next;
            }
            head = head.next;
        }
        if(l1 != null){
            head.next = l1;
        } else {
            head.next = l2;
        }
   
        return curr.next;
	}
	
	public static int linkedListSize(ListNode head){
		int sz = 0;
		while(head != null){
			sz++;
			head=head.next;
		}
		return sz;
	}
	
	public static ListNode getBeforeTail(ListNode head){
		while(head.next.next != null){
			head = head.next;
		}
		return head;
	}
	
	public static ListNode reverseSecondHalf(ListNode head){
		/*
		 * Find the mid point 
		 * */
		if(head == null) return head;
		ListNode curr = head;
		
		int size = linkedListSize(head);
		int midp = size / 2 - ((size % 2 == 0) ? 1 : 0);
		int move = size / 2 - 1;
		
		while(midp > 0){
			curr = curr.next;
			midp--;
		}
		
		while(move > 0){
			ListNode bt = getBeforeTail(curr);
			bt.next.next = curr.next;
			curr.next = bt.next;
			bt.next = null;
			curr=curr.next;
			move--;
		}

		return head;
	}
	
	public static ListNode reverseSecondHalf2(ListNode head){
		/*
		 * Step 1: use two pointers to move to the mid point
		 * Step 2: use three pointers to swap adjacent nodes
		 * */
		
		if(head == null || head.next == null || head.next.next == null) return head;
		ListNode fast = head.next;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode pre = slow.next;
		ListNode cur = pre.next;
		
		while (cur != null){
			pre.next = cur.next;
			cur.next = slow.next;
			slow.next = cur;
			cur = pre.next;
		}
		return head;
		
	}
	
	public static ListNode reverseSecondHalf3(ListNode head){
		if (head == null || head.next == null || head.next.next == null)return head;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast != null && fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Stack st = new Stack<ListNode>();
		ListNode curr = slow.next;
		while(curr != null){
			st.push(new ListNode(curr.val));
			curr = curr.next;
			slow.next = curr;
		}
		
		curr = (ListNode) st.pop();
		slow.next = curr;
		
		while(!st.isEmpty()){
			curr.next = (ListNode) st.pop();
			curr = curr.next;
		}
		
		
		return head;
		
	}
	
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || linkedListSize(head) < k) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = head.next;
        
        int cnt = 0;
        while(cnt < k - 1){
            head.next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = head.next;
            cnt++;
        }
        
        reverseKGroup(curr,k);
        return dummy.next;
    }
	
	public static void reverseSecondHalfTest(){
		ListNode node = new ListNode(0);
		ListNode head = node;
		for(int i = 1; i < 10; i++){
			node.next = new ListNode(i);
			node = node.next;
		}
		//reverseSecondHalf(head);
		reverseSecondHalf3(head);
		while(head!= null){
			System.out.print(head.val+",");
			head = head.next;
		}
	}
	
	public static void reverseKGroupTest(){
		ListNode node = new ListNode(1);
		ListNode head = node;
		for(int i = 2; i < 5; i++){
			node.next = new ListNode(i);
			node = node.next;
		}
		head = reverseKGroup(head,2);
		while(head!= null){
			System.out.print(head.val+",");
			head = head.next;
		}
	}
	
	public static boolean matchTree(TreeNode n1, TreeNode n2){
		if(n1 == null && n2 == null){
			return true;
		} else if(n1 == null || n2 == null){
			return false;
		} else  if(n1.val != n2.val){
			return false;
		} else {
			return matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right);
		}
	}
	
	public static boolean isSubtree(TreeNode r1, TreeNode r2){
		//if n2 is null true
		//if n1.val = n2.val && matchTree(n1,n2) true
		//else isSubtree(n1.left,n2) || isSubtree(n1.right,n2)
		if(r1 == null){
			return false;
		} else if(r1.val == r2.val && matchTree(r1, r2)) {
			return true;
		}
		return isSubtree(r1.left, r2) || isSubtree(r1.right, r2);
	}
	
	public static boolean validParentheses(String s){
        Stack stack = new Stack();
        Map map = new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c =='[' || c == '}'){
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if(stack.isEmpty()) return false;
                char last = (Character) stack.peek();
                char pair = (Character) map.get(c);
                if( pair == last){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
	}
	
	public static ArrayList<Integer> grayCode(int n){
		ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 0){
            result.add(0);
            return result;
        }
        
        ArrayList<Integer> subresult = grayCode(n-1);
        
        for(int i = 0; i < subresult.size(); i++){
            result.add(subresult.get(i));
        }
        
        for(int i = subresult.size()-1; i >=0; i--){
			int num = subresult.get(i);
			result.add(num | 1 << (n-1));
		}
        
        return result;
	}
	
	public static boolean isRotationString(String s1, String s2){
		String newstr = s1+s1;
		return newstr.contains(s2);
	}
	
	public static void isRotationStringTest(){
		String s1 = "Hello";
		String s2 = "World";
		String s3 = "lloHe";
		System.out.println(isRotationString(s1,s2));
		System.out.println(isRotationString(s1,s3));
	}
	
	public static String removeVowel(String s){
		StringBuilder sb = new StringBuilder();
		char[] arr = s.toCharArray(); 
		String vowels = "AEIOUaeiou";
		for(char c: arr){
			if(vowels.indexOf(c) < 0){
				sb.append(String.valueOf(c));
			}
		}
		return sb.toString();
	}
	
	public static void removeVowelTest(){
		String s1 = "AEIOUaeiou";
		String s2 = "ABCDEFGHIjklmnopqrstuvw";
		System.out.println(removeVowel(s1));
		System.out.println(removeVowel(s2));
	}
	
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length-k+1];
        
        for(int i = 0; i <= nums.length - k; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                if (nums[j] > max){
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }
	
    public static boolean searchMatrixHelper(int[][] matrix, int target, int row, int col){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = row; i < m; i++){
            for(int j = col; j < n; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
        	if(matrix[i][j] == target){
        		return true;
        	} else if (matrix[i][j] < target){
        		i++;
        	} else {
        		j--;
        	}
        }
        return false;
    }
    
    public static int maxMinMatrixPath(int[][] matrix){
        int[] result = new int[matrix[0].length];
        result[0] = matrix[0][0];
        for(int i=1; i<matrix[0].length; i++){
                result[i] = Math.min(result[i-1], matrix[0][i]);
        }
        for(int i=1; i<matrix.length; i++){
                result[0] = Math.min(matrix[i][0], result[0]);
                for(int j=1; j<matrix[0].length; j++){
                        result[j] = (result[j]<matrix[i][j] && result[j-1]<matrix[i][j])?Math.max(result[j-1], result[j]):matrix[i][j];
                }
        }
        return result[result.length-1];
    }
    
    public static void maxMinMatrixPathTest(){
    	int[][] mat = {{8,4,7},{6,5,9}};
    	System.out.println(maxMinMatrixPath(mat));
    }
    
    public static Container findOptimalWeights(double capacity, double[] weights){
    	if(weights == null || weights.length == 0) return null;
    	
    	double max = Integer.MIN_VALUE;
    	int idx1 = 0;
    	int idx2 = 0;
    	
    	for(int i = 0; i < weights.length - 1; i++){
    		for(int j = i + 1; j < weights.length; j++){
    			double sum = weights[i]+weights[j];
    			if(sum < capacity && sum > max){
    				max = sum;
    				idx1 = i;
    				idx2 = j;
    			}
    		}
    	}
    	
    	Container cont = new Container(weights[idx1], weights[idx2]);
    	return cont;
    }
	
    public static ListNode insertIntoCircledList(ListNode head, int x){
    	ListNode node = new ListNode(x);
    	if(head == null){
    		node.next = node;
    		return node;
    	}
    	ListNode curr = head;
    	do {
    		if(x > curr.val && x <= curr.next.val) break;
    		//loop到了尾部，比最大的还大或者比最小的还小；
    		if(curr.val > curr.next.val && (x > curr.val || x <= curr.next.val)) break;
    		curr = curr.next;
    	} while(curr != head);
    	node.next = curr.next;
    	curr.next = node;
    	return node;
    }
    
    public static float RoundRobinScheduling(int[] arrival, int[] execution, int quantum){
    	if(arrival == null || execution == null || arrival.length <= 1 || arrival.length != execution.length) return 0;
    	int len = arrival.length;
    	Queue<Process> processList = new LinkedList<Process>();
    	int crtTime = arrival[0], waitTime = 0;
    	processList.add(new Process(arrival[0],execution[0]));
    	int index = 1;
    	while(!processList.isEmpty()){
    		Process crtProcess = processList.poll();
    		waitTime += crtTime - crtProcess.aTime;
    		crtTime += crtProcess.eTime < quantum ? crtProcess.eTime : quantum;
    		for(; index < len && arrival[index] <= crtTime; ++index)
    			processList.add(new Process(arrival[index], execution[index]));
    		if(crtProcess.eTime > quantum)
    			processList.add(new Process(crtTime, crtProcess.eTime - quantum));
    	}
    	return (float)waitTime/len;
    }
    
    public static int[][] rotateMatrix(int[][] matrix, int flag){
    	
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return matrix;
        
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		//flag 0 left rotate, flag 1 right rotate
        		result[i][j] = flag == 0 ? matrix[m-1-j][i] : matrix[j][n-1-i];
        	}
        }
        return matrix;
        
    }
    
    public static boolean isMatrixEquals(int[][] mat1, int[][] mat2){
    	for(int i = 0; i < mat1.length; i++){
    		for(int j = 0; j < mat1[0].length;j++){
    			if(mat1[i][j] != mat2[i][j]) return false;
    		}
    	}
    	return true;
    }
    
    public static int minPathSum(TreeNode root){
    	if(root == null) return 0;
    	if(root.left == null && root.right == null) return root.val;
    	int lt = Integer.MAX_VALUE;
    	int rt = Integer.MAX_VALUE;
    	if(root.left != null) lt = minPathSum(root.left);
    	if(root.right != null) rt = minPathSum(root.right);
    	return root.val + Math.min(lt, rt);
    }
    
    public static int GCD(int[] nums){

    	if(nums == null || nums.length == 0 || nums[0] == 0) return 0;
    	if(nums.length == 1) return nums[0];
    	
    	int divisor = nums[0];
    	for(int i = 1; i < nums.length; i++){
    		if(nums[i] == 0) return 0;
    		int divident = nums[i];
    		while (divident % divisor != 0){
    			int tmp = divisor;
    			divisor = divident % divisor;
    			divident = tmp;
    		}
    	}
    	return divisor;
    }
    
    public static int GCDHelper(int m, int n){
    	if (m % n == 0){
    		return n;
    	} else {
    		return GCDHelper(n, m % n);
    	}
    }
        
    public static float SJF(int[] req, int[] dur){
    	    	
    	if(req == null || dur == null || req.length <= 1 || req.length != dur.length) return (float)0.0;
    	int len = req.length;
    	int crtTime = req[0];
    	int waitTime = 0;
    	
    	PriorityQueue<Process> processPQ = new PriorityQueue<AmazonOA.Process>(new Comparator<Process>(){
    		@Override
    		public int compare(Process p1, Process p2){
    			if(p1.eTime == p2.eTime) return p1.aTime - p2.aTime;
    			return p1.eTime - p2.eTime;
    		}
    	});
  
    	processPQ.offer(new Process(req[0], dur[0]));
    	int index = 1;
    	while(!processPQ.isEmpty()){
    		Process crtProcess = processPQ.poll();
    		waitTime += crtTime - crtProcess.aTime;
    		crtTime += crtProcess.eTime;
    		for(; index < len && req[index] <= crtTime; index++){
    			processPQ.offer(new Process(req[index], dur[index]));
    		}
    	}
    	return (float)waitTime/len;
    	
    }
    
    public static float SJF2(int[] req, int[] dur){
    	
    	if(req == null || dur == null || req.length <= 1 || req.length != dur.length) return (float)0;
    	int len = req.length;
    	int currTime = 0;
    	int waitTime = 0;
    	
    	PriorityQueue<Process> pq = new PriorityQueue<AmazonOA.Process>(new Comparator<Process>(){
    		@Override
    		public int compare(Process p1, Process p2){
    			if(p1.eTime == p2.eTime) return p1.aTime - p2.aTime;
    			return p1.eTime - p2.eTime;
    		}
    	});
    	
    	pq.offer(new Process(req[0], dur[0]));
    	int index = 1;
    	
    	while(!pq.isEmpty()){
    		Process proc = pq.poll();
    		waitTime += currTime - proc.aTime;
    		currTime += proc.eTime;
    		for(; index < len && req[index] <= currTime; index++){
    			pq.offer(new Process(req[index], dur[index]));
    		}
    	}
    	return (float)waitTime/len; 
    	
    	
    	
    }
    
    public static int LRUMissCount(int[] arr, int size){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int count = 0;
    	for(int i = 0; i < arr.length; i++){
    		if(list.indexOf(arr[i]) < 0){
    			count++;
        		if(list.size() == size){
        			list.remove(0);
        		}
    		} else {
    			int idx = list.indexOf(arr[i]);
    			list.remove(idx);
    		}
    		list.add(arr[i]);
    	}
    	return count;
    }
    
    public static int[] dayChange(int[] cells, int days){
    	if(cells == null || cells.length <= 1 || days <= 0) return cells;
    	
    	for(int i = 0; i < days; i++){
    		//每次把前一天的cells拷贝到一个新数组
    		int[] change = new int[cells.length];
    		for(int j = 0; j < cells.length; j++){
    			change[j] = cells[j];
    		}
    		
    		//用这个新数组算出变化后的数组
    		for(int j = 0; j < cells.length; j++){
    			if(j == 0) cells[j] = 0;
    			else if(j == cells.length - 1) cells[j] = 0;
    			else if(change[j-1] == change[j+1]) cells[j] = 0;
    			else cells[j] = 1;
    		}
    	}
    	return cells;
    }
    
    public static void dayChangeTest(){
    	int[] cells = {1,0,0,0,0,1,0,0};
    	cells = dayChange(cells,1);
    	for(int i = 0; i < cells.length; i++){
    		System.out.print(cells[i]);
    	}
    }
    
    public static class Point {
    	public int row;
    	public int col;
    	public Point(int _row, int _col){
    		row = _row;
    		col = _col;
    	}
    }
    
    public static int findPathInMaze(int[][] maze){
    	if(maze == null || maze.length == 0 || maze[0].length == 0) return 0;
    	if(maze[0][0] == 9) return 1;
    	int row = maze.length, col = maze[0].length;
    	int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    	LinkedList<Point> q = new LinkedList<AmazonOA.Point>();
    	q.offer(new Point(0, 0));
    	while(!q.isEmpty()){
    		Point crt = q.poll();
    		for(int i = 0; i < 4; i++){
    			int tmpRow = crt.row + direction[i][0];
    			int tmpCol = crt.col + direction[i][1];
    			if(tmpRow >= 0 && tmpRow < row && tmpCol >=0 && tmpCol < col && maze[tmpRow][tmpCol] > 0){
    				if(maze[tmpRow][tmpCol] == 9) return 1;
    				q.offer(new Point(tmpRow, tmpCol));
    				maze[tmpRow][tmpCol] = -1;
    			}
    		}
    	}
    	return 0;
    }
    
    public static int ArithmeticSeq(int[] nums){
		if(nums == null || nums.length < 3) return 0;
		int left = 0, right = 1, diff = nums[1] - nums[0], count = 0;
		while(right < nums.length - 1){
			if(diff != nums[right + 1] - nums[right]){
				count += (right - left - 1) * (right - left) / 2;
				if(count > 1000000000) return -1;
				diff = nums[right + 1] - nums[right];
				left = right;
			}
			++right;	
		}
		count += (right - left - 1) * (right - left) / 2;
		return count > 1000000000 ? -1 : count;
    }
    
    public static int Amplitude(TreeNode root){
    	if(root == null) return 0;
    	return AmplitudeHelper(root,root.val,root.val);
    }
    
    public static int AmplitudeHelper(TreeNode root, int min, int max){
    	if(root == null) return max - min;
    	if(root.val < min) min = root.val;
    	if(root.val > max) max = root.val;
    	return Math.max(AmplitudeHelper(root.left,min,max), AmplitudeHelper(root.right,min,max));
    }
    
 	public static void main(String[] args){
 		reverseSecondHalfTest();
	}	
}
