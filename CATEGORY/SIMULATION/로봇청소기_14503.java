package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �κ�û�ұ�_14503 {
	static int count = 0; // û���� ĭ ��
	static int[][] floor;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // �� ��
		M = Integer.parseInt(st.nextToken()); // �� ��
		
		st = new StringTokenizer(bf.readLine(), " ");
		int rx = Integer.parseInt(st.nextToken()); // ���� �κ�û�ұ� ��ǥ
		int ry = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken()); // ���� �κ�û�ұ� ����
		
		floor = new int[N][M]; // �ٴ� ����
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
		// dir 0~3 �������
		// û��
		if(floor[rx][ry]==0) {
			count++;
			floor[rx][ry] = 2; // û���� �ٴ��� 2
		}
		
		// �������� ȸ��
		for(int i=0;i<4;i++) {
			if(dir!=0) dir--;
			else dir = 3;
			
			int nx = rx + dx[dir]; // ������ ���� ��ǥ
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
