import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long z;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long x, y;
		String[] s = bf.readLine().split(" ");
		x = Long.valueOf(s[0]);
		y = Long.valueOf(s[1]);
		
		z = y * 100 / x;
		if(z>=99) System.out.println(-1);
		else {
			
			long left = 1;
			long right = x;
			long answer = 0;
			long temp = 0;
	
			while(left<=right) {
				
				answer = (left+right)/2;
				temp =(y+answer)*100/(x+answer);
				if(temp>z) {
					right = answer -1;
					
				}
				else {
					left = answer+1;
				}
			}
			
			System.out.println(left);
			//여기서 answer를 출력해서 계속 헤맸다. answer 아니고 left 출력하기!
		}
	
		
	}

}
