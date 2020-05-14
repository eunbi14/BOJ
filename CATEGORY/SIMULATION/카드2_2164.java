package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 카드2_2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		LinkedList<Integer> card = new LinkedList<>();

		if(N%2==0) {
			for(int i=1;2*i<=N;i++) {
				card.add(2*i);
			}
		}
		else {
			for(int i=2;2*i<=N;i++) card.add(2*i);
			if(N>2) card.add(2);
			else card.add(1);
		}

		while(card.size()>1) {
			card.pop();
			card.add(card.pop());
		}
		
		System.out.println(card.peek());
	}
	
}
