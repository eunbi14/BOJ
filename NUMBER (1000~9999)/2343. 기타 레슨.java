package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ±âÅ¸·¹½¼_2343 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine(), " ");
		int[] lesson = new int[N];
		int sum = 0;
		for(int i=0;i<N;i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			sum += lesson[i];
		}
		
		int left = sum/M;
		int right = sum;
		int mid = 0;
		boolean l = false;
		while(left<=right) {
			mid = (left+right)/2;
			int count = 0;
			int s = 0;
			for(int i=0;i<N;i++) {
				if(s+lesson[i]>mid) {
					if(lesson[i]>mid) {
						l = true;
						break;
					}
					s = 0;
					count++;
					i--;	
				}
				else s += lesson[i];
				
				if(i==N-1) count++;
				
			}
			if(l) {
				left = mid + 1;
				l = false;
				continue;
			}
			if(count<=M) right = mid - 1;
			else left = mid + 1;
		}
		
		System.out.println(left);
	}

}
