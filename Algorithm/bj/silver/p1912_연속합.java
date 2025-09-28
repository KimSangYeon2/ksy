package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1912_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) nums[n] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N];
		dp[0] = nums[0];
		int max = dp[0];
		for(int n = 1; n < N; n++) {
			dp[n] = Math.max(dp[n - 1] + nums[n], nums[n]);
			max = Math.max(max, dp[n]);
		}
		System.out.println(max);
		br.close();
	}

}
//이전 값에 현재 값을 더했을 때 or 연속 끊기는 경우 중 더 큰 값 저장