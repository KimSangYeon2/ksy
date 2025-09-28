package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p13023_ABCDE {

	static int N, M, ans;
	static ArrayList<Integer>[] fromto;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fromto = new ArrayList[N];
		for(int i = 0; i < N; i++)
			fromto[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			fromto[from].add(to);
			fromto[to].add(from);
		}
		
		ans = 0;
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			if(ans == 1) break; //답 1 나오면 탐색 그만
			dfs(i, 1);
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int in, int count) {
		if(count == 5) {
			ans = 1; //ABCDE case 찾으면 탐색 x
			return;  
		}
		visited[in] = true;
		for(int i : fromto[in]) {
			if(visited[i]) continue;
			dfs(i, count + 1);
		}
		visited[in] = false;//백트레킹
	}
}
