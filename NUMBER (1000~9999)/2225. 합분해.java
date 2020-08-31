package �������α׷���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �պ���_2225 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) dp[i][1] = 1;
		
		
		for(int i=0;i<=K;i++) dp[0][i] = 1;

		for (int n = 1; n <= N; n++) {
			for (int k = 1; k <= K; k++) {
				if(dp[n][k]!=0) continue;
				for (int i = n; i >= 0; i--) {
					
						dp[n][k] += dp[i][k-1];
						dp[n][k] %= 1000000000;
						//3�� for�� �ȵ����� 
						//dp[n][k] = dp[n][k-1] + dp[n-1][k]; �� �ᵵ ��
						//dp[n-1][k] = dp[n-1][k-1] + dp[n-2][k] �ϱ�
						// �� ��ͷ� �������� ����!
				}

			}

		}

		
		 for(int i=1;i<=N;i++) { for(int j=1;j<=K;j++) {
		 System.out.println(i+"�� "+j+"���� ���� ��� : "+dp[i][j]); } }
		
		System.out.println(dp[N][K]);
	}

}
