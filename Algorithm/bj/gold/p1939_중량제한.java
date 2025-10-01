package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1939_중량제한 {

	static int N, ans;
	static ArrayList<Path>[] fromto;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		fromto = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++)
			fromto[n] = new ArrayList<>();
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			fromto[a].add(new Path(b, w));
			fromto[b].add(new Path(a, w));
		}
		
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		dijkstra(from, to);
		
		System.out.println(ans);
	}

	static void dijkstra(int from, int to) {
		PriorityQueue<Path> pq = new PriorityQueue<>();
		pq.offer(new Path(from, Integer.MAX_VALUE));
		
		int[] maxWeight = new int[N + 1];
		maxWeight[from] = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			Path cur = pq.poll();
			int s = cur.to;
			int w = cur.weight;
			
			if(s == to) {
				ans = w;
				return;
			}
			
			for(Path p : fromto[s]) {
				int next = p.to;
				int nextW = Math.min(w, p.weight);
				if(nextW <= maxWeight[next]) continue;
				maxWeight[next] = nextW;
				pq.offer(new Path(next, nextW));
			}
		}
	}
	
	static class Path implements Comparable<Path>{
		
		int to, weight;
		
		public Path(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Path o) {
			return o.weight - this.weight;
		}
	}
}
