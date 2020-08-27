package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 전자레인지_10162 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// A 300 B 60 C 10 T 100 -> a 0 b 1 c 4 
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		int T = Integer.parseInt(bf.readLine());
		int a = T / 300;
		int b = (T - (a * 300)) / 60;
		while(a>=0) {
			if((T - (a * 300 + b * 60)) % 10 == 0) {
				System.out.println(a + " " + b + " " + ((T - (a * 300 + b * 60)) / 10));
				flag = true;
				break;
			}
			else {
				b--;
				if(b<0) {
					a--;
					b = (T - (a * 300)) / 60;
				}
			}
		}
		
		if(!flag) System.out.println("-1"); 
	}

}
