package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Z_1074 {
	static int N, r, c, answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		N = Integer.valueOf(s[0]);
		r = Integer.valueOf(s[1]);
		c = Integer.valueOf(s[2]);
		answer = 0;
		
		while(N>1) {
			divide();
		}
		
		answer = answer + 2*r + c;
		System.out.println(answer);
				
	}

	private static void divide() {
		// TODO Auto-generated method stub
		int len = (int) Math.pow(2, N);
		len = len / 2;
		N--;
		if(r<len&&c>=len) {
			answer = answer + (len * len);
			c -= len;
		}
		else if(r>=len&&c<len) {
			answer = answer + 2*(len * len);
			r = r - len;
		}
		else if(r>=len&&c>=len) {
			answer = answer + 3*(len*len);
			c -= len;
			r -= len;
		}
	}

}
