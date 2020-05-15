package 삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class 이차원배열과연산_17140 {
	static int row = 3;
	static int col = 3;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int k = Integer.parseInt(str[2]);
		int[][] arr = new int[101][101];
		for(int i=1;i<=3;i++) {
			str = bf.readLine().split(" ");
			for(int j=1;j<=3;j++) arr[i][j] = Integer.parseInt(str[j-1]);
		}
		
		
		int answer = 0;
		while(answer<=100) {
			if(arr[r][c]==k) {
				System.out.println(answer);
				return;
			}
			if(row>=col) {
				arr = R(arr);
				
				answer++;
			}
			else {
				
				arr = C(arr);
				answer++;
			}
		}
		System.out.println("-1");
	}
	

	private static int[][] C(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] tmp = new int[101][101];
		int max = 0;
		for(int i=1;i<=col;i++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int j=1;j<=row;j++) {
				if(arr[j][i]!=0) hm.put(arr[j][i], hm.getOrDefault(arr[j][i], 0)+1);
			}
			List<Integer> keySetList = new ArrayList<>(hm.keySet());
			Collections.sort(keySetList, (o1, o2)-> (hm.get(o1)==hm.get(o2))?o1.compareTo(o2):hm.get(o1).compareTo(hm.get(o2)));

			int k = 1;
			for(Integer key : keySetList) {
				tmp[k][i] = key;
				tmp[k+1][i] = hm.get(key);
				k = k + 2;
				if(k>100) break;
			}
			if(max<k-1) max = k-1;
			
			
		}
		
		row = max;
		return tmp;
	}

	private static int[][] R(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] tmp = new int[101][101];
		int max = 0;
		for(int i=1;i<=row;i++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int j=1;j<=col;j++) {
				if(arr[i][j]!=0) hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0)+1);
			}
			List<Integer> keySetList = new ArrayList<>(hm.keySet());
			Collections.sort(keySetList, (o1, o2)-> (hm.get(o1)==hm.get(o2))?o1.compareTo(o2):hm.get(o1).compareTo(hm.get(o2)));
			
			int k = 1;
			for(Integer key : keySetList) {
				tmp[i][k] = key;
				tmp[i][k+1] = hm.get(key);
				k = k + 2;
				if(k>100) break;
			}
			
			if(max<k-1) max = k-1;
			
			
		}
		
		col = max;
		return tmp;
	}

}
