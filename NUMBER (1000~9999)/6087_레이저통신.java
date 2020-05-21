package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

/*class Node{
	int x, y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}*/

public class 레이저통신_6087 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int H, W;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] str = bf.readLine().split(" ");
		W = Integer.parseInt(str[0]);
		H = Integer.parseInt(str[1]);
		char[][] map = new char[H][W];
		Node[] laser = new Node[2];
		int k=0;
		for(int i=0;i<H;i++) {
			String s = bf.readLine();
			for(int j=0;j<W;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='C') {
					laser[k] = new Node(i, j);
					k = 1;
				}
			}
		}
		
		int[][] visited = new int[H][W];
		for(int i=0;i<H;i++) Arrays.fill(visited[i], -1);
		bfs(laser, visited, map);
		System.out.println(visited[laser[1].x][laser[1].y]-1);
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static void bfs(Node[] laser, int[][] visited, char[][] map) {
		// TODO Auto-generated method stub
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(laser[0].x, laser[0].y));
		visited[laser[0].x][laser[0].y] = 0;
		int line = 1;
		while(!deque.isEmpty()) {
			Node n = deque.poll();
			int x = n.x;
			int y = n.y;
			line = visited[x][y]+1;
			for(int i=0;i<4;i=i+1) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				while(true) {
					if(nx<0||ny<0||nx>=H||ny>=W) break;
					if(visited[nx][ny]!=-1) {
						nx = nx + dx[i];
						ny = ny + dy[i];
						continue;
					}
					if(map[nx][ny]=='*') break;
					visited[nx][ny] = line;
					if(nx==laser[1].x&&ny==laser[1].y) {
						
						
						return;
					}
					deque.add(new Node(nx, ny));
					nx = nx + dx[i];
					ny = ny + dy[i];
				}
				
				
			}
		}
	}

}
