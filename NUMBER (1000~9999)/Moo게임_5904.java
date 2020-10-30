package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moo게임_5904 {
	static int[] len = new int[100000];
	
	static public void first(int N, int k) {
		if(k>=1) {
			divide(N, k);
		}
		else if(k==0) {
			if(N==1) System.out.println("m");
			else System.out.println("o");
		}
	}
	
	static public void divide(int N, int k) {
		if(N<=len[k-1]) first(N, k-1);
		else if(N>len[k-1]&&N<=len[k-1]+k+3) {
			if(N==len[k-1]+1) System.out.println("m");
			else System.out.println("o");
		}
		else first(N-len[k-1]-k-3, k-1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		
		if(N==1) System.out.println("m");
		else if(N==2||N==3) System.out.println("o");
		else {
			len[0] = 3;
			int k = 1;
			for(int i=1;len[i-1]<N;i++) {
				len[i] = 2 * len[i-1] + i + 3;
				k = i;
			}
			
			divide(N, k);
		}
		
		
	}

}
