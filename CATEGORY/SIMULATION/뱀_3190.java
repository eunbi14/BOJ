package �ùķ��̼�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ��_3190 {
	static int time = 0;
	static int n;
	static int[][] board;
	static LinkedList<String> side = new LinkedList<>(); //���⺯ȯ ���� ������ ť
	static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static LinkedList<Integer> snail = new LinkedList<>(); // ���� �ִ� ĭ ������ ť
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(bf.readLine()); //������ ũ��
		int k = Integer.parseInt(bf.readLine()); //��� ����
		board = new int[n+1][n+1];
		StringTokenizer st;
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; //����� ������ 1
		}
		
		int l = Integer.parseInt(bf.readLine()); //���⺯ȯ ��
		
		for(int i=0;i<l;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			side.add(st.nextToken());
			side.add(st.nextToken());
		}
		board[1][1] = 2; //���� �����ϴ� ���� 2
		snail.add(1);
		snail.add(1);
		start(1, 1, 0, 1); //(1,1)���� ����ϰ� ���������� ���� ��
		
		System.out.println(time);
	}

	private static void start(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		int nextX = i+k;
		int nextY = j+l;
		time++;
		if(nextX>n||nextX<=0||nextY>n||nextY<=0) return; //���� �ε����� ��
		if(board[nextX][nextY]==2) return; //�쿡 �ε����� ��
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
