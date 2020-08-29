package 삼성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Marble{
	int rRow;
	int rCol;
	int bRow;
	int bCol;
	int count = 0;	
}

public class 구슬탈출2_13460 {
	static int N, M; //N이 세로, M이 가로
	static Queue<Marble> q = new LinkedList<>();
	static boolean red, blue;
	static char[][] board;
	static int[][][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Marble marble = new Marble();
		board = new char[N][M];
		visited = new int[N][M][N][M];
		for(int i=0;i<N;i++) {
			String s = bf.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j]=='R') {
					marble.rRow = i;
					marble.rCol = j;
				}
				else if(board[i][j]=='B') {
					marble.bRow = i;
					marble.bCol = j;
				}
			}
		}
		
		q.add(marble);
		visited[marble.rRow][marble.rCol][marble.bRow][marble.bCol] = 1;
		bfs();
		
		System.out.println("-1");
		
	}

	private static void bfs() {
		if(q.isEmpty()) return;
		Marble n = q.peek();
		if(n.count>=10) return;
		red = false; blue = false;
		Marble next = new Marble();
		next.rRow = n.rRow;
		next.bRow = n.bRow;
		// 오른쪽으로 빨간 구슬 굴리기
		for(int i=n.rCol;i<M;i++) {
			if(board[n.rRow][i]=='O') {
				red = true;
				break;
			}
			else if(board[n.rRow][i]!='#') continue;
			else {
				next.rCol = i - 1;
				break;
			}
		}
		
		// 오른쪽으로 파란 구슬 굴리기
		for(int i=n.bCol;i<M;i++) {
			if(board[n.bRow][i]=='O') {
				blue = true;
				break;
			}
			else if(board[n.bRow][i]!='#') continue;
			else {
				next.bCol = i - 1;
				break;
			}
		}
		
		if(next.rRow==next.bRow&&next.rCol==next.bCol) {
			if(n.rCol<n.bCol) next.rCol--;
			else next.bCol--;
		}
		
		// 구슬이 나왔는지 확인하기
		check(red, blue, n, next);
		
		n = q.peek();
		red = false; blue = false;
		
		next = new Marble();
		next.rRow = n.rRow;
		next.bRow = n.bRow;
		// 왼쪽으로 빨간 구슬 굴리기
		for(int i=n.rCol;i>=0;i--) {
			if(board[n.rRow][i]=='O') {
				red = true;
				break;
			}
			else if(board[n.rRow][i]!='#') continue;
			else {
				next.rCol = i + 1;
				break;
			}
		}
		
		// 왼쪽으로 파란 구슬 굴리기
		for(int i=n.bCol;i>=0;i--) {
			if(board[n.bRow][i]=='O') {
				blue = true;
				break;
			}
			else if(board[n.bRow][i]!='#') continue;
			else {
				next.bCol = i + 1;
				break;
			}
		}
		
		if(next.rRow==next.bRow&&next.rCol==next.bCol) {
			if(n.rCol<n.bCol) next.bCol++;
			else next.rCol++;
		}
		
		// 구슬이 나왔는지 확인하기
		check(red, blue, n, next);
		
		n = q.peek();
		red = false; blue = false;
		
		next = new Marble();

		next.rCol = n.rCol;
		next.bCol = n.bCol;
		// 아래쪽으로 빨간 구슬 굴리기
		for(int i=n.rRow;i<N;i++) {
			if(board[i][n.rCol]=='O') {
				red = true;
				break;
			}
			else if(board[i][n.rCol]!='#') continue;
			else {
				next.rRow = i - 1;
				break;
			}
		}
		
		// 아래쪽으로 파란 구슬 굴리기
		for(int i=n.bRow;i<N;i++) {
			if(board[i][n.bCol]=='O') {
				blue = true;
				break;
			}
			else if(board[i][n.bCol]!='#') continue;
			else {
				next.bRow = i - 1;
				break;
			}
		}
		
		if(next.rCol==next.bCol&&next.rRow==next.bRow) {
			if(n.rRow<n.bRow) next.rRow--;
			else next.bRow--;
		}
		
		// 구슬이 나왔는지 확인하기
		check(red, blue, n, next);
		
		n = q.poll();
		red = false; blue = false;
		
		next = new Marble();

		next.rCol = n.rCol;
		next.bCol = n.bCol;
		// 위쪽으로 빨간 구슬 굴리기
		for(int i=n.rRow;i>=0;i--) {
			if(board[i][n.rCol]=='O') {
				red = true;
				break;
			}
			else if(board[i][n.rCol]!='#') continue;
			else {
				next.rRow = i + 1;
				break;
			}
		}
		
		// 위쪽으로 파란 구슬 굴리기
		for(int i=n.bRow;i>=0;i--) {
			if(board[i][n.bCol]=='O') {
				blue = true;
				break;
			}
			else if(board[i][n.bCol]!='#') continue;
			else {
				
				next.bRow = i + 1;
				break;
			}
		}
		
		
		if(next.rCol==next.bCol&&next.rRow==next.bRow) {
			if(n.rRow<n.bRow) next.bRow++;
			else next.rRow++;
		}
		
		// 구슬이 나왔는지 확인하기
		check(red, blue, n, next);
		
		bfs();
	}
	
	public static void check(boolean red, boolean blue, Marble n, Marble next) {
		if(blue) {}
		else if(red&&!blue) {
			System.out.println(n.count+1);
			System.exit(0);
		}
		else if(n.rRow==next.rRow&&n.rCol==next.rCol&&n.bRow==next.bRow&&n.bCol==next.bCol) {
			
		}
		else if(visited[next.rRow][next.rCol][next.bRow][next.bCol]!=1) {
			visited[next.rRow][next.rCol][next.bRow][next.bCol] = 1;
			next.count = n.count + 1;
			q.add(next);
		}
	}
}
