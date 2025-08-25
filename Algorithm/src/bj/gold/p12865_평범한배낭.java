package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p12865_평범한배낭 {

	static int N, K;
	static int[] W, V, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//배열에 무게, 가치 입력하기
		W = new int[N + 1];
		V = new int[N + 1];
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			W[n] = Integer.parseInt(st.nextToken());
			V[n] = Integer.parseInt(st.nextToken());
		}
		
		
		dp = new int[K + 1]; //무게 별 최대 가치
		for (int n = 1; n <= N; n++) { //물건마다 갱신
		    for (int w = K; w >= W[n]; w--) { //무게별로 dp 갱신
		        dp[w] = Math.max(dp[w], dp[w - W[n]] + V[n]); //선ㅌ
		    }
		}
		  //무게 낮은 곳 부터 갱신하면 중복 발생..
		  //for (int w = W[n]; w <= K; w++) {
		  //    dp[w] = Math.max(dp[w], dp[w - W[n]] + V[N]);
		  //}
		
		System.out.println(dp[K]);
	}
}
//무게 W, 가치 V, 최대 K
