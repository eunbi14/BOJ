package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크리보드_11058 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		if(N<=6) System.out.println(N);
		else {
			long[] dp = new long[N+1];
			for(int i=1;i<=6;i++) dp[i] = i;
			for(int i=7;i<=N;i++) {
				dp[i] = dp[i-1] + 1;
				for(int j=2;j<=i-2;j++) {
					if(dp[i]<j*dp[i-j-1]) dp[i] = j*dp[i-j-1];
				}
			
			}
			System.out.println(dp[N]);
		}
		
	}

}
