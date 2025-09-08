package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_1003_피보나치_함수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[][] f = new int[N + 1][2];
			
			f[0] = new int[] {1, 0};
			if(N > 0) f[1] = new int[] {0, 1};
			
			if(N > 1) {
				for(int n = 2; n <= N; n++) {
					f[n][0] = f[n - 1][0] + f[n - 2][0];
					f[n][1] = f[n - 1][1] + f[n - 2][1];
				}
			}
			
			sb.append(f[N][0]).append(" ").append(f[N][1]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
