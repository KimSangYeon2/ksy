package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9084_동전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coins = new int[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 1; n <= N; n++) {
				coins[n] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M + 1];
			dp[0] = 1;
			
			for(int n = N; n >= 1; n--) {
				for(int m = 1; m <= M; m++) {
					if(coins[n] > m) continue;
					dp[m] += dp[m - coins[n]];
				}
			}
			
			sb.append(dp[M]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
