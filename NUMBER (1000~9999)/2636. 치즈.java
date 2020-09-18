import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node{
	int x, y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Main {
	static Stack<Node> air = new Stack<>();
	static int[][] board;
	static int a, b;
	static int time = 0;
	static int cheeze = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		a = Integer.parseInt(st.nextToken()); //세로 길이
		b = Integer.parseInt(st.nextToken()); //가로 길이
		board = new int[a][b];
		
		for(int i=0;i<a;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for(int j=0;j<b;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j]==1) cheeze++;
			}
		}
		
		int one = 0;
		
		while(true) {
			boolean[][] visited = new boolean[a][b];
			air.add(new Node(0, 0));
			bfs(visited); //공기 부분을 전부 2로 바꿔주기 
			
			one = melt(); // 공기랑 접촉한 부분 녹이기, 녹은 개수 turn에 저장
			time++;
			if(cheeze==0) break;
		
			
		}
		
		System.out.println(time+"\n"+one);
		
	}


	private static int melt() {
		// TODO Auto-generated method stub
		int one = 0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(board[i][j]==1) {
					if(i+1<a&&board[i+1][j]==2) {
						board[i][j] = 3;
						cheeze--;
						one++;
						continue;
					}
					if(j+1<b&&board[i][j+1]==2) {
						board[i][j] = 3;
						cheeze--;
						one++;
						continue;
					}
					if(i-1>=0&&board[i-1][j]==2) {
						board[i][j] = 3;
						cheeze--;
						one++;
						continue;
					}
					if(j-1>=0&&board[i][j-1]==2) {
						board[i][j] = 3;
						cheeze--;
						one++;
						continue;
					}
				}
			}
		}
		
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(board[i][j]==3) board[i][j] = 2;
			}
		}
		
	
		
		return one;
	}

	private static void bfs(boolean[][] visited) {
		// TODO Auto-generated method stub
		while(!air.isEmpty()) {
			int i = air.peek().x;
			int j = air.pop().y;
			
			if(visited[i][j]) continue;
			visited[i][j] = true;
			board[i][j] = 2;
			if(i+1<a&&board[i+1][j]!=1) air.add(new Node(i+1, j));
			if(j+1<b&&board[i][j+1]!=1) air.add(new Node(i, j+1));
			if(i-1>=0&&board[i-1][j]!=1) air.add(new Node(i-1, j));
			if(j-1>=0&&board[i][j-1]!=1) air.add(new Node(i, j-1));
		}
		
		
	}

}
