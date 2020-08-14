package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 게리맨더링_17471 {
	static int N; // 지역 수
	static int[] population; // 인구
	static int answer = 10000;
	static boolean[][] connect; // 연결 되어 있는지 여부

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		population = new int[N+1];
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for(int i=1;i<=N;i++) population[i] = Integer.parseInt(st.nextToken());
		connect = new boolean[N+1][N+1];
	
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			st.nextToken();
			while(st.hasMoreTokens()) {
				int k = Integer.parseInt(st.nextToken());
				connect[i][k] = true;
				connect[k][i] = true;
			}
		}
		
		char[] AB = new char[N+1]; // A선거구인지 B선거구인지 저장
		Arrays.fill(AB, 'A'); // 처음에 다 A로 두고 -> 이걸 B로 하면 틀림!!! 왜?
		solution(1, AB); // 하나씩 A로 바꿔가기
		
		if(answer==10000) answer = -1;
		System.out.println(answer);
	}
	
	private static void solution(int index, char[] AB) {
		if(index>N) return;
		
		AB[index] = 'A';
		boolean[] visited = new boolean[N+1];
		int a = 0, b = 0;
		for(int i=1;i<=N;i++) {
			if(AB[i]!='A') {
				a = i;
				break;
			}
		}
		for(int i=1;i<=N;i++) {
			if(AB[i]!='B') {
				b = i;
				break;
			}
		}
		
		// 조건들을 다 만족해서 인구차를 비교해도 되는지 확인
		if(ABrate(AB) && check(AB, 'A', visited, a) && check(AB, 'B', visited, b)) compare(AB);
		solution(index+1, AB);
		AB[index] = 'B';
		for(int i=1;i<=N;i++) {
			if(AB[i]!='A') {
				a = i;
				break;
			}
		}
		if(ABrate(AB) && check(AB, 'A', visited, a) && check(AB, 'B', visited, b)) compare(AB);
		solution(index+1, AB);
		
	}

	private static boolean ABrate(char[] AB) {
		// A나 B 선거구 중 0개의 지역이 속한 경우 false 리턴
		int a = 0, b = 0;
		for(int i=1;i<=N;i++) {
			if(AB[i]=='A') a++;
			else b++;
		}
		
		if(a==0||b==0) return false;
		else return true;
	}
	
	private static boolean check(char[] AB, char c, boolean[] visited, int start) {
		// c가 아닌 선거구에서 모든 지역이 다 연결되어 있는지 확인
		if(visited[start]) return false;
		if(AB[start]==c) return false;
		visited[start] = true;
		
		for(int i=1;i<=N;i++) {
			if(connect[start][i]) {
				check(AB, c, visited, i);
			}
		}
		
		
		
		for(int i=1;i<=N;i++) {
			if(AB[i]!=c && !visited[i]) return false;
		}
		return true;
	}

	private static void compare(char[] AB) {
		// 두 선거구 인구 비교
		int dif = 0;
		for(int i=1;i<=N;i++) {
			if(AB[i]=='A') dif += population[i];
			else dif -= population[i];
		}
	
		answer = Math.min(answer, Math.abs(dif));
	}

}
