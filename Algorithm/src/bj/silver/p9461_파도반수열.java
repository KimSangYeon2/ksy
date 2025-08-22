package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9461_파도반수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		for(int i = 3; i <= 100; i++) P[i] = P[i-3] + P[i-2];
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P[N]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
//P[N] = P[N-3] + P[N-2]