package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1697_숨박꼭질 {

	static int N, K;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(dist[K]);
	}

	static void bfs () {
		
		dist = new int[100001];
		visited = new boolean[100001];
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);
		visited[N] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x == K) break;
			if(x - 1 >= 0 && !visited[x - 1]) {
				q.offer(x - 1);
				visited[x - 1] = true;
				dist[x - 1] = dist[x] + 1;
			}
			if(x + 1 <= 100000 && !visited[x + 1]) {
				q.offer(x + 1);
				visited[x + 1] = true;
				dist[x + 1] = dist[x] + 1;
			}
			if(2 * x <= 100000 && !visited[2 * x]) {
				q.offer(2 * x);
				visited[2 * x] = true;
				dist[2 * x] = dist[x] + 1;
			}
		}
	}
}
