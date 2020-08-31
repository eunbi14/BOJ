import java.io.*;
import java.util.StringTokenizer;

public class µ¿Àü2_2294 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];

		for(int i=0;i<n;i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		}
		
		int[] dp = new int[10001];
		
		for(int i=0;i<coin.length;i++) {
			if(coin[i]<=k) dp[coin[i]] = 1;
		}
		
		for(int i=1;i<=k;i++) {
			if(dp[i]!=0) continue;
			int t = Integer.MAX_VALUE;
			for(int j=0;j<coin.length;j++) {
				if(i - coin[j]>=0) {
					if(dp[i-coin[j]]!=0) {
						t = Math.min(t, dp[i - coin[j]] + 1);
						dp[i] = t;
					}
					
				}
			}
		}
		
		if(dp[k]==0) System.out.println("-1");
		else System.out.println(dp[k]);
	}

}