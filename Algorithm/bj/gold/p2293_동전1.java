package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2293_동전1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n + 1];
		for(int i = 1; i <= n; i++) coin[i] = Integer.parseInt(br.readLine());
		
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++) { //코인별로 확인
			if(coin[i] > k) continue;
			for(int j = coin[i]; j <= k; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}