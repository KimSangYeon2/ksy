package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p10026_적록색약 {

	static int N;
	static char[][] map;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static boolean[][] visited;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int y = 0; y < N; y++) {
			String line = br.readLine();
			for(int x = 0; x < N; x++) {
				map[y][x] = line.charAt(x);
			}
		}
		
		int ans1 = 0;
		visited = new boolean[N][N];
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(visited[y][x]) continue;
				bfs1(y, x);
				ans1++;
			}
		}
		
		int ans2 = 0;
		visited = new boolean[N][N];
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(visited[y][x]) continue;
				bfs2(y, x);
				ans2++;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
	
	//일반
	static void bfs1(int y, int x) {
		q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int sy = cur[0]; int sx = cur[1];
			char curRGB = map[sy][sx];
			for(int i = 0; i < 4; i++) {
				int ny = sy + dy[i]; int nx = sx + dx[i];
				if(!inRange(ny,nx) || visited[ny][nx] || curRGB != map[ny][nx]) continue;
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx});
			}
		}
	}
	
	//적록
	static void bfs2(int y, int x) {
		q = new ArrayDeque<>();
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int sy = cur[0]; int sx = cur[1];
			char curRGB = map[sy][sx];
			for(int i = 0; i < 4; i++) {
				int ny = sy + dy[i]; int nx = sx + dx[i];
				if(!inRange(ny,nx) || visited[ny][nx]) continue;
				if(curRGB == 'R' || curRGB == 'G') {
					if(map[ny][nx] == 'B') continue;
				}
				if(curRGB == 'B') {
					if(map[ny][nx] != curRGB) continue;
				}
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx});
			}
		}
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
