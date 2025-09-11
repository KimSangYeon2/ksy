package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1248_공통조상 {
	
	static int V, E, A, B, cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] fromto;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			fromto = new ArrayList[V + 1];
			for(int v = 1; v <= V; v++) fromto[v] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				fromto[parent].add(child);
			}
			
			int n = 0;
			int minParent = 0;
			for(int v = 1; v <= V; v++) {
				bfs(v);
				if(visited[A] && visited[B]) {
					n = cnt;
					minParent = v;
				}
			}
			
			sb.append("#").append(t).append(" ").append(minParent).append(" ").append(n).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfs(int in) {
		q = new ArrayDeque<>();
		q.offer(in);
		
		visited = new boolean[V + 1];
		cnt = 1;
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			
			for(int child : fromto[parent]) {
				if(visited[child]) continue;
				visited[child] = true;
				q.offer(child);
				cnt++;
			}
		}
	}
}
