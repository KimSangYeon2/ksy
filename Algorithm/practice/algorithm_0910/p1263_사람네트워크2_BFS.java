package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//가중치 1이라 BFS도 가능할듯
public class p1263_사람네트워크2_BFS {

	static int N, ans;
	static ArrayList<Integer>[] fromto;
	static Queue<Integer> q;
	
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
						fromto[from].add(to);
			
			ans = Integer.MAX_VALUE;
			for(int from = 1; from <= N; from++)
				ans = Math.min(ans, bfs(from));
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static int bfs(int in) {
	    q = new ArrayDeque<>();
	    q.offer(in);

	    boolean[] visited = new boolean[N + 1];
	    visited[in] = true;

	    int[] dist = new int[N + 1];

	    while (!q.isEmpty()) {
	        int from = q.poll();
	        for (int next : fromto[from]) {
	            if (visited[next]) continue;
	            visited[next] = true;
	            dist[next] = dist[from] + 1;
	            q.add(next);
	        }
	    }

	    int sum = 0;
	    for (int n = 1; n <= N; n++) sum += dist[n];
	    return sum;
	}
}
