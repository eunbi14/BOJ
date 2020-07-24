package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이친수_2193 {
	static long[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		dp = new long[N+1];
		
		
		if(N==1) System.out.println("1");
		else{
			dp[1] = 1;	
			System.out.println(solution(N));
		}
		
		
	}

	private static long solution(int N) {
		// TODO Auto-generated method stub
		for(int i=2;i<=N;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[N];
	}

}
