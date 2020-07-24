package 동적프로그래밍;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 파도반수열_9461 {
	static ArrayList<Long> pa = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.valueOf(bf.readLine());
		
		for(int i=0;i<t;i++) {
			int n = Integer.valueOf(bf.readLine());
			bw.write(String.valueOf(p(n))+"\n");
			for(int j=0;j<n;j++) bw.write(String.valueOf(pa.get(j))+"\n");
		}
		
		
		bw.flush();
		bw.close();
	}

	private static long p(int n) {
		// TODO Auto-generated method stub
		if(pa.size()>=n) return pa.get(n-1);
		if(n<6) {
			if(pa.size()==0) pa.add((long) 1);
			if(pa.size()==1) pa.add((long) 1);
			if(pa.size()==2) pa.add((long) 1);
			if(pa.size()==3) pa.add((long) 2);
			if(pa.size()==4) pa.add((long) 2);
			
			return pa.get(n-1);						
		}
		pa.add(p(n-1)+p(n-5));
		return pa.get(n-1);
	}

}
