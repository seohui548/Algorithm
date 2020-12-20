package study;

import java.util.Scanner;

public class Baekjoon_2748 {

	static long[] dp;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		dp = new long[91];
		
		int n = scan.nextInt();
		
		System.out.println(fib(n));
		
	}
	
	private static long fib(int n) { //  피보나치 2 int형 값을 넘어가므로 long을 써야한다.
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		else {
			if(dp[n] > 0) return dp[n];
			else dp[n] = fib(n - 1) + fib(n - 2);
			return dp[n];
		}
	}

}
