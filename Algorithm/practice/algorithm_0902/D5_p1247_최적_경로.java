package practice.algorithm_0902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class D5_p1247_최적_경로 {
	
	static int N, min;
	static int[][] dist;
	static int[] path;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			
			N = Integer.parseInt(br.readLine());
			dist = new int[N + 2][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < N + 2; n++) {//0, 1은 회사, 집 좌표
				dist[n][0] = Integer.parseInt(st.nextToken()); //x 좌표
				dist[n][1] = Integer.parseInt(st.nextToken()); //y 좌표
			}
			
			min = Integer.MAX_VALUE;
			visited = new boolean[N + 2];
			path = new int[N + 2];
			path[0] = 0; path[N + 1] = 1; //경로 처음과 마지막은 회사, 집 
			dfs(1, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int depth, int d) {
		if(d >= min) return; //기존 최소 거리보다 길면 탐색 x
		if(depth > N) {
			int tohome = distance(dist[path[N]], dist[1]);
			min = Math.min(min, d + tohome);
			return;
		}
		for(int i = 2; i < N + 2; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			path[depth] = i;
			dfs(depth + 1, d + distance(dist[path[depth]], dist[path[depth - 1]]));
			visited[i] = false;
		}
	}
	
	static int distance(int[] xy1, int[] xy2) { // 두 점 사이 거리 출력
		return Math.abs(xy1[0] - xy2[0]) + Math.abs(xy1[1] - xy2[1]);
	}
}

//고객 2 ~ 10 명의 좌표
//회사에서 출발 모두 방문 후 집 도착
//각 좌표 사이 최단거리 -> 무조건 |x1-x2| + |y1-y2|
//회사 -> 고객 -> 집 순으로 나열한 후 최단 