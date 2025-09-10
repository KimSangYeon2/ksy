package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11049_행렬곱셈순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N + 1];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[n] = Integer.parseInt(st.nextToken());
			if(n == N - 1) nums[N] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N + 1][N + 1];
		for(int l = 1; l < N; l++) {
			for(int i = 1; i <= N - l; i++) {
				int j = i + l;
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) { //k번째에서 묶기
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + nums[i - 1] * nums[k] * nums[j]);
				}
			}
		}
			
		System.out.println(dp[1][N]);
		br.close();
	}
}
