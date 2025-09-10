package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//가중치 1이라 BFS도 가능할듯
public class p1263_사람네트워크2_dijkstra {

	static int N, ans;
	static ArrayList<Path>[] fromto;
	static PriorityQueue<Path> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			fromto = new ArrayList[N + 1];
			for(int from = 1; from <= N; from++) fromto[from] = new ArrayList<>();
			
			for(int from = 1; from <= N; from++)
				for(int to = 1; to <= N; to++)
					if(Integer.parseInt(st.nextToken()) == 1)
						fromto[from].add(new Path(to, 1));
			
			ans = Integer.MAX_VALUE;
			for(int from = 1; from <= N; from++)
				ans = Math.min(ans, dijkstra(from));
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static int dijkstra(int in) {
		q = new PriorityQueue<>();
		q.offer(new Path(in, 0));
		
		int[] dist = new int[N + 1];
		for(int n = 1; n <= N; n++) dist[n] = Integer.MAX_VALUE;
		dist[in] = 0;
		
		while(!q.isEmpty()) {
			Path p = q.poll();
			int from = p.to;
			int d = p.dist;
			
			if(d > dist[from]) continue;
			
			for(Path np : fromto[from]) {
				int next = np.to;
				int nd = np.dist + d;
				if(nd >= dist[next]) continue;
				dist[next] = nd;
				q.offer(new Path(next, nd));
			}
		}
		
		int sum = 0;
		for(int n = 1; n <= N; n++) sum += dist[n];
		return sum;
	}
	
	static class Path implements Comparable<Path>{
		
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
