package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1735_최단경로 {

	static int V, E, K;
	static StringBuilder sb;
	static ArrayList<Path>[] fromto;
	static PriorityQueue<Path> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); //정점 수
		E = Integer.parseInt(st.nextToken()); //간선 수
		K = Integer.parseInt(br.readLine());  //시작 점
		
		fromto = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) fromto[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			fromto[from].add(new Path(to, dist));
		}
		
		dijkstra();
		
		System.out.println(sb);
		br.close();
	}
	
	static void dijkstra() {
		
		q = new PriorityQueue<>();
		q.offer(new Path(K, 0));
		
		int[] dist = new int[V + 1];
		for(int i = 1; i <= V; i++) dist[i] = Integer.MAX_VALUE;
		dist[K] = 0;
		
		while(!q.isEmpty()) {
			Path p = q.poll();
			int from = p.to;
			int d = p.dist;
			
			if(d > dist[from]) continue;
			
			for(Path np : fromto[from]) {
				int to = np.to;
				int nd = d + np.dist;
				if(nd >= dist[to]) continue;
				dist[to] = nd;
				q.add(new Path(to, nd));
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}
			else sb.append(dist[i]).append("\n");
		}
	}
	
	static class Path implements Comparable<Path> {
		
		int to, dist;
		
		public Path(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Path o) {
			return this.dist - o.dist;
		}
	}
}
