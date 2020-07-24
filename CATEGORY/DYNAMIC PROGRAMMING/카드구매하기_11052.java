package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기_11052 {
	static int[] P;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		P = new int[N+1];
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		for(int i=1;i<=N;i++) P[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		dp[0] = P[0];
		dp[1] = P[1];
		System.out.println(card(N));
	}

	private static int card(int N) {
		if(dp[N]!=0) return dp[N];
		int max = 0;
		for(int i=0;i<N;i++) {
			max = Math.max(max, card(i)+P[N-i]);
		}
		dp[N] = max;
		return max;
	}

}
