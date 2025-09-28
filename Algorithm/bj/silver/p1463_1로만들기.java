package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1463_1로만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
}
//3으로 나눠지면 3으로 나누기
//2로 나눠지면 2로 나누기
//1 빼기