package dfs_bfs;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 적록색약_10026 {
	static boolean[][] checked;
	static char[][] picture;
	static int num = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(bf.readLine());
		picture = new char[n][n];
		checked = new boolean[n][n];
        
		//String배열로 split하는 것보다 char배열로 charAt 하는게 훨씬 효율적
        for (int i = 0; i < n; ++i) {
            String line = bf.readLine();
            for (int j = 0; j < n; ++j) {
                picture[i][j] = line.charAt(j);
            }
        }
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) none(i, j, 0, picture[i][j]);
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(num-1)+ " ");
		
		num = 1;
		for(int i=0;i<n;i++) Arrays.fill(checked[i], false);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) yes(i, j,0,picture[i][j]);
		}
		
		bw.write(Integer.toString(num-1));
		
		bw.flush();
		bw.close();
		
	}
	
	private static void yes(int i, int j, int first, char color) {
		// TODO Auto-generated method stub
		if(checked[i][j]==true) return;
		else if(color=='R'&&picture[i][j]=='G') {
			checked[i][j] = true;
			if(i>0) yes(i-1, j, 1, color);
			if(j>0) yes(i, j-1, 1, color);
			if(j+1<picture.length) yes(i, j+1, 1, color);
			if(i+1<picture.length) yes(i+1, j, 1, color);
			if(first==0) num++;
		}
		else if(color=='G'&&picture[i][j]=='R') {
			checked[i][j] = true;
			if(i>0) yes(i-1, j, 1, color);
			if(j>0) yes(i, j-1, 1, color);
			if(j+1<picture.length) yes(i, j+1, 1, color);
			if(i+1<picture.length) yes(i+1, j, 1, color);
			if(first==0) num++;
		}
		else if(picture[i][j]!=color) return;
		else {
			checked[i][j] = true;
			if(i>0) yes(i-1, j, 1, color);
			if(j>0) yes(i, j-1, 1, color);
			if(j+1<picture.length) yes(i, j+1, 1, color);
			if(i+1<picture.length) yes(i+1, j, 1, color);
			if(first==0) num++;
		}
	}

	private static void none(int i, int j, int first, char color) {
		// TODO Auto-generated method stub
		if(checked[i][j]==true) return;
		else if(picture[i][j]!=color) return;
		else {
			checked[i][j] = true;
			if(i>0) none(i-1, j, 1, color);
			if(j>0) none(i, j-1, 1, color);
			if(j+1<picture.length) none(i, j+1, 1, color);
			if(i+1<picture.length) none(i+1, j, 1, color);
			if(first==0) num++;
		}
	}

}
