package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

/*class Node{
	int x, y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}*/

public class 열쇠_9328 {
	static int answer = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int h, w;
	static char[][] map;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		int[] answers = new int[T];

		for (int t = 0; t < T; t++) {
			String[] str = bf.readLine().split(" ");
			h = Integer.parseInt(str[0]);
			w = Integer.parseInt(str[1]);

			map = new char[h + 2][w + 2];
			for (int i = 0; i < w + 2; i++) {
				map[0][i] = '.';
				map[h + 1][i] = '.';
			}
			for (int i = 1; i < h + 1; i++) {
				map[i][0] = '.';
				map[i][w + 1] = '.';
			}

			for (int i = 1; i < h + 1; i++) {
				String s = bf.readLine();
				for (int j = 1; j < w + 1; j++) {
					map[i][j] = s.charAt(j - 1);

				}
			}

			String s = bf.readLine();
			ArrayList<Character> key = new ArrayList<>();
			if (!s.equals("0")) {

				for (int i = 0; i < s.length(); i++)
					key.add(s.charAt(i));
			}

			
			ArrayList<Node>[] door = new ArrayList[26];
			for(int i=0;i<26;i++) door[i] = new ArrayList<>();
			boolean[][] visited = new boolean[h + 2][w + 2];
			bfs(0, 0, visited, key, door);

			answers[t] = answer;
			answer = 0;
		}

		for (int i : answers)
			System.out.println(i);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void bfs(int x, int y, boolean[][] visited, ArrayList<Character> key, ArrayList[] door) {
		// TODO Auto-generated method stub
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(new Node(x, y));
		visited[x][y] = true;
		while (!deque.isEmpty()) {
			Node n = deque.poll();
			x = n.x;
			y = n.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= h + 2 || ny >= w + 2)
					continue;
				if (visited[nx][ny])
					continue;
				visited[nx][ny] = true;

				if (map[nx][ny] == '*')
					continue;
				// System.out.println(map[nx][ny]+" : "+nx+", "+ny);
				if (map[nx][ny] == '$') {
					answer++;
					deque.add(new Node(nx, ny));
					continue;
				}
				if (map[nx][ny] >= 97 && map[nx][ny] <= 122) { // 소문자
					if(!key.contains(map[nx][ny])) {
						key.add(map[nx][ny]);
					}
						deque.add(new Node(nx, ny));
						for (int j = 0; j < 26; j++) {
							if (door[j].size() != 0) {
								ArrayList<Node> open = door[j];
								for(int k=0;k<open.size();k++) {
									Node node = open.get(k);
									if (key.contains((char) (map[node.x][node.y] + 32))) {
										map[node.x][node.y] = '.';
										deque.add(new Node(node.x, node.y));
									}
								}
								
							}
						}
					
					
					
				}
				if (map[nx][ny] >= 65 && map[nx][ny] <= 90) { // 대문자
					if (key.contains((char) (map[nx][ny] + 32))) {
						map[nx][ny] = '.';
						deque.add(new Node(nx, ny));
					} else {
						door[map[nx][ny] - 65].add(new Node(nx, ny));
					}

				}
				if (map[nx][ny] == '.')
					deque.add(new Node(nx, ny));
			}
		}
	}

}
