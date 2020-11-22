import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(bf.readLine());
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
		
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			
			// 양방향 연결
			graph[x].add(y);
			graph[y].add(x);
		}
		
		int[] answer = new int[N+1];
	
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i=0;i<graph[x].size();i++) {
				int y = graph[x].get(i);
				if(answer[y]==0) {
					answer[y] = x;
					q.offer(y);
				}
			}
		}
		
		StringBuilder output = new StringBuilder();
		for(int i=2;i<=N;i++) {
			output.append(answer[i]).append("\n");
		}
		
		System.out.println(output);
		
		/*
		// N 범위가 커서 하나하나 출력하는 것보다 StringBuilder 써서 출력하는 게 훨씬 빠름!
		for(int i=2;i<=N;i++) {
			System.out.println(answer[i]);
		}
		*/
	}

}
