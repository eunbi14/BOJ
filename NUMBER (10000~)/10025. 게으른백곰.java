import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		int[] fence = new int[1000001];
		int max = 0;
		// min 값도 해주면 좋을 듯!
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			int g = Integer.valueOf(st.nextToken());
			int x = Integer.valueOf(st.nextToken());
			fence[x] = g;
			if(x>max) max = x;
		}
		
		int answer = 0;
		
		for(int i=0;i<=2*K&&i<=1000000;i++) {
			answer += fence[i];
		}
		
		int tmp = answer;
		for(int i=0;i<=max-(2*K)&&i<=1000000;) {
			tmp -= fence[i];
			i++;
			tmp += fence[i+(2*K)];
			if(tmp>answer) answer = tmp;
		}
		
		System.out.println(answer);
	}

}
