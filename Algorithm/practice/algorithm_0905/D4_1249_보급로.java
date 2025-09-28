package practice.algorithm_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class D4_1249_보급로 {

	static int N, ans;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0};
	static int[] dx = { 0, 1, 0, -1};
	static PriorityQueue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int y = 0; y < N; y++) {
				String line = br.readLine();
				for(int x = 0; x < N; x++)
					map[y][x] = line.charAt(x) - '0';
			}
			
			ans = 0;
			dijkstra();
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
	}
	
	static void dijkstra() {
		q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]); //시간 순 오름차순 정렬
		q.offer(new int[] {0, 0, 0}); //y, x, time 순서 / 시작점 offer
		int[][] minTime = new int[N][N];
		for(int y = 0; y < N; y++)
			for(int x = 0; x < N; x++)
				minTime[y][x] = Integer.MAX_VALUE;
		minTime[0][0] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int sy = cur[0]; int sx = cur[1];
			int ctime = cur[2];
			
			//끝에 도달했으면
			if(sy == N - 1 && sx == N - 1) {
				ans = ctime;
				return;
			}
			
			//가지치기
			if(ctime > minTime[sy][sx]) continue;//기존 최소시간보다 크면 skip
			
			for(int i = 0; i < 4; i++) {
				int ny = sy + dy[i]; int nx = sx + dx[i]; //방문여부 필요 x, 더 큰 값만 찾아 갱신
				if(!( ny >= 0 && ny < N && nx >= 0 && nx < N)) continue; //범위밖이면 탐색 x
				int ntime = ctime + map[ny][nx];
				if(ntime < minTime[ny][nx]) {
					minTime[ny][nx] = ntime;
					q.offer(new int[] {ny, nx, ntime});
				}
			}
		}
	}
}

//다익스트라
//