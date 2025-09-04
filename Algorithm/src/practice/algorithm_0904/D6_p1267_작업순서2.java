package practice.algorithm_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D6_p1267_작업순서2 {
	
	static int V, E;
	static boolean[] isDone; // BFS에서는 필요 없지만, 변수명 유지
	static ArrayList<Integer>[] fromto;
	static StringBuilder sb = new StringBuilder();

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		long beforeTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			fromto = new ArrayList[V + 1];
			for(int v = 1; v <= V; v++) fromto[v] = new ArrayList<Integer>();
			
			int[] indegree = new int[V + 1]; // 진입 차수 배열 추가
			
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken()); 
				fromto[from].add(to);
				indegree[to]++; // 진입 차수 증가
			}
			
			isDone = new boolean[V + 1]; // BFS에서는 사실 필요 없음
			
			Queue<Integer> q = new ArrayDeque<>();
			
			// 진입 차수 0인 노드를 큐에 삽입
			for(int v = 1; v <= V; v++) {
				if(indegree[v] == 0) {
					q.offer(v);
					isDone[v] = true;
				}
			}
			
			// BFS (Kahn’s Algorithm)
			while(!q.isEmpty()) {
				int cur = q.poll();
				sb.append(cur).append(" ");
				
				for(int next : fromto[cur]) {
					indegree[next]--;
					if(indegree[next] == 0 && !isDone[next]) {
						q.offer(next);
						isDone[next] = true;
					}
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
		long afterTime = System.currentTimeMillis(); 
		System.out.println("시간차이(ms) : "+ (afterTime - beforeTime));
	}
}