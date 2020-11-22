package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int num;
	int important;
	
	public Node(int num, int important) {
		this.num = num;
		this.important = important;
	}
	
}

public class 프린터큐_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		StringTokenizer st = null;
		StringBuilder output = new StringBuilder();
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.valueOf(st.nextToken());
			int M = Integer.valueOf(st.nextToken());
		
			st = new StringTokenizer(bf.readLine());
			int[] maxorder = new int[N];
			Queue<Node> q = new LinkedList<>();
			for(int j=0;j<N;j++) {
				int x = Integer.valueOf(st.nextToken());
		
				q.add(new Node(j, x));
				maxorder[j] = x;
			}
			
			Arrays.sort(maxorder);
			int count = 1;
			int location = maxorder.length - 1;
			while(!q.isEmpty()) {
				Node node = q.poll();
				
				
			
				if(node.important==maxorder[location]) {
					if(node.num==M) {
						output.append(count).append("\n");
						break;
					}
					else {
						location--;
						count++;
					}	
				}
				else {
					q.add(node);
				}
			
			}
		}
		
		System.out.println(output);
	}
}
		
		


