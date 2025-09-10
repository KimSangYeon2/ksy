package practice.algorithm_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s5215_햄버거_다이어트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] taste = new int[N + 1];
			int[] cal = new int[N + 1];
			
			for(int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				taste[n] = Integer.parseInt(st.nextToken());
				cal[n] = Integer.parseInt(st.nextToken());
			}
			
			int[][] dp = new int[N + 1][L + 1];               
			for(int n = 1; n <= N; n++) {
				for(int l = 1; l <= L; l++) {
					if(cal[n] > l) dp[n][l] = dp[n - 1][l]; 
					else dp[n][l] = Math.max(dp[n - 1][l], dp[n - 1][l - cal[n]] + taste[n]); //안담거나 담거나
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[N][L]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
