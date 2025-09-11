package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2133_타일_채우기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[31];
		
		dp[0] = 1;
		dp[2] = 3;
		
		for(int n = 4; n <= 30; n += 2)
			dp[n] = 4 * dp[n - 2] - dp[n - 4];
		
		System.out.println(dp[N]);
	}
}
