import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] minTree, maxTree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int[] num = new int[N+1];
		for(int i=1;i<=N;i++) num[i] = Integer.valueOf(bf.readLine());
		
		minTree = new int[4*N];
		maxTree = new int[4*N];
		minInit(num, 0, N, 1);
		maxInit(num, 0, N, 1);
		
		int[] minOut = new int[M];
		int[] maxOut = new int[M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			minOut[i] = minQuery(a, b, 1, 0, N);
			maxOut[i] = maxQuery(a, b, 1, 0, N);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb.append(minOut[i]).append(" ").append(maxOut[i]).append("\n");
		}
		
		System.out.println(sb);
	}

	private static int maxQuery(int a, int b, int node, int left, int right) {
		// TODO Auto-generated method stub
		if(a>right||b<left) return 0;
		if(a<=left&&b>=right) return maxTree[node];
		int mid = (left+right)/2;
		return Math.max(maxQuery(a, b, node*2, left, mid), maxQuery(a, b, node*2+1, mid+1, right));
	}

	private static int minQuery(int a, int b, int node, int left, int right) {
		// TODO Auto-generated method stub
		if(a>right||b<left) return Integer.MAX_VALUE;
		if(a<=left&&b>=right) return minTree[node];
		int mid = (left+right)/2;
		return Math.min(minQuery(a, b, node*2, left, mid), minQuery(a, b, node*2+1, mid+1, right));
	}

	private static int maxInit(int[] num, int left, int right, int node) {
		// TODO Auto-generated method stub
		if(left==right) return maxTree[node] = num[left];
		int mid = (left+right)/2;
		return maxTree[node] = Math.max(maxInit(num, left, mid, node*2), maxInit(num, mid+1, right, node*2+1));
	}

	private static int minInit(int[] num, int left, int right, int node) {
		// TODO Auto-generated method stub
		//System.out.println(left+", "+right+", "+node);
		if(left==right) return minTree[node] = num[left];
		int mid = (left+right)/2;
		return minTree[node] = Math.min(minInit(num, left, mid, node*2), minInit(num, mid+1, right, node*2+1));
		
	}

}
