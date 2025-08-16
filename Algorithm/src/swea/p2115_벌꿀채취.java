package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2115_벌꿀채취 {

	static int N, M, C, max_h1, max_h2;
	static int w1y, w1x, w2y, w2x; //일꾼 시작점 좌표
	static int[] w1, w2;
	static int[][] field;
	static boolean[] isUsed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			field = new int[N][N];
			isUsed = new boolean[N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++)
					field[y][x] = Integer.parseInt(st.nextToken());
			}
			w1 = new int[M];
			w2 = new int[M];
			max_h1 = 0;
			max_h2 = 0;
			dfs();
			sb.append(max_h1 + max_h2).append("\n");
		}
		br.close();
	}


	// 일꾼 순열 ??
	static void dfs(int w1, int w2, int d) {// 전체 COLUMN중 2개 선택, 그 줄 w1이 위치할 경우 visit가능한 칸이 M보다 적으면 선택x
		
		for (int y = 0; y < N; y++) {
			for (int x = d; x < N - d; x++) {
				w2[d] = field[y][x];
			}
		}
	}

	// 벌꿀 채취 최댓값, 부분집합으로,in는 채취 선택한 위치, h는 선택한 벌꿀 수
	static void dfsW1(int in, int h, int p) {
		if (h > C)
			return; // 채취한 꿀 수 초과하면 return
		int total_h = h + w1[in];
//		if (total_h > C) return; // 추가로 채취한 꿀 수 더해서 초과하면 return
		int new_p = p + w1[in] * w1[in]; // 최대 가격 갱신
		if (new_p > max_h1)
			max_h1 = new_p;
		for (int i = in; i < w1.length - 1; i++) {
			dfsW1(i + 1, total_h, new_p);
		}
	}

	static void dfsW2(int in, int h, int p) {
		if (h > C)
			return;
		int total_h = h + w2[in];
		int new_p = p + w2[in] * w2[in];
		if (new_p > max_h2)
			max_h2 = new_p;
		for (int i = in; i < w2.length - 1; i++) {
			dfsW1(i + 1, total_h, new_p);
		}
	}
	
	static boolean inRange(int x) {
		return x >= 0 || x < N;
	}
}
// 최대한 많은 수익 > 최대값 가지치기
// 2명의 일꾼, 벌통수 M, 가로로 M개 선택 후 채취
// 일꾼 겹치는 상황 없음 -> isUsed로 가지치기, 조합
// 채취한 꿀의 양은 최대 C, 하나의 벌통애서 채취한 꿀은 하나의 통에만

// 일꾼 당 dfs 조합 실시 후 최대 벌꿀 양 갱신
// 여러개 합쳐서 합보다 낮거나 같은 경우 제곱