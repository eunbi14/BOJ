package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 안전영역_2468 {
	static int[][] height;
	static boolean[][] safec;
	static int num = 0;
	static int answer = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		height = new int[n][n];
		String[] tmp = new String[n];
		int mini = 101;
		int maxi = 0;
		for(int i=0;i<n;i++) {
			tmp = bf.readLine().split(" ");
			for(int j=0;j<n;j++) {
				height[i][j] = Integer.valueOf(tmp[j]);
				if(height[i][j]>maxi) maxi = height[i][j];
				else if(height[i][j]<mini) mini = height[i][j];
			}
		}
		
		for(int i=mini;i<maxi;i++) {
			down(i, height);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(answer));
		bw.flush();
		bw.close();
	}

	private static void down(int i, int[][] height) {
		// TODO Auto-generated method stub
		num = 0;
		safec = new boolean[height.length][height.length];
		for(int j=0;j<height.length;j++) {
			for(int k=0;k<height.length;k++) {
				if(height[j][k]<=i) height[j][k] = -1;
			}
		}
		
		for(int j=0;j<height.length;j++) {
			for(int k=0;k<height.length;k++) {
				check(j, k, 0);
			}
		}
		
		answer = Math.max(num, answer);
		
	}

	private static void check(int j, int k, int first) {
		// TODO Auto-generated method stub
		if(height[j][k]==-1) return;
		else if(safec[j][k]==true) return;
		else {
			safec[j][k] = true;
			if(j>0) check(j-1, k, 1);
			if(k>0) check(j, k-1, 1);
			if(k+1<height.length) check(j, k+1, 1);
			if(j+1<height.length) check(j+1, k, 1);
			if(first==0) num++;
			
		}
	}

}
