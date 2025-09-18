package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7511_소셜_네트워킹_어플리케이션 {
	
	static int[] parent;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			sb.append("Scenario ").append(t).append(":\n");
			
			N = Integer.parseInt(br.readLine());
			make();
			
			int K = Integer.parseInt(br.readLine());
			for(int k = 1; k <= K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				union(A, B);
			}
			
			
			int M = Integer.parseInt(br.readLine());
			for(int m = 1; m <= M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if(find(A) == find(B)) sb.append("1\n");
				else sb.append("0\n");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void make() {
		parent = new int[N + 1];
		for(int n = 0; n <= N; n++) parent[n] = n;
	}
	
	static int find(int A) {
		if(parent[A] == A) return A;
		return find(parent[A]);
	}
	
	static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		if(A == B) return;
		if(A > B) parent[B] = A;
		else parent[A] = B;
	}
}
