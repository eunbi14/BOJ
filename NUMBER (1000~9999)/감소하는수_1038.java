package ���Ʈ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����ϴ¼�_1038 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		
		if(N<=10) {
			System.out.println(N);
			return;
		}
		
		long[] num = new long[N+1];
		for(int i=0;i<=9;i++) num[i] = i;
		int startIdx = 0;
		int endIdx = 9;
		long ten = 10; // ���� �ڸ���
	
		int index = 10; //���ڸ� ������� �ε���
		long first = 1;
		for(long j = first;j<=9;j++) { //first�� �� ���ڸ� ���� 1~9
			for(int i=startIdx;i<=endIdx;i++) {
				
				if(num[i]/(ten/10)<j) {
					num[index] = ten*j + num[i];
					index++;
					if(index==N+1) {
						System.out.println(num[N]);
						return;
					}
				}
				else break;
				
				
			}
			
			if(j==9) {
				startIdx = endIdx+1;
				endIdx = index -1;
				j = first;
				first++;
				ten *= 10;
				
			}
			
		}
		
		System.out.println("-1");
	}

}
