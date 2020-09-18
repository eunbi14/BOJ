package ÀÌºÐÅ½»ö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Find_Number_1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		List<Integer> l = new ArrayList<>();
		//System.out.println(bf.read());
		//String[] a = bf.readLine().split(" ");
		
		for(int i=0;i<n-1;i++) {
			int k = bf.read();
			l.add(k);
			bf.read();
		}
		l.add(bf.read());
		bf.readLine();
		int m = Integer.parseInt(bf.readLine());
		//String[] ar = bf.readLine().split(" ");
		for(int i=0;i<m;i++) {
			if(l.contains(bf.read())) bw.write("1\n");
			else bw.write("0"+"\n");
			bf.read();
		}
		
		bw.flush();
		bw.close();
	}

}
