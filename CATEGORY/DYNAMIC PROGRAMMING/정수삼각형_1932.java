package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수삼각형_1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		int[] number = new int[n];
		int answer = 0;
		number[0] = Integer.valueOf(bf.readLine());
		for(int i=1;i<n;i++) {
			String[] plus = bf.readLine().split(" ");
			int[] tmp = new int[n];
			tmp[0] = number[0] + Integer.valueOf(plus[0]);
			for(int j=1;j<plus.length-1;j++) {
				tmp[j] = Math.max(number[j-1], number[j]) + Integer.valueOf(plus[j]);
			}
			tmp[i] = number[i-1] + Integer.valueOf(plus[i]);
			if(i!=n-1) {
				for(int j=0;j<plus.length;j++) number[j] = tmp[j];
			}
			else {
				for(int j=0;j<plus.length;j++) {
					if(answer<tmp[j]) answer = tmp[j];
				}
			}
			
			/*for(int j=0;j<plus.length;j++) {
				System.out.print(tmp[j]+" ");
			}
			System.out.println();*/
		}
		
		System.out.println(answer);
	}

}
