package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //물품의 수
		int K = Integer.parseInt(st.nextToken()); //준서가 버틸 수 있는 무게
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int W = Integer.parseInt(st.nextToken()); //물건의 무게
			int V = Integer.parseInt(st.nextToken()); //물건의 가치
			
			for(int j=1;j<=K;j++) {
				if(j<W) dp[i][j] = dp[i-1][j];
				else if(j==W) dp[i][j] = Math.max(dp[i-1][j], V);
				else dp[i][j] = Math.max(dp[i-1][j], V+dp[i-1][j-W]);
			}
		}
		
		System.out.println(dp[N][K]);

	}

}
