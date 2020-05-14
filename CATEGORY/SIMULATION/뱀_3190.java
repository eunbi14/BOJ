package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 뱀_3190 {
	static int time = 0;
	static int n;
	static int[][] board;
	static LinkedList<String> side = new LinkedList<>(); //방향변환 정보 저장할 큐
	static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static LinkedList<Integer> snail = new LinkedList<>(); // 뱀이 있는 칸 저장할 큐
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(bf.readLine()); //보드의 크기
		int k = Integer.parseInt(bf.readLine()); //사과 개수
		board = new int[n+1][n+1];
		StringTokenizer st;
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; //사과가 있으면 1
		}
		
		int l = Integer.parseInt(bf.readLine()); //방향변환 수
		
		for(int i=0;i<l;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			side.add(st.nextToken());
			side.add(st.nextToken());
		}
		board[1][1] = 2; //뱀이 시작하는 곳을 2
		snail.add(1);
		snail.add(1);
		start(1, 1, 0, 1); //(1,1)에서 출발하고 오른쪽으로 가는 뱀
		
		System.out.println(time);
	}

	private static void start(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		int nextX = i+k;
		int nextY = j+l;
		time++;
		if(nextX>n||nextX<=0||nextY>n||nextY<=0) return; //벽에 부딪히면 끝
		if(board[nextX][nextY]==2) return; //뱀에 부딪히면 끝
		int tmp = board[nextX][nextY];
		
		board[nextX][nextY] = 2;
		snail.add(nextX);
		snail.add(nextY);
		if(tmp!=1) {
			board[snail.pop()][snail.pop()] = 0;
		}
		if(!side.isEmpty()) {
			if(Integer.parseInt(side.peek())==time) {
				side.poll();
				
				String d = side.poll();
				
				if(d.equals("D")) {
					for(int z=0;z<4;z++) {
						if(k==dir[z][0]&&l==dir[z][1]) {
							if(z<3) {
								k = dir[z+1][0];
								l = dir[z+1][1];
								break;
							}
							else {
								k = dir[0][0];
								l = dir[0][1];
								break;
							}
						}
					}
					
				}
				else {
					for(int z=0;z<4;z++) {
						if(k==dir[z][0]&&l==dir[z][1]) {
							if(z>0) {
								k = dir[z-1][0];
								l = dir[z-1][1];
								break;
							}
							else {
								k = dir[3][0];
								l = dir[3][1];
								break;
							}
						}
					}
				}
				
				
			}
		}
		
		start(nextX, nextY, k, l);
	}
}
