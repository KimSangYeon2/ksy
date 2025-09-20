package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class p22683_나무베기 {

	static int N, K, sy, sx, ey, ex, ans;
	static char[][] map;
	static boolean[][][][] visited;
	static Queue<State> q;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new char[N][N];
			for (int y = 0; y < N; y++) {
				String line = br.readLine();
				for (int x = 0; x < N; x++) {
					map[y][x] = line.charAt(x);
					if (map[y][x] == 'X') {
						sy = y;
						sx = x;
					}
				}
			}

			bfs();
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void bfs() {
		q = new ArrayDeque<>();
		q.offer(new State(sy, sx, 0, K, 0));

		visited = new boolean[N][N][4][K + 1];
		visited[sy][sx][0][K] = true;

		while (!q.isEmpty()) {
			State cur = q.poll();
			int sy = cur.y;
			int sx = cur.x;
			int cdir = cur.dir;
			int ck = cur.k;
			int curCnt = cur.cnt;

			if (map[sy][sx] == 'Y') {
				ans = curCnt;
				return;
			}

			for (int d = 0; d < 4; d++) {

				// 방향 안바꾸는 경우
				if (d == cdir) {
					int ny = sy + dy[d];
					int nx = sx + dx[d];
					if (inRange(ny, nx)) {
						// 나무 있으면
						if (map[ny][nx] == 'T') {
							if (ck > 0) {
								if (!visited[ny][nx][cdir][ck - 1]) {
									visited[ny][nx][cdir][ck - 1] = true;
									q.offer(new State(ny, nx, cdir, ck - 1, curCnt + 1));
								}
							}
						}

						// 나무 없으면
						else {
							if (!visited[ny][nx][cdir][ck]) {
								visited[ny][nx][cdir][ck] = true;
								q.offer(new State(ny, nx, cdir, ck, curCnt + 1));
							}
						}
					}
				}

				// 방향 바꾸는 경우
				// 좌회전, 우회전
				if (d == (cdir + 1) % 4 || d == (cdir + 3) % 4) {
					if (!visited[sy][sx][d][ck]) {
						visited[sy][sx][d][ck] = true;
						q.offer(new State(sy, sx, d, ck, curCnt + 1));
					}
				}
			}
		}

		ans = -1;
		return;
	}

	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}

	static class State {
		int y, x, dir, k, cnt;

		State(int y, int x, int dir, int k, int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.k = k;
			this.cnt = cnt;
		}
	}
}
