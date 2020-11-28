package ½Ã¹Ä·¹ÀÌ¼Ç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Robot{
	int x;
	int y;
	char dir;
	
	public Robot(int x, int y, char dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
public class ·Îº¿½Ã¹Ä·¹ÀÌ¼Ç_2174 {
	static Robot[] robot;
	static int A, B;
	static boolean flag;
	static int[][] area;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		A = Integer.valueOf(st.nextToken());
		B = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		area = new int[B+1][A+1];
		robot = new Robot[N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			area[B-y+1][x] = i;
			robot[i] = new Robot(x, B-y+1, st.nextToken().charAt(0));
		}
		
		

		Queue<String> q = new LinkedList<>();
		for(int i=1;i<=M;i++) q.add(bf.readLine());
		
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(q.poll());
			int num = Integer.valueOf(st.nextToken());
			char order = st.nextToken().charAt(0);
			int repeat = Integer.valueOf(st.nextToken());
			if(order=='L') turnLeft(num, repeat);
			else if(order=='R') turnRight(num, repeat);
			else goForward(num, repeat);
			
			if(flag) return;
			
		}
		
		System.out.println("OK");
	}

	private static void goForward(int num, int repeat) {
		// TODO Auto-generated method stub
		char d = robot[num].dir;
		
		int x = 0, y = 0;
		switch(d) {
		case 'N':
			x = 0;
			y = -1;
			break;
		case 'E':
			x = 1;
			y = 0;
			break;
		case 'S':
			x = 0;
			y = 1;
			break;
		case 'W':
			x = -1;
			y = 0;
			break;
		}
		
		int cx = robot[num].x;
		int cy = robot[num].y;
	
		for(int i=0;i<repeat;i++) {
			cx += x;
			cy += y;
		
			if(cx<=0||cx>A||cy<=0||cy>B) {
				System.out.println("Robot " + num + " crashes into the wall");
				flag = true;
				return;
			}
			if(area[cy][cx]!=0) {
				System.out.println("Robot " + num + " crashes into robot " + area[cy][cx]);
				flag = true;
				return;
			}
		}
		
		area[robot[num].y][robot[num].x] = 0;
		area[cy][cx] = num;
		robot[num].x = cx;
		robot[num].y = cy;
	}

	private static void turnRight(int num, int repeat) {
		// TODO Auto-generated method stub
		char[] d = {'N', 'E', 'S', 'W'};
		int index = -1;
		for(int i=0;i<4;i++) {
			if(robot[num].dir==d[i]) {
				index = i;
				break;
			}
		}
		
		repeat %= 4;
		for(int i=0;i<repeat;i++) {
			index++;
			if(index==4) index = 0;
		}
		
		robot[num].dir = d[index];
	}

	private static void turnLeft(int num, int repeat) {
		// TODO Auto-generated method stub
		char[] d = {'N', 'W', 'S', 'E'};
		int index = -1;
		for(int i=0;i<4;i++) {
			if(robot[num].dir==d[i]) {
				index = i;
				break;
			}
		}
		
		repeat %= 4;
		for(int i=0;i<repeat;i++) {
			index++;
			if(index==4) index = 0;
		}
		
	
		robot[num].dir = d[index];
	}

}
