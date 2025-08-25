package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2382_미생물격리 {

	static int N, M, K;// N은 map사이즈, M은 시간, K는 군집수
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };
	static ArrayList<int[]>[][] micro, nMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			micro = new ArrayList[N][N];
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					micro[y][x] = new ArrayList<int[]>();

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int mC = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()); // 1 ~ 5중 하나 상, 하, 좌, 우 순서
				micro[y][x].add(new int[] { mC, dir }); // 좌표 따른 미생물 수, 방향 추가
			}

			// 미생물 이동 로직
			for (int m = 0; m < M; m++) move();

			int count = 0;
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					if(!micro[y][x].isEmpty())
						count += micro[y][x].get(0)[0];

			sb.append(count).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	// 1초마다 칸마다 움직이는 로직
	static void move() {
		nMap = new ArrayList[N][N];
		for (int y = 0; y < N; y++)
			for (int x = 0; x < N; x++)
				nMap[y][x] = new ArrayList<int[]>();
				
		//이동
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				for(int[] mic : micro[y][x]) {
					int count = mic[0];
					int dir = mic[1];
					int ny = y + dy[dir]; int nx = x + dx[dir];
					if(isEdge(ny, nx)) {
						count /= 2;
						dir = changeDir(dir);
					}
					if(count == 0) continue;
					nMap[ny][nx].add(new int[] {count, dir});
				}
			}
		}
		
		//합체
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				comb(y, x);
			}
		}
		
		micro = nMap;
	}

	// 미생물 여러개면 합치는 로직
	static void comb(int y, int x) {
		if(nMap[y][x].size() > 1) {
			int maxCount = 0;
			int nCount = 0;
			int nDir = 0;
			for(int[] mic : nMap[y][x]) {
				int Count = mic[0];
				nCount += Count;
				maxCount = Math.max(maxCount, Count);
			}
			for(int[] mic : nMap[y][x]) {
				if(mic[0] == maxCount) nDir = mic[1];
			}
			nMap[y][x].clear();
			nMap[y][x].add(new int[] {nCount, nDir});
		}
	}

	// 방향 바꾸는 로직
	static int changeDir(int dir) {
		switch (dir) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		default:
			return 0;
		}
	}

	static boolean isEdge(int y, int x) {
		return y == 0 || y == N - 1 || x == 0 || x == N - 1;
	}
}

//1시간마다 다음 셀로 이동