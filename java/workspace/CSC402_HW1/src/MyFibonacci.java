//CSC402 Data Structure I HW1 MyFibonacci.java
//Dachi Xu , ID#1451968, dachi.xu@gmail.com

import java.util.Scanner;

public class MyFibonacci {
	public static final int MAX = 100;
	public static final long[] A = new long[MAX];
	
	public static long F(int n)
	{
		//if F(n) has been computed
		if (A[n]!=0)
		{
			return A[n];
		} 
		
		//if F(n) has not been computed
		else 
		{
			 if (n<=1) {
					A[n] = 1;
			 } else {
					A[n] = A[n-1] + A[n-2];
			 }
			 return A[n];
		}
	}
	
	private static void directions()
	{
		String msg =
				"This application prints the fibonacci numbers,F(k) for\n"+
				"k = 0, 1 ,2 , ... , n\n";
		System.out.println(msg);
	}
	
	public static void main(String[] args){
		int N;
		Scanner in = new Scanner(System.in);
		directions();
		System.out.printf("N: ");
		
		N = in.nextInt();
		for(int i = 0; i <= N; i++){
			System.out.printf("%3d. %d\n",i, F(i));
		}
	}
}
