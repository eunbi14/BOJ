package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 계단오르기_2579 {
	static int[] answer;
	static int[] step;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.valueOf(bf.readLine());
		step = new int[count+1];
		int bound = 0;
		answer = new int[count+1];
		for(int i=1;i<=count;i++) {
			step[i] = Integer.valueOf(bf.readLine());
			bound = bound + step[i];
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(maxpoint(count)));
		bw.flush();
		bw.close();
		
		
	}

	private static int maxpoint(int count) {
		if(answer[count]!=0) return answer[count];
		
		answer[1] = step[1];
		if(count>1) answer[2] = step[1]+step[2];
		if(count>2) answer[3] = Math.max(step[1], step[2]) + step[3];
			
		if(count<4) return answer[count];
		
		for(int i=4;i<=count;i++) {
			answer[i] = Math.max(answer[i-2]+step[i] , answer[i-3]+step[i-1]+step[i]);
		}
		
		return answer[count];
	}

}
