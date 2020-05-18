//O(3hw)
//µµÂøÁöÁ¡(0,0), ÁË¼ö1, ÁË¼ö2 °¡ ¸ðµç Ä­¿¡¼­ ¸¸³ª´Â °¡ÁßÄ¡¸¦ °í·Á
package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Å»¿Á_9367 {
	static int h, w;
	static char[][] map;
	static int[][] check_end, check_one, check_two;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int[] print = new int[T];
		for(int i=0;i<T;i++) {
			String[] str = bf.readLine().split(" ");
			h = Integer.parseInt(str[0]);
			w = Integer.parseInt(str[1]);
			
			map = new char[h+2][w+2];
			for(int j=0;j<w+2;j++) {
				map[0][j] = '.';
				map[h+1][j] = '.';
			}
			
			for(int j=1;j<h+1;j++) {
				map[j][0] = '.';
				map[j][w+1] = '.';
			}
			Node[] prisoner = new Node[2];
			int index = 0; //ÁË¼öµé ¹è¿­¿¡ ³ÖÀ» ÀÎµ¦½º
			for(int j=1;j<h+1;j++) {
				String s = bf.readLine();
				for(int k=1;k<w+1;k++) {
					map[j][k] = s.charAt(k-1);
					if(map[j][k]=='$') {
						
						map[j][k] = '.';
						prisoner[index] = new Node(j, k);
						index = 1;
					}
				}
			}
			
			
			
			check_end = new int[h+2][w+2];
			for(int j=0;j<h+2;j++) {
				Arrays.fill(check_end[j], -1);
			}
			bfs(0,0, check_end);

			check_one = new int[h+2][w+2];
			for(int j=0;j<h+2;j++) Arrays.fill(check_one[j], -1);
			bfs(prisoner[0].x, prisoner[0].y, check_one);
			
			check_two = new int[h+2][w+2];
			for(int j=0;j<h+2;j++) Arrays.fill(check_two[j], -1);
			bfs(prisoner[1].x, prisoner[1].y, check_two);
			
			int answer = 20000;
			for(int j=0;j<h+2;j++) {
				for(int k=0;k<w+2;k++) {
					if(map[j][k]=='*') continue;
					int count = check_end[j][k]+check_one[j][k]+check_two[j][k];
					if(map[j][k]=='#') count = count -2;
					if(count>=0&&answer>count) {
						
						answer = count;
					}
				}
			}
			
			print[i] = answer;
		}
		
		for(int i:print) System.out.println(i);
		
	}

	private static void bfs(int x, int y, int[][] check) {
		// TODO Auto-generated method stub
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(x, y));
		check[x][y] = 0;
		while(!deque.isEmpty()) {
			Node n = deque.poll();
			x = n.x;
			y = n.y;
		//	System.out.println("n "+n.x+", "+n.y);
			for(int i=0;i<4;i++) {
				int nx =x+dx[i];
				int ny = y + dy[i];
				if(nx<0||ny<0||nx>=h+2||ny>=w+2) continue;
				if(check[nx][ny]!=-1) continue;
				if(map[nx][ny]=='*') continue;
				if(map[nx][ny]=='#') {
					check[nx][ny] = check[x][y] +1;
				//	System.out.println("# "+nx+", "+ny+": "+check[nx][ny]);
					deque.addLast(new Node(nx, ny));
				}
				else {
					check[nx][ny] = check[x][y];
				//	System.out.println(". "+nx+", "+ny+": "+check[nx][ny]);
					deque.addFirst(new Node(nx,ny));
				}
			}
		}
		
	}


}
