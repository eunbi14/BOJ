package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 로프_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] rope = new int[N];
		
		for(int i=0;i<N;i++) rope[i] = Integer.parseInt(bf.readLine());
		
		Arrays.sort(rope);
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			int max = rope[i]*(N-i);
			if(max>answer) answer = max;
		}
		
		System.out.println(answer);
	}

}
