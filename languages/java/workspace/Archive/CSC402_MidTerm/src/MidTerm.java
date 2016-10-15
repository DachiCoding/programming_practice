import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MidTerm {
	public static String f(String s)
	  {
	    if (s.length() == 0) {
	      return "";
	    }
	    char ch = s.charAt(0);
	    if (ch == 'e') {
	      ch = 'o';
	    } else if (ch == 'o') {
	      ch = 'e';
	    }
	    return ch + f(s.substring(1));
	  }
	
	public static boolean isSorted(int[] arr)
	{
		boolean result = true;
		for (int i = 0; i < arr.length-1; i++)
		{
		 if(arr[i] > arr[i+1])
		  result = false;
		}
		return result;
	}
	
	public static boolean isStrSorted(String[] arr)
	{
		boolean result = true;
		int[] intarr = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			intarr[i] = Integer.parseInt(arr[i]);
		}
		
		for (int i = 0; i < intarr.length-1; i++)
		{
		 if(intarr[i] > intarr[i+1])
		  result = false;
		}
		return result;
	}
	
	public static void f(int i, int x, int[] a, int[] b)
	{
	    if (i >= 0)
	    {
	      a[i] = x;
	      b[i] = x;
	    }
	}
	
	public static String f2(String s)
	  {
	    if (s.length() == 0) {
	      return "";
	    }
	    char ch = s.charAt(0);
	    if (ch == 'e') {
	      ch = 'o';
	    } else if (ch == 'o') {
	      ch = 'e';
	    }
	    return ch + f(s.substring(1));
	  }
	
	public static String f3(String s)
	{
		  if (s.length() == 0) {
		      return "";
		    }
		    String newStr = new String();
		    for(int i = 0; i < s.length() ; i++)
		    {
		    char ch = s.charAt(i);
		    if (ch == 'e') {
		      ch = 'o';
		    } else if (ch == 'o') {
		      ch = 'e';
		    }
		    newStr += ch;
		    }
		    return newStr;
	}

	public static void wordCnt(String fname)
	{
		int wordCount = 0;
		Scanner fscan = new Scanner(fname);
		try { 
		 fscan = new Scanner(new FileReader(fname));
		} catch(FileNotFoundException ex) {
		 ex.printStackTrace();
		}
		fscan.useDelimiter("");
		
		while(fscan.hasNext())
		{
		 char temp = fscan.next().charAt(0);
		 if (temp == ' ' || temp == '\t')
		  wordCount++;
		}
		wordCount += 1;
		System.out.printf("There is %d words of total\n", wordCount);
	}
	
	public static void printEven(Queue<Integer> q){
		while (!q.isEmpty()){
			int x = q.poll();
			if(x % 2 == 0){
				System.out.printf("%d is even integer.\n",x);
			}
		}
	}
	
	public static void main(String args[]){
		/*
		boolean x;
		boolean y;
		boolean c;
		boolean d;
		int arr1[] = {1,2,3};
		int arr2[] = {1,3,2};
		String arr3[] = {"1","2","3"};
		String arr4[] = {"1","3","2"};
		x = isSorted(arr1);
		y = isSorted(arr2);
		c = isStrSorted(arr3);
		d = isStrSorted(arr4);
		System.out.println(x);
		System.out.println(y);
		System.out.println(c);
		System.out.println(d);
		*/
		
		/*
		int[] arr = new int[5];
	    int[] brr = new int[5];

	    f(-1, 10, arr, brr);
	    String x = f3("google every option");
	    System.out.println(x);
	    */
		
	    //wordCnt("input.txt");
		
		Queue<Integer> intQ = new LinkedList<Integer>();
		intQ.add(1);
		intQ.add(2);
		intQ.add(5);
		intQ.add(6);
		printEven(intQ);
	}
}
