package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//가중치가 같아서 BFS가 정석, 다익스트라도 가능
public class p18352_특정_거리의_도시_찾기 {

	static int N, M, K, X;
	static ArrayList<Path>[] fromto;
	static PriorityQueue<Path> q;
	static boolean[] isAble;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		fromto = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++) fromto[n] = new ArrayList<Path>();
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			fromto[from].add(new Path(to, 1));
		}
		
		isAble = new boolean[N + 1];
		dijkstra();
		
		boolean zero = true;
		for(int n = 1; n <= N; n++){
			if(isAble[n]) {
				zero = false;
				sb.append(n).append("\n");
			}
		}
		if(zero) sb.append(-1);
		
		System.out.println(sb);
		br.close();
	}
	
	static void dijkstra() {
		q = new PriorityQueue<>();
		q.offer(new Path(X, 0));
		
		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[X] = 0;
		
		while(!q.isEmpty()) {
			Path cur = q.poll();
			int from = cur.to;
			int curDist = cur.dist;
			
			if(curDist == K) {
				isAble[from] = true;
				continue;
			}
			
			if(curDist > dist[from]) continue;
			
			for(Path next : fromto[from]) {
				int to = next.to;
				int nextDist = curDist + next.dist;
				if (nextDist > dist[to]) continue;
	            dist[to] = nextDist;
	            q.offer(new Path(to, nextDist));
			}
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

//도시 N개
//도로 M개
//거리 K개
//도시 X개

