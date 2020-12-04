package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 캐슬디펜스_17135 {
	static int[][] board, original;
	static int N, M, D, answer = 0;
	static int maxAns = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		D = Integer.valueOf(st.nextToken());
		original = new int[N+1][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				original[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		board = new int[N+1][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				board[i][j] = original[i][j];
			}
		}
	
		combination(M, 3, 0);
		
		System.out.println(maxAns);
	
	}

	private static void combination(int n, int r, int index) {
		// TODO Auto-generated method stub
		if(r==0) {
			game();
			answer = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					board[i][j] = original[i][j];
				}
			}
			
			return;
		}
		if(index==n) return;
		
		board[N][index] = 2; //궁수가 있는 칸은 2
		combination(n, r-1, index+1);
		board[N][index] = 0;
		combination(n, r, index+1);
	}

	private static void game() {
		// TODO Auto-generated method stub
		while(true) {			
			attack();
			
			if(!down()) {
				if(maxAns<answer) maxAns = answer;
				return;
			}
			
		}
		
	}

	private static boolean down() {
		// 적들이 아래로 내려오기
		boolean count = false;
		
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(board[i][j]==1) {
					board[i][j] = 0;
					if(i+1!=N) board[i+1][j] = 1;
					
					count = true;
				}
			}
		}
		
		return count;
	}

	private static void attack() {
		// TODO Auto-generated method stub
		int[] killX = {-1, -1, -1};
		int[] killY = {-1, -1, -1};
		int index = 0;
		for(int i=0;i<M;i++) {
			
			int mini = Integer.MAX_VALUE;
			
			if(board[N][i]!=2) continue;
			int x1= N;
			int y1 = i;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(board[j][k]==1) {
						
						int x2 = j;
						int y2 = k;
						
						int tmp = Math.abs(x1-x2)+Math.abs(y1-y2);
						if(tmp>D) continue;
						if(mini>tmp) {
							mini = tmp;
							killX[index] = j;
							killY[index] = k;
						}
						else if(mini==tmp) {
							if(killY[index]>k) {
								killX[index] = j;
								killY[index] = k;
							}
						}
					
					}
				}
			}
			
			index++;
		}
		
		for(int i=0;i<3;i++) {
			if(killX[i]==-1) continue;
			
			if(board[killX[i]][killY[i]]==1) {
				board[killX[i]][killY[i]] = 0;
				answer++;
			}
			
		}
	}

}
