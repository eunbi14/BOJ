package 삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Shark{
	int r;
	int c;
	int s; //속력
	int d; //방향 1234 상하우좌
	int z; //크기
	int num;
	
	public Shark(int r, int c, int s, int d, int z, int num) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
		this.num = num;
	}
}
public class 낚시왕_17143 {
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		int R = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		int M = Integer.parseInt(str[2]);
		
		String[] s;
		int num = 1;
		Shark[][] sea = new Shark[R+1][C+2];
		for(int i=0;i<M;i++) {
			s = bf.readLine().split(" ");
			sea[i(s[0])][i(s[1])] = new Shark(i(s[0]), i(s[1]), i(s[2]), i(s[3]), i(s[4]), num);
			num++;
		}
		
		for(int i=1;i<=C;i++) fish(i, sea);
		System.out.println(answer);
	}

	private static void fish(int index, Shark[][] sea) {
		// 땅과 가장 가까운 상어 잡기
		for(int row=1;row<sea.length;row++) {
			if(sea[row][index]!=null) {
				answer += sea[row][index].z;
				sea[row][index] = null;
				break;
			}
		}
		
		search(sea);
	}

	private static void search(Shark[][] sea) {
		// 상어가 있는 위치 찾기
		Stack<Shark> st = new Stack<>();
		for(int i=1;i<sea.length;i++) {
			for(int j=1;j<sea[0].length-1;j++) {
				if(sea[i][j]!=null) move(i, j, sea, st);
			}
		}
		
		while(!st.isEmpty()) {
			Shark shark = st.pop();
			if(sea[shark.r][shark.c]==null) sea[shark.r][shark.c] = shark;
			else if(sea[shark.r][shark.c].z<shark.z) sea[shark.r][shark.c] = shark;
		}
		
	}

	private static void move(int row, int col, Shark[][] sea, Stack<Shark> st) {
		// 상어 이동
		Shark shark = sea[row][col];
		int dx = row;
		int dy = col;
		for(int i=0;i<shark.s;i++) {
			if(shark.d==1) {
				if(row>1) row--;
				else {
					row++;
					shark.d = 2;
				}
			}
			else if(shark.d==2) {
				if(row<sea.length-1) row++;
				else{
					row--;
					shark.d = 1;
				}
			}
			else if(shark.d==3) {
				if(col<sea[0].length-2) col++;
				else {
					col--;
					shark.d = 4;
				}
			}
			else {
				if(col>1) col--;
				else {
					col++;
					shark.d = 3;
				}
			}
		}
		
		shark.r = row;
		shark.c = col;
		st.add(shark);
		
		sea[dx][dy] = null;
		
	}

	private static int i(String string) {
		// String to Integer
		return Integer.parseInt(string);
	}

}
