package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1949_등산로_조정 {

	static int N, K, maxh, maxL, new_maxL;
	static int[][] field, new_field;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static StringBuilder sb;
	static ArrayList<int[]> peak;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			field = new int[N][N];
			peak = new ArrayList<int[]>();
			maxh = 0;
			for(int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					field[y][x] = Integer.parseInt(st.nextToken());
					if(field[y][x] > maxh) maxh = field[y][x];
				}
			}
			
			for(int y = 0; y < N; y++)
				for(int x = 0; x < N; x++)
					if(field[y][x] == maxh) peak.add(new int[] {y, x});
			
			newRoad();
			sb.append(maxL).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void newRoad() {
		maxL = 0;
		//한 칸 선택해서 k만큼 파고 bfs 실시
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				for(int k = 0; k <= K; k++) {
					field[y][x] -= k;
					for(int[] p : peak) dfs(p[0], p[1], 1);
					field[y][x] += k;
				}
			}
		}
	}
	
	static void dfs(int y, int x, int l) {
		maxL = Math.max(maxL, l);
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i]; int nx = x + dx[i];
			if(!inRange(ny, nx) || field[ny][nx] >= field[y][x]) continue;
			dfs(ny, nx, l + 1);
		}
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
