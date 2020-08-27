package ±×¸®µð;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		int answer = 0;
		int time = 0;
		for(int i=0;i<n;i++) {
			time = time + a[i];
			answer = answer + time;
		}
		System.out.println(answer);
	}

}
