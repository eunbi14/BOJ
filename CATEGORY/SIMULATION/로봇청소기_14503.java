package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기_14503 {
	static int count = 0; // 청소한 칸 수
	static int[][] floor;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행 수
		M = Integer.parseInt(st.nextToken()); // 열 수
		
		st = new StringTokenizer(bf.readLine(), " ");
		int rx = Integer.parseInt(st.nextToken()); // 현재 로봇청소기 좌표
		int ry = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken()); // 현재 로봇청소기 방향
		
		floor = new int[N][M]; // 바닥 상태
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0;j<M;j++) {
				floor[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		vaccume(rx, ry, dir);
		
	
		System.out.println(count);
	}

	private static void vaccume(int rx, int ry, int dir) {
		// dir 0~3 상우하좌
		// 청소
		if(floor[rx][ry]==0) {
			count++;
			floor[rx][ry] = 2; // 청소한 바닥은 2
		}
		
		// 왼쪽으로 회전
		for(int i=0;i<4;i++) {
			if(dir!=0) dir--;
			else dir = 3;
			
			int nx = rx + dx[dir]; // 진행할 방향 좌표
			int ny = ry + dy[dir];
			
			if(nx<0||ny<0||nx>=N||ny>=M) continue;
			if(floor[nx][ny]==0) {
				vaccume(nx, ny, dir);
				return;
			}
			
			
		}
		
		int nx = rx - dx[dir];
		int ny = ry - dy[dir];
		
		if(nx<0||ny<0||nx>=N||ny>=M) return;
		if(floor[nx][ny]==1) return;
		vaccume(nx, ny, dir);
		
		
		
		
		
	}

}
