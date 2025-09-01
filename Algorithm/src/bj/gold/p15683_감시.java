package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p15683_감시 {

	static int N, M, min;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0};
	static int[] dx = { 0, 1, 0, -1 };
	static ArrayList<int[]> camera;
	static int[][][] cctvDir = { {},
		    { {0}, {1}, {2}, {3} },
		    { {0, 2}, {1, 3} },
		    { {0, 1}, {1, 2}, {2, 3}, {3, 0} },
		    { {0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1} },
		    { {0, 1, 2, 3} }};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		camera = new ArrayList<int[]>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] > 0 && map[y][x] < 6) camera.add(new int[] { y, x });
			}
		}

		min = Integer.MAX_VALUE;
		searchblind(0);
		System.out.println(min);
		br.close();
	}

	static void searchblind(int cnt) { // dfs 식으로
		if(cnt == camera.size()) {
			int blind = 0;
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if(map[y][x] == 0) blind++;
			min = Math.min(min, blind);
			return;
		}
		int y = camera.get(cnt)[0]; int x = camera.get(cnt)[1];
		for(int[] direction : cctvDir[map[y][x]] ) {
			for (int d : direction) watch(y, x, d, true);
			searchblind(cnt + 1);
			for (int d : direction) watch(y, x, d, false);
		}
	}

	static void watch(int y, int x, int d, boolean st) {// 0 상 1 하 2 좌 3 우 //st면 감시 아니면 무르기
		while (true) {
			y += dy[d]; x += dx[d];
			if (!inRange(y, x) || map[y][x] == 6) break; // 범위 밖이거나 벽이면 stop
			if (map[y][x] > 0) continue; // 카메라면 무시
			if (st) map[y][x]--;
			else map[y][x]++;
		}
	}

	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
//