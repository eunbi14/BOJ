package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class ListGraph {
    private ArrayList<ArrayList<Integer>> listGraph;
 
    // �׷��� �ʱ�ȭ
    public ListGraph(int initSize) {
        this.listGraph = new ArrayList<ArrayList<Integer>>(); // �׷��� ����
     
        for(int i=0; i<initSize+1; i++) {
            listGraph.add(new ArrayList<Integer>());
        }
    }
 
 
    // �׷����� Ư�� ��� return
    public ArrayList<Integer> getNode(int i) {
        return this.listGraph.get(i);
    }
    
    // �׷��� �߰� (�ܹ���)
    public void putSingle(int x, int y) {
        listGraph.get(x).add(y);
    }
    
   
}

public class ���ã��_11403 {
	static int n;
	static ListGraph G;
	static int[][] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(bf.readLine());
		G = new ListGraph(n);
		answer = new int[n][n];
		
		for(int i=1;i<=n;i++) {
			String line = bf.readLine();
			for(int j=0;j<n;j++) {
				if(line.charAt(2*j)=='1') G.putSingle(i, j+1);	
			}
		}
		
		
		for(int i=1;i<=n;i++) check(i, i);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) System.out.print(answer[i][j] + " ");
			System.out.println();
		}
	}

	private static void check(int k, int start) {
		// TODO Auto-generated method stub
		for(int i=0; i<G.getNode(k).size(); i++) {
			
			if(answer[start-1][G.getNode(k).get(i)-1]==1) continue;
			else{
				
				answer[start-1][G.getNode(k).get(i)-1] = 1;
				check(G.getNode(k).get(i), start);
			}
			
		}
	}

}
