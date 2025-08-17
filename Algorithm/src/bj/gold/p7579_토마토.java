package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7579_토마토 {

	static int[][][] tomato;
	static int M, N, H;
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<int[]> Queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		
		// tomato 입력
		for (int z = 0; z < H; z++)
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++)
					tomato[z][y][x] = Integer.parseInt(st.nextToken());
			}

		System.out.println(bfs());
		br.close();
	}

	static int bfs() {
		int day = 0;
		int[][][] tday = new int[H][N][M];
		Queue = new LinkedList<int[]>();

		for (int z = 0; z < H; z++)
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if (tomato[z][y][x] == 1)
						Queue.offer(new int[] { z, y, x });

		while (!Queue.isEmpty()) {//Queue 빌 때 까지
			int[] cur = Queue.poll();//poll한 좌표값 현재지점 좌표 지정
			int sz = cur[0]; int sy = cur[1]; int sx = cur[2];
			for (int i = 0; i < 6; i++) {
				int nz = sz + dz[i]; int ny = sy + dy[i]; int nx = sx + dx[i];//1칸씩 탐색
				if(!inRange(nz, ny, nx)) continue; //범위밖이면 탐색 x
				if(tomato[nz][ny][nx] != 0) continue; //이미 익은 토마토나 심어지지않은곳 탐색 x
				Queue.offer(new int[] {nz, ny, nx}); //새로운 탐색 지점 Queue에 offer
				tday[nz][ny][nx] = tday[sz][sy][sx] + 1; //시작 지점부터 1칸 탐색마다 1일씩 추가
				if(tday[nz][ny][nx] > day) day = tday[nz][ny][nx]; //가장 오래걸린 칸 날짜로
				tomato[nz][ny][nx] = 1;
			}
		}
		
		for (int z = 0; z < H; z++)
			for (int y = 0; y < N; y++)
				for (int x = 0; x < M; x++)
					if (tomato[z][y][x] == 0)
						day = -1;
		
		return day;
	}

	static boolean inRange(int z, int y, int x) {
		return z >= 0 && z < H && y >= 0 && y < N && x >= 0 && x < M;
	}
}
