package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1248_공통조상 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			//트리 생성
			ArrayList<Integer>[] tree = new ArrayList[V + 1];
			for(int v = 1; v <= V; v++) tree[v] = new ArrayList<>();
			
			//트리에 data 추가
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				tree[parent].add(child);
			}
			
			//탐색
			boolean[] visited = new boolean[V + 1];
			
			
			//서브트리수 확인
			int cnt = 0;
			for(int v = 1; v <= V; v++)
				if(visited[v]) cnt++;
			
			sb.append("#").append(t).append(" ").append(0).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
