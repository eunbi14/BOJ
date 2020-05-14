package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 토너먼트_1057 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer보다 조금 더 빠름!
		String str[] = bf.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int kim = Integer.parseInt(str[1]);
		int im = Integer.parseInt(str[2]);
		int answer = 1;
		while(N>1) {
			//둘이 대결할때
			if(kim-im==1&&im%2==1) {
				System.out.println(answer);
				return;
			}
			if(im-kim==1&&kim%2==1) {
				System.out.println(answer);
				return;
			}
			
			//둘이 대결하지 않을때
			kim = next(kim);
			im = next(im);
			N = next(N);
			
			answer++;
		}
		
		System.out.println(answer);
		
	}

	private static int next(int num) {
		// TODO Auto-generated method stub
		if(num%2==0) return num/2;
		else return num/2+1;
	}

}
