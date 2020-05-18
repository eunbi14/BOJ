package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 영역구하기_2583 {
	static boolean[][] count;
	static char[][] mo;
	static int m, n;
	static int num = 0;
	static int area = 0;
	static ArrayList<Integer> areas = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		mo = new char[n][m];
		count = new boolean[n][m];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int startx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			for(int j=startx;j<ex;j++) {
				for(int l=sy;l<ey;l++) {
					mo[j][l] = 'o';
				}
			}
		}
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				check(i, j, 0);
			}
		}
		
		areas.sort(null);
		System.out.println(num);
		for(int e : areas) System.out.print(e+" ");
		
	}

	private static void check(int i, int j, int k) {
		if(mo[i][j]=='o') return;
		else if(count[i][j]==true) return;
		else {
			count[i][j] = true;
			area++;
			if(i>0) check(i-1, j, 1);
			if(j>0) check(i, j-1, 1);
			if(j+1<m) check(i, j+1, 1);
			if(i+1<n) check(i+1, j, 1);
			if(k==0) {
				num++;
				areas.add(area);
				area = 0;
			}
			
		}
	}

}
