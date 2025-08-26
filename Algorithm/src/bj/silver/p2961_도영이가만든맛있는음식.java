package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2961_도영이가만든맛있는음식 {

	static int N, min;
	static int[] sour, bitter;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sour = new int[N];
		bitter = new int[N];
		visited = new boolean[N];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[n] = Integer.parseInt(st.nextToken());
			bitter[n] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		dfs(0, 1, 0, 0);
		
		System.out.println(min);
	}
	
	static void dfs(int depth, int sourC, int bitterC, int nums) {
		if(depth == N) {
			if(nums == 0) return;
			min = Math.min(min, Math.abs(sourC - bitterC));
			return;
		}
		dfs(depth + 1, sourC * sour[depth], bitterC + bitter[depth],nums + 1);//선택
		dfs(depth + 1, sourC, bitterC ,nums);//선택x
	}
}
//N개의 재료, 재료의 S, B
//신맛은 곱, 쓴맛은 합
//신맛 쓴맛 차이 최소로
//재료는 최소 1개