package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p7465_창용마을_무리의_개수 {
	
	static int N, M;//사람 수, 관계 수
	static boolean[] visited;
	static ArrayList<Integer>[] fromto;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			fromto = new ArrayList[N + 1];
			for(int i = 0; i < N + 1; i++) fromto[i] = new ArrayList<Integer>();
			
			visited = new boolean[N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				fromto[a].add(b); fromto[b].add(a); 
			}
			
			int count = 0;
			for(int n = 1; n < N + 1; n++) {
				if(!visited[n]) {//방문하지 않았으면 탐색 시작
					dfs(n);
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int in) {
		visited[in] = true;//방문 여부 체크
		for(int next : fromto[in])//연결된 곳 탐색 시작
			if(!visited[next]) dfs(next);//방문하지 않았으면 탐색
	}
}
//1번부터 N번까지 방문여부 체크하면서 그룹개수 ++
//별자리 개수 counting에서 dfs를 node따라서 하는 로직