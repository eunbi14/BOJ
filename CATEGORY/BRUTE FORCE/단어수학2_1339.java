package 브루트포스;
//더 좋은 코드!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어수학2_1339 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String[] words = new String[N];
		
		for(int i=0;i<N;i++) {
			String s = bf.readLine();
			words[i] = s;
		}
		
		boolean[] alphabet = new boolean[26];
		int[] num = new int[26];
		Arrays.fill(num, -1);
		for(int i=0;i<words.length;i++) {
			int ten = 1;
			for(int j=words[i].length()-1;j>=0;j--) {
				if(alphabet[words[i].charAt(j)-65]) {
					num[words[i].charAt(j)-65] += ten;
				}
				else {
					num[words[i].charAt(j)-65] = ten;
					alphabet[words[i].charAt(j)-65] = true;
				}
				ten = ten * 10;
			}
		}
		
		Arrays.sort(num);
		int answer = 0;
		int d = 9;
		for(int i=num.length-1;i>=0&&num[i]!=-1;i--) {
			answer = answer + num[i] * d;
			d--;
		}
		
		System.out.println(answer);
	}

	
}
