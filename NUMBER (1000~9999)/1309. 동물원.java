package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동물원_1309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		int[] dp = new int[N+1];
		int[] left = new int[N+1];
		int[] right = new int[N+1];
		int[] empty = new int[N+1];
		dp[1] = 3;
		left[1] = 1;
		right[1] = 1;
		empty[1] = 1;
		for(int i=2;i<=N;i++) {
			empty[i] = dp[i-1];
			left[i] = (empty[i-1] + right[i-1])%9901;
			right[i] = (empty[i-1] + left[i-1])%9901;
			dp[i] = (empty[i] + left[i] + right[i])%9901;
			//dp[i] = 2*dp[i-1] + dp[i-2]; 도 가능
		}
		
		System.out.println(dp[N]);
	}

}
