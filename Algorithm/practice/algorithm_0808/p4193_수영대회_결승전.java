package practice.algorithm_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4193_수영대회_결승전 {

	static int[][] field;
	static boolean[][] visitable;
	static int[][] atime;
	static int time;
	static int N, sy, sx, ey, ex;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int n = 1; n <= tc; n++) {
			N = Integer.parseInt(br.readLine());

			field = new int[N][N];

			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++)
					field[y][x] = Integer.parseInt(st.nextToken());
			}
			
			atime = new int[N][N];
			time = Integer.MAX_VALUE;
			for(int[] row : atime) Arrays.fill(row, Integer.MAX_VALUE);

			StringTokenizer st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			
			dfs(sy, sx, 0);
			if(time == Integer.MAX_VALUE) time = -1;
			System.out.println("#" + n + " " + time);
		}
		br.close();
	}
	
	static void dfs(int y, int x, int t) {
		if(y == ey && x == ex) { //도착시 최단시간 갱신
			time = Math.min(time, t);
			return;
		}
		if(t >= time) return; //최단시간보다 길면 중단
		if(t >= atime[y][x]) return; // 현재 시점 기준 최단시간보다 길면 중단
		
		atime[y][x] = t; //현재 시점 최단시간 갱신
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			int dt = 0;
			
			if(isEnd(ny, nx) || field[ny][nx] == 1) continue;
			//회오리인 경우 3초마다 열림, 그 전까지 대기이므로 열리기 전까지 남은시간 추가
			if(field[ny][nx] == 2) dt = (3 - t % 3);
			else dt = 1; //아니면 시간 1초 증가
			dfs(ny, nx, t + dt);
		}
	}
	
	static boolean isEnd(int y, int x) {
		return y < 0 || y >= N || x < 0 || x >= N;
	}
}
