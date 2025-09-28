package practice.algorithm_0908;

import java.util.Scanner;

public class s2_18352_특정_거리의_도시_찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] dp = new int[N + 1];
		for(int i = 0; i <= N; i++) dp[i] = Integer.MAX_VALUE - 1;
		
		if(N >= 3) dp[3] = 1; 
		if(N >= 5) dp[5] = 1;
		for(int i = 6; i <= N; i++) dp[i] = Math.min(dp[i], Math.min(dp[i - 3] + 1, dp[i - 5] + 1));
		
		if(dp[N] == Integer.MAX_VALUE - 1) dp[N] = -1;
		System.out.println(dp[N]);
	}
}
