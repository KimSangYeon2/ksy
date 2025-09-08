package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1_1932_정수_삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N + 1][N + 1];
		
		for(int y = 1; y <= N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 1; x <= N; x++) {
				if(!st.hasMoreTokens()) break;
				nums[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][] dp = new int[N + 1][N + 1];
		dp[1][1] = nums[1][1];
		int ans = dp[1][1];
		if(N > 1) {
			for(int y = 2; y <= N; y++) {
				for(int x = 1; x <= N; x++) {
					dp[y][x] = Math.max(dp[y - 1][x - 1] + nums[y][x], dp[y - 1][x] + nums[y][x]);
					ans = Math.max(ans, dp[y][x]);
				}
			}
		}
		
		System.out.println(ans);
	}
}
