package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 단지번호붙이기_2667 {
	static int n;
	static String[][] map; 
	static int[][] dan;
	static int num = 1;
	static ArrayList<Integer> home = new ArrayList<>();
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(bf.readLine());
		map = new String[n][n];
		dan = new int[n][n];
		
		for(int i=0;i<n;i++) {
			map[i] = bf.readLine().split("");
			Arrays.fill(dan[i], -1);
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				check(i, j, 0);
			}
		}
		
		System.out.println(num-1);
		home.sort(null);
		for(int i=0;i<num-1;i++) {
			System.out.println(home.get(i));
		}
		
	}

	private static void check(int i, int j, int first) {
		// TODO Auto-generated method stub
		
		if(dan[i][j]!=-1) return;
		else if(map[i][j].equals("0")) dan[i][j] = 0;
		else {
			dan[i][j] = num;
			count++;
			if(i>0) check(i-1, j, 1);
			if(j>0) check(i, j-1, 1);
			if(j+1<n) check(i, j+1, 1);
			if(i+1<n) check(i+1, j, 1);
			if(first==0) {
				home.add(count);
				count = 0;
				num++;
			}
		}
	}

}
