package practice.algorithm_0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 공통 문자 수열
public class g5_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		
		int nA = A.length();
		int nB = B.length();
		int[][] dp = new int[nA + 1][nB + 1];
		for(int a = 1; a <= nA; a++) {
			for(int b = 1; b <= nB; b++) {
				if(A.charAt(a - 1) == B.charAt(b - 1)) dp[a][b] = dp[a - 1][b - 1] + 1;
				else dp[a][b] = Math.max(dp[a - 1][b], dp[a][b - 1]);
			}
		}
		
		System.out.println(dp[nA][nB]);
		br.close();
	}
}


// 공통 문자열
//public class g5_9251_LCS {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String A = br.readLine();
//		String B = br.readLine();
//		
//		int nA = A.length();
//		int nB = B.length();
//		int ans = 0;
//		int[][] dp = new int[nA + 1][nB + 1];
//		for(int a = 1; a <= nA; a++) {
//			for(int b = 1; b <= nB; b++) {
//				if(A.charAt(a - 1) == B.charAt(b - 1)) dp[a][b] = dp[a - 1][b - 1] + 1;
//				else dp[a][b] = 0;
//				ans = Math.max(ans, dp[a][b]);
//			}
//		}
//		
//		System.out.println(ans);
//		br.close();
//	}
//}