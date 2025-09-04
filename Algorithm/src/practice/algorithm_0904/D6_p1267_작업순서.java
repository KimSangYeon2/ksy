package practice.algorithm_0904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D6_p1267_작업순서 {
	
	static int V, E;
	static boolean[] isDone;
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
			
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken()); //역방향으로 탐색
				fromto[from].add(to);
			}
			
			isDone = new boolean[V + 1];
			for(int v = 1; v <= V; v++)
				if(!isDone[v]) dfs(v);
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
		long afterTime = System.currentTimeMillis(); 
		System.out.println("시간차이(ms) : "+ (afterTime - beforeTime));
	}
	
	static void dfs(int in) {
		isDone[in] = true;
		for(int v : fromto[in]) {
			if(isDone[v]) continue;
			dfs(v);
		}
		sb.append(in).append(" ");
	}
}