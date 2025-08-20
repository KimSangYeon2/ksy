package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14502_연구소 {
	
	static int N, M, max;
	static int[][] field, newField;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new int[N][M];
		
		for(int y = 0; y < N; y++ ) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < M; x++)
				field[y][x] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		dfs(0);
		System.out.println(max);
		br.close();
	}
	
	static void dfs(int depth) {
		if(depth == 3) {
			bfs();
			int new_max = 0;
			for(int Y = 0; Y < N; Y++ )
				for(int X = 0; X < M; X++)
					if(newField[Y][X] == 0) new_max++;
			max = Math.max(new_max, max);
			return;
		}
		for(int y = 0; y < N; y++ ) {
			for(int x = 0; x < M; x++) {
				if(field[y][x] == 0) {
					field[y][x] = 1;
					dfs(depth + 1);
					field[y][x] = 0;
				}
			}
		}
	}
	
	static void bfs() {
		queue = new LinkedList<int[]>();
		newField = new int[N][M];
		
		for(int Y = 0; Y < N; Y++ )
			for(int X = 0; X < M; X++)
				newField[Y][X] = field[Y][X];
		
		for(int Y = 0; Y < N; Y++ )
			for(int X = 0; X < M; X++)
				if(newField[Y][X] == 2) queue.offer(new int[] {Y, X});
		
		while(!queue.isEmpty()) {//queue 비워지지 않았으면
			int[] cur = queue.poll();
			int sy = cur[0]; int sx = cur[1];
			for(int i = 0; i < 4; i++) {
				int ny = sy + dy[i]; int nx = sx + dx[i];
				if(!inRange(ny, nx) || newField[ny][nx] != 0) continue;
				queue.offer(new int[] {ny, nx});
				newField[ny][nx] = 2;
			}
		}
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
