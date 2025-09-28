package practice.algorithm_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_p1865_동철이의_일_분배 {//경우의 수가 많아서 dfs로는 불가

	static int N;
	static double ans;
	static int[][] work;
	static int[] result;
	static boolean[] onWork;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			work = new int[N][N];
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					work[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			onWork = new boolean[N];
			chooseWork(0, 1);
			sb.append("#").append(t).append(" ").append(String.format("%.6f", 100.0 * ans)).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	static void chooseWork(int depth, double cur) {
		if(cur <= ans) return;
		if(depth == N) {
			ans = Math.max(ans, cur);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(onWork[i]) continue;//누군가 일 하고있으면 스킵
			onWork[i] = true;
			chooseWork(depth + 1, cur * ( work[depth][i] / 100.0 ));
			onWork[i] = false;
		}
	}
}
