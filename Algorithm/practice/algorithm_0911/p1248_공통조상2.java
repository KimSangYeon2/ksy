package practice.algorithm_0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1248_공통조상2 {
	
	static int V, E, A, B, minParent, cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] parentToChild;
	static ArrayList<Integer>[] childToParent;
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
			
			parentToChild = new ArrayList[V + 1];
			childToParent = new ArrayList[V + 1];
			for(int v = 1; v <= V; v++) {
				parentToChild[v] = new ArrayList<>();
				childToParent[v] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parentToChild[parent].add(child);
				childToParent[child].add(parent);
			}
			
			minParent = 0;
			visited = new boolean[V + 1];
			bfsChildtoParent(A);
			bfsChildtoParent(B);
			
			bfsParenttoChild(minParent);
			
			sb.append("#").append(t).append(" ").append(minParent).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfsChildtoParent(int in) {
		q = new ArrayDeque<>();
		q.offer(in);
		
		while(!q.isEmpty()) {
			int child = q.poll();
			
			for(int parent : childToParent[child]) {
				if(visited[parent]) {
					minParent = parent;
					continue;
				}
				visited[parent] = true;
				q.offer(parent);
			}
		}
	}
	
	static void bfsParenttoChild(int in) {
		q = new ArrayDeque<>();
		q.offer(in);
		
		cnt = 0;
		visited = new boolean[V + 1];
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			cnt++;
			for(int child : parentToChild[parent]) {
				if(visited[child]) continue;
				visited[child] = true;
				q.offer(child);
			}
		}
	}
}
