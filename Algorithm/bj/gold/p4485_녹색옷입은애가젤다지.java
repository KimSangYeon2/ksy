package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4485_녹색옷입은애가젤다지 {

	static int N, ans;
	static int[][] cave;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static PriorityQueue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		String line;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			cave = new int[N][N];
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++)
					cave[y][x] = Integer.parseInt(st.nextToken());
			}
			
			dijkstra();
			sb.append("Problem ").append(++tc).append(": ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void dijkstra() {
		queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);//거리순 나열
		int[][] dist = new int[N][N];
		for(int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[0][0] = cave[0][0];
		queue.offer(new int[] { 0, 0, cave[0][0] });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int sy = cur[0]; int sx = cur[1];
			int cost = cur[2];
			
			if (sy == N - 1 && sx == N - 1) {//도착하면 끝
				ans = cost;
				return;
			}
			
			if(cost > dist[sy][sx]) continue; //기존 비용이 각 경로 비용보다 비싸면 탐색 x
			
			for (int i = 0; i < 4; i++) {
                int ny = sy + dy[i];
                int nx = sx + dx[i];
                if (!inRange(ny, nx)) continue;
                int newCost = cost + cave[ny][nx];
                if (newCost < dist[ny][nx]) {
                    dist[ny][nx] = newCost;
                    queue.offer(new int[]{ny, nx, newCost});
                }
            }
		}
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
