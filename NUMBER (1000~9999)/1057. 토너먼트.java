package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ��ʸ�Ʈ_1057 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer���� ���� �� ����!
		String str[] = bf.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int kim = Integer.parseInt(str[1]);
		int im = Integer.parseInt(str[2]);
		int answer = 1;
		while(N>1) {
			//���� ����Ҷ�
			if(kim-im==1&&im%2==1) {
				System.out.println(answer);
				return;
			}
			if(im-kim==1&&kim%2==1) {
				System.out.println(answer);
				return;
			}
			
			//���� ������� ������
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
