package �������α׷���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����ѹ賶_12865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //��ǰ�� ��
		int K = Integer.parseInt(st.nextToken()); //�ؼ��� ��ƿ �� �ִ� ����
		int[][] dp = new int[N+1][K+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int W = Integer.parseInt(st.nextToken()); //������ ����
			int V = Integer.parseInt(st.nextToken()); //������ ��ġ
			
			for(int j=1;j<=K;j++) {
				if(j<W) dp[i][j] = dp[i-1][j];
				else if(j==W) dp[i][j] = Math.max(dp[i-1][j], V);
				else dp[i][j] = Math.max(dp[i-1][j], V+dp[i-1][j-W]);
			}
		}
		
		System.out.println(dp[N][K]);

	}

}
