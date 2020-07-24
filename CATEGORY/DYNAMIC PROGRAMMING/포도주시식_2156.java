package �������α׷���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class �����ֽý�_2156 {
	static int[] drink;
	static int[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		drink = new int[n+1]; // �ִ� ������ ��
		list = new int[n+1]; // �����Ǿ��ִ� ������
		
		for(int i=1;i<=n;i++) list[i] = Integer.parseInt(bf.readLine());
		
		System.out.println(grape(n));
		
	}

	private static int grape(int n) {
		// �̹� ������������ �� ����
		if(drink[n]!=0) return drink[n];
		
		if(n>=1) drink[1] = list[1];
			
		if(n>=2) drink[2] = list[1] + list[2];
	
		if(n>=3) {
			drink[3] = Math.max(list[1]+list[3], list[1]+list[2]);
			drink[3] = Math.max(drink[3], list[2] + list[3]);
		}
		
		for(int i=4;i<=n;i++) {
			drink[i] = Math.max(drink[i-1], drink[i-3] + list[i-1]+ list[i]);
			drink[i] = Math.max(drink[i], drink[i-2] + list[i]);
		}
		
		return drink[n];
		
	}

}
