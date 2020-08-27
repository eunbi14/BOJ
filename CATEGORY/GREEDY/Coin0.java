package ±×¸®µð;

import java.util.Scanner;

public class Coin0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int kind = sc.nextInt();
		int money = sc.nextInt();
		int[] k = new int[kind];
		int answer = 0;
		
		for(int i=0;i<kind;i++) k[i] = sc.nextInt();
		
		for(int j=kind-1;j>=0;j--) {
			if(k[j]<=money) {
				answer = answer + money/k[j];
				money = money%k[j];
			}
			if(money==0) break;
		}
		System.out.println(answer);
	}

}
