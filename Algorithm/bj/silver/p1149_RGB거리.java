package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] R = new int[N];
		int[] G = new int[N];
		int[] B = new int[N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R[n] = Integer.parseInt(st.nextToken());
			G[n] = Integer.parseInt(st.nextToken());
			B[n] = Integer.parseInt(st.nextToken());
		}
		
		//각 case별 누적 최솟값 구하기
		for(int n = 1; n < N; n++) {
			R[n] += Math.min(G[n - 1], B[n - 1]);
			G[n] += Math.min(R[n - 1], B[n - 1]);
			B[n] += Math.min(R[n - 1], G[n - 1]);
		}
		
		int min = Math.min(R[N-1], Math.min(G[N-1], B[N-1]));
		System.out.println(min);
		br.close();
	}

}
