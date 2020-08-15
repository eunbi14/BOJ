import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*class Node{
	
	int x, y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}*/

public class Main {
	static int N, M;
	static int answer = 999999999;
	static ArrayList<Node> chicken = new ArrayList<Node>();
	static ArrayList<Node> home = new ArrayList<Node>();
	static int[][] city;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken()); //도시크기
		M = Integer.parseInt(st.nextToken()); //치킨집 최대 수
		city = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j]==1) home.add(new Node(i, j));
				else if(city[i][j]==2) {
					chicken.add(new Node(i, j));
				
				}
			}
		}
		boolean[] open = new boolean[chicken.size()];
		
		solution(0, 0, open);
		
		System.out.println(answer);
		
	}

	private static void solution(int index, int count, boolean[] open) {
		// TODO Auto-generated method stub
		if(count>=M) return;
		if(index>=open.length) return;
		open[index] = true;
		int home_d;
		int city_d = 0;
		for(int i=0;i<home.size();i++) {
			home_d = Integer.MAX_VALUE;
			for(int j=0;j<open.length;j++) {
				if(open[j]) {
					int k = Math.abs(home.get(i).x-chicken.get(j).x) + Math.abs(home.get(i).y-chicken.get(j).y);
					
					if(home_d>k) {
					
						home_d = k;
					}
				}
			}
		
			city_d += home_d;
		}
		
		
		if(city_d!=0 && answer>city_d) {
			
			answer = city_d;
		}
		
		solution(index+1, count+1, open);
		open[index] = false;
		solution(index+1, count, open);
	}


}
