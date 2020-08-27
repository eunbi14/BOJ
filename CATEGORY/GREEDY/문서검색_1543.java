package 그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 문서검색_1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String docu = bf.readLine();
		String find = bf.readLine();
		int count = 0;
		int flag;
		
		//함수 써서해본건데 왠지 모르게 조금 더 오래걸림
//		for(int i=0;i<docu.length();i++) {
//			int idx = docu.indexOf(find);
//			if(idx==-1) break;
//			else {
//				count++;
//				docu = docu.substring(idx+ find.length());
//				i = -1;
//			}
//		}
		
		
		
		for(int i=0;i<docu.length();i++) {
			flag = i+1;
			for(int j=0;j<find.length();j++) {
				if(docu.charAt(i)!=find.charAt(j)) {
					i = flag-1;
					break;
				}
				
				if(j==find.length()-1) {
					count++;
					flag = i+1;
				}
				else i++;
				if(i==docu.length()) break;
			}
			
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		
	}

}
