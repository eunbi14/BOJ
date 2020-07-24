package 동적프로그래밍;
//몰라!!어려워!!
import java.util.Arrays;
import java.util.Scanner;

public class 최단경로_1753 {
	static Scanner sc = new Scanner(System.in);
	static int v = sc.nextInt(); //정점의 수
	static int[][] connect = new int[v+1][v+1];
	static int[][] mini = new int[v+1][v+1];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int[] row:connect)	Arrays.fill(row, -100);
		for(int[] row:mini)	Arrays.fill(row, -100);
		
		int e = sc.nextInt(); //간선의 수
		int start = sc.nextInt(); //시작정점번호
		
		for(int i=0;i<e;i++) {
			connect[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
		for(int i=1;i<=v;i++) {
			if(shortest(start, i)==-1) System.out.println("INF");
			else System.out.println(shortest(start, i));
		}
		
	}

	private static int shortest(int start, int i) {
		// TODO Auto-generated method stub
		if(start==i) mini[start][i] = 0;
		if(mini[start][i]!=-100) return mini[start][i];
		
		if(connect[start][i]!=-100) {
			mini[start][i] = connect[start][i];
			for(int j=1;j<=v;j++) {
				if(start==j) continue;
				if(j==i) continue;
				mini[start][i] = Math.min(mini[start][i], shortest(start, j) + shortest(j, i));
			}
		}
		else {
			int m = 30000000;
			for(int j=1;j<=v;j++) {
				if(start==j) continue;
				if(j==i) continue;
				m = Math.min(m, shortest(start, j) + shortest(j, i));
				mini[start][i] = m;
			}
		}
		
		
		 return mini[start][i];
		
//		if(connect[start][i]==0) connect[start][i] = 3000000;
//		for(int j=1;j<=v;j++) {
//			if(start==j) continue;
//			else if(i==j) continue;
//			else if(connect[start][j]==-1) continue;
//			else if(connect[j][i]==-1) continue;
//			else connect[start][i] = Math.min(shortest(start,j)+shortest(j,i), connect[start][i]);
//		}
//		if(connect[start][i]==3000000) connect[start][i] = -1;
//		mini[start][i] = connect[start][i];
//		return mini[start][i];
	}

}
