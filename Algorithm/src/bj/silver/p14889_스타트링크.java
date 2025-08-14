package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14889_스타트링크 {

	static int N, teamA, teamB, min;
	static boolean[] selected;
	static int[][] field;
	static int[] ta, tb;
	
	static void dfs(int start, int depth) {
		if(depth == N/2) {
			teamA = 0;
			teamB = 0;
			int cnt = 0;
			selected = new boolean[N];
			
			for(int i = 0; i < N/2; i++)
				selected[ta[i]] = true;
			
			for(int i = 0; i < N; i++)//선택되지 않았으면B팀
				if(!selected[i])
					tb[cnt++] = i;
			
			for(int i = 0; i < N / 2 - 1; i++)
				for(int j = i + 1; j < N / 2; j++) {
					teamA += field[ta[i]][ta[j]] + field[ta[j]][ta[i]];
					teamB += field[tb[i]][tb[j]] + field[tb[j]][tb[i]];
				}
			
			min = Math.min(Math.abs(teamA - teamB), min);
			return;
		}
		for(int i = start; i < N; i++) {
			ta[depth] = i;
			dfs(i + 1, depth + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		field = new int[N][N];
		
		for(int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0; x < N; x++) {
				field[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		ta = new int[N/2];
		tb = new int[N/2];
		min = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(min);
		br.close();
	}

}
