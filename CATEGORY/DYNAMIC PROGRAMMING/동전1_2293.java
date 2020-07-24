package 동적프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 동전1_2293 {
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	static int[] money = new int[n];
	static int k = sc.nextInt();
	static int[][] t = new int[n+1][k+1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int[] row: t) Arrays.fill(row, -1);
		
		
		for(int i=0;i<n;i++) money[i] = sc.nextInt();
		Arrays.sort(money);
		System.out.println(coin(n, k));
	}

	private static int coin(int n, int k) {
		if(t[n][k]!=-1) return t[n][k];
		int count = 0;
		if(n<1) return 0;
		if(k%money[n-1]==0) count++;
		for(int i=k;i>0;i = i-money[n-1]) {
			count = count + coin(n-1, i);
		}
		t[n][k] = count;
		return count;
	}

}
