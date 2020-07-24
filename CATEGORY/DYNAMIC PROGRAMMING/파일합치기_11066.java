package 동적프로그래밍;
//해결못함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 파일합치기_11066 {
	static long[][] dp, sum;
	static long[] psum;
	static long total = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		long[] answer = new long[T];
		for(int i=0;i<T;i++) {
			int K = Integer.parseInt(bf.readLine());
			int[] file = new int[K+1];
			String[] str = bf.readLine().split(" ");
			
			for(int j=0;j<K;j++) {
				file[j+1] = Integer.parseInt(str[j]);
			}
			answer[i] = solution(K, file);
			System.out.println("~~");
		}
		
		for(long l : answer) System.out.println(l);
	}

	private static long solution(int K, int[] file) {
		// TODO Auto-generated method stub
		dp = new long[K+1][K+1];
		psum = new long[K+1];
		for(int i=1;i<=K;i++) {
			dp[i][i] = file[i];
			if(i<K) dp[i][i+1] = file[i] + file[i+1];
			psum[i] = psum[i-1] + file[i];
		}
		
		
		
		for(int i=1;i<=K;i++) {
			for(int j=i+2;j<=K;j++) {
				dp[i][j] = 999999999;
			}
			psum[i] = getDP(1, i, i) + getDP(i+1, K, i);
			System.out.println("cut : "+i);
			
		}
		
		Arrays.sort(psum);
	
		return psum[0];
	}

	private static long getDP(int start, int end, int index) {
		// TODO Auto-generated method stub
		if(dp[start][end]!=0) return dp[start][end];
	
		for(int i=start;i<end;i++) {
			
				psum[index] = getDP(start, i, index) + getDP(i+1, end, index);
				
				System.out.println("start:"+start+", end:"+end+", cut:"+i);
			
		}
		dp[start][end] = psum[index] + total;
		return dp[start][end];
	}

}
