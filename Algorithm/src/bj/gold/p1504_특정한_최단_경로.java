package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1504_특정한_최단_경로 {

	static int N, E;
	static int INF = 200000001;
	static ArrayList<Path>[] fromto;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		fromto = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++) fromto[n] = new ArrayList<>();
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			fromto[a].add(new Path(b, dist));
			fromto[b].add(new Path(a, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N); 
		int ans2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N); 
		
		int ans = Math.min(ans1, ans2);
		if(ans >= INF) ans = -1;
		System.out.println(ans);
		br.close();
	}
	
	static int dijkstra(int from, int to) {
		PriorityQueue<Path> q = new PriorityQueue<>();
		q.offer(new Path(from, 0));
		
		int[] minDist = new int[N + 1];
		for(int n = 1; n <= N; n++) minDist[n] = INF;
		minDist[from] = 0;

		while(!q.isEmpty()) {
			Path cur = q.poll();
			int startNode = cur.to;
			int curDist = cur.dist;
			
			if(curDist > minDist[startNode]) continue;
			
			for(Path next : fromto[startNode]) {
				int nextNode = next.to;
				int nextDist = curDist + next.dist;
				if(nextDist >= minDist[nextNode]) continue;
				minDist[nextNode] = nextDist;
				q.offer(new Path(nextNode, nextDist));
			}
		}
		
		return minDist[to];
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
