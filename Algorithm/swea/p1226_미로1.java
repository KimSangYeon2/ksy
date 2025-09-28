package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1226_미로1 {
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int ey, ex, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			map = new int[16][16];
			int sy = 0; int sx = 0;
			for(int y = 0; y < 16; y++) {
				String line = br.readLine();
				for(int x = 0; x < 16; x++) {
					map[y][x] = line.charAt(x) - '0';
					if(map[y][x] == 2) {
						sy = y; sx = x;
					}
					if(map[y][x] == 3) {
						ey = y; ex = x;
					}
				}
			}
			
			ans = 0;
			visited = new boolean[16][16];
			visited[sy][sx] = true;
			dfs(sy, sx);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void dfs(int y, int x) {
		if(y == ey && x == ex) {
			ans = 1;
			return;
		}
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i]; int nx = x + dx[i];
			if(map[ny][nx] == 1) continue;
			if(visited[ny][nx]) continue;
			visited[ny][nx] = true;
			dfs(ny, nx);
		}
	}
}
