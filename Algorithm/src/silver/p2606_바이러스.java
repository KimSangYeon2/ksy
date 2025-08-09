package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2606_바이러스 {

	static boolean[] visited;
	static ArrayList<Integer>[] link;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int fromTo = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		link = new ArrayList[N + 1];
		for(int i = 1; i < N + 1; i++) {
			link[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < fromTo; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			link[c1].add(c2);
			link[c2].add(c1);
		}
		System.out.println(dfs(1) - 1);  //자기 자신 제외
	}
	
	static int dfs(int in){
		if (in <= 0) return -1;
		visited[in] = true;
		int count = 1;
		for(int next : link[in]) {
			if(!visited[next]) {  //방문 x인 경우
				count += dfs(next);
			}
		}
		return count;
	}
}
