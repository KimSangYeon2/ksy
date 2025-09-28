package bj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p9466_텀프로젝트 {

	static int N, cnt;
	static int[] students;
	static boolean[] isGroup, visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			
			students = new int[N + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 1; n <= N; n++) 
				students[n] = Integer.parseInt(st.nextToken());
			
			isGroup = new boolean[N + 1];
			visited = new boolean[N + 1];
			
			cnt = 0;
			for(int n = 1; n <= N; n++) {
				if(isGroup[n]) continue;
				dfs(n);
			}
			
			
			bw.write(N - cnt + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void dfs(int n) {
		if(isGroup[n]) return;
		if(visited[n]) {
			isGroup[n] = true;
			cnt++;
		}
		visited[n] = true;
		dfs(students[n]);
		isGroup[n] = true;
	}
}
