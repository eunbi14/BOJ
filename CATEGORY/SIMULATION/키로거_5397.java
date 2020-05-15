package 시뮬레이션;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class 키로거_5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		ArrayList<Stack<Character>> answer = new ArrayList<>();
		for(int i=0;i<T;i++) {
			String s = bf.readLine();
			answer.add(solution(s));
		}
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<T;i++) {
			Stack<Character> b = answer.get(i);
			while(!b.isEmpty()) {
				bw.write(b.pop());
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

	private static Stack<Character> solution(String s) {
		// TODO Auto-generated method stub
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='<') {
				if(!left.isEmpty()) right.add(left.pop());
			}
			else if(s.charAt(i)=='>') {
				if(!right.isEmpty()) left.add(right.pop());
			}
			else if(s.charAt(i)=='-') {
				if(!left.isEmpty()) {
					left.pop();
				}
				
			}
			else {
				left.add(s.charAt(i));
			}
		}
		
//		while(!left.isEmpty()) {
//			System.out.println(left.pop());
//		}
		
		while(!left.isEmpty()) {
			right.add(left.pop());
		}
		
//		System.out.println("right--");
//		while(!right.isEmpty()) {
//			
//			System.out.println(right.pop());
//		}
		return right;
	}

}
