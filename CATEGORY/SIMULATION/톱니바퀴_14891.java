package ½Ã¹Ä·¹ÀÌ¼Ç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Åé´Ï¹ÙÄû_14891 {
	static StringTokenizer st;
	static BufferedReader bf;
	static char[][] top = new char[5][8]; //Åé´Ï¹ÙÄû
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<5;i++) { //Åé´Ï¹ÙÄû 1,2,3,4
			String s = bf.readLine();
			for (int j=0;j<8;j++) top[i][j] = s.charAt(j);
		}
		
		int K = Integer.parseInt(bf.readLine());
		for(int i=0;i<K;i++) start();
		
		int answer = 0;
		if(top[1][0]=='1') answer = answer + 1;
		if(top[2][0]=='1') answer = answer + 2;
		if(top[3][0]=='1') answer = answer + 4;
		if(top[4][0]=='1') answer = answer + 8;
		
		System.out.println(answer);
	}

	private static void start() throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(bf.readLine(), " ");
		int num = Integer.parseInt(st.nextToken()); //È¸Àü½ÃÅ³ Åé´Ï¹ÙÄû ¹øÈ£
		int direction = Integer.parseInt(st.nextToken()); //È¸Àü½ÃÅ³ ¹æÇâ
		
		switch(num) {
		case 1:
			ro1(direction);
			break;
		case 2:
			ro2(direction);
			break;
		case 3:
			ro3(direction);
			break;
		case 4:
			ro4(direction);
			break;
		}
	}

	private static void ro4(int direction) {
		// TODO Auto-generated method stub
		if(top[4][6]!=top[3][2]) {
			if(top[3][6]!=top[2][2]) {
				if(top[2][6]!=top[1][2]) rotation(1, -direction);
				rotation(2, direction);
			}
			rotation(3, -direction);
		}
		rotation(4, direction);
	}

	private static void ro3(int direction) {
		// TODO Auto-generated method stub
		if(top[3][2]!=top[4][6]) rotation(4, -direction);
		if(top[3][6]!=top[2][2]) {
			if(top[2][6]!=top[1][2]) rotation(1, direction);
			rotation(2, -direction);
		}
		rotation(3, direction);
	}

	private static void ro2(int direction) {
		// TODO Auto-generated method stub
		if(top[2][6]!=top[1][2]) rotation(1, -direction);
		if(top[2][2]!=top[3][6]) {
			if(top[3][2]!=top[4][6]) rotation(4, direction);
			rotation(3, -direction);
		}
		rotation(2, direction);
	}

	private static void ro1(int direction) {
		// TODO Auto-generated method stub
		if(top[1][2]!=top[2][6]) {
			if(top[2][2]!=top[3][6]) {
				if(top[3][2]!=top[4][6]) rotation(4, -direction);
				rotation(3, direction);
			}
			rotation(2, -direction);
		}
		rotation(1, direction);
	}

	private static void rotation(int num, int direction) {
		// Åé´Ï¹ÙÄû È¸Àü½ÃÅ°±â
		char tmp;
		if(direction==1) {
			tmp = top[num][7];
			for(int i=7;i>0;i--) top[num][i] = top[num][i-1];
			top[num][0] = tmp;
		}
		else {
			tmp = top[num][0];
			for(int i=0;i<7;i++) top[num][i] = top[num][i+1];
			top[num][7] = tmp;
		}
	}

}
