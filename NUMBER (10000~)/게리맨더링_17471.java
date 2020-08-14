package ���Ʈ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �Ը��Ǵ���_17471 {
	static int N; // ���� ��
	static int[] population; // �α�
	static int answer = 10000;
	static boolean[][] connect; // ���� �Ǿ� �ִ��� ����

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
		
		char[] AB = new char[N+1]; // A���ű����� B���ű����� ����
		Arrays.fill(AB, 'A'); // ó���� �� A�� �ΰ� -> �̰� B�� �ϸ� Ʋ��!!! ��?
		solution(1, AB); // �ϳ��� A�� �ٲ㰡��
		
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
		
		// ���ǵ��� �� �����ؼ� �α����� ���ص� �Ǵ��� Ȯ��
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
		// A�� B ���ű� �� 0���� ������ ���� ��� false ����
		int a = 0, b = 0;
		for(int i=1;i<=N;i++) {
			if(AB[i]=='A') a++;
			else b++;
		}
		
		if(a==0||b==0) return false;
		else return true;
	}
	
	private static boolean check(char[] AB, char c, boolean[] visited, int start) {
		// c�� �ƴ� ���ű����� ��� ������ �� ����Ǿ� �ִ��� Ȯ��
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
		// �� ���ű� �α� ��
		int dif = 0;
		for(int i=1;i<=N;i++) {
			if(AB[i]=='A') dif += population[i];
			else dif -= population[i];
		}
	
		answer = Math.min(answer, Math.abs(dif));
	}

}
