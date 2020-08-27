package 그리디;
//해결못함
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문자열_1120 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] ab = bf.readLine().split(" ");
		int num = 0;
		
		if(ab[1].contains(ab[0])) {
			bw.write("0");
			return;
		}
		
		while(ab[0].length()<ab[1].length()) { //ab[0] : A, ab[1] : B
			int num1 = 0;
			int num2 = 0;
			for(int i=0;i<ab[0].length();i++) {
				if(ab[0].charAt(i)!=ab[1].charAt(i+1)) num1++;
				if(ab[0].charAt(i)!=ab[1].charAt(i)) num2++;
			}
			if(num1<num2) ab[0] = ab[1].charAt(0) + ab[0];
			else ab[0] = ab[0] + ab[1].charAt(ab[0].length());
			bw.write(ab[0]+"\n");
			num = Math.min(num1, num2);
		}
		
		if(num==0) {
			for(int i=0;i<ab[0].length();i++) {
				if(ab[0].charAt(i)!=ab[1].charAt(i)) num++;
			}
		}
		
		
		bw.write(Integer.toString(num));
		bw.flush();
		bw.close();
	}

}
