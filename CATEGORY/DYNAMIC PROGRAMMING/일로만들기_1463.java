package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일로만들기_1463 {
	static int[] make;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		make = new int[N+1];
		make[1] = 0;
		if(N>1)	make[2] = 1;
		if(N>2) make[3] = 1;
		
		System.out.println(get(N));
		
	
	}

	private static int get(int N) {
		// TODO Auto-generated method stub
		if(make[N]!=0) return make[N];
		if(N==1) return 0;
		int tmp = get(N-1) + 1;
		if(N%3==0) {
			int tmp2 = get(N/3) + 1;
			tmp = Math.min(tmp, tmp2);
		}
		else if(N%2==0) {
			int tmp2 = get(N/2) + 1;
			tmp = Math.min(tmp, tmp2);
		}
		make[N] = tmp;
		return tmp;
		
	}

}
