package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12712_파리퇴치3 {

	static int N, M, max;
	static int[][] fly;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[] cdy = { -1, 1, 1, -1 };
	static int[] cdx = { 1, 1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			fly = new int[N][N];

			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					fly[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#").append(t).append(" ").append(flyCount()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static int flyCount() {
		int max = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				max = Math.max(max, Math.max(cross(y, x), diag(y, x)));
			}
		}
		return max;
	}

	static int cross(int y, int x) {// 십자
		int f = fly[y][x];
		for(int i = 0; i < 4; i++) {
			for(int m = 1; m < M; m++) {
				int ny = y + m * dy[i];
				int nx = x + m * dx[i];
				if(!inRange(ny, nx)) break;
				f += fly[ny][nx];
			}
		}
		return f;
	}

	static int diag(int y, int x) {//
		int f = fly[y][x];
		for(int i = 0; i < 4; i++) {
			for(int m = 1; m < M; m++) {
				int ny = y + m * cdy[i];
				int nx = x + m * cdx[i];
				if(!inRange(ny, nx)) break;
				f += fly[ny][nx];
			}
		}
		return f;
	}

	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
