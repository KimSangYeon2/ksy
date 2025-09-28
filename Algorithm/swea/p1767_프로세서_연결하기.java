package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1767_프로세서_연결하기 {

	static int N, line, min_l, max_prc;
	static int[][] field;
	static ArrayList<int[]> prc;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			prc = new ArrayList<int[]>();
			line = 0;

			int prc_cnt = 0;
			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					field[y][x] = Integer.parseInt(st.nextToken());
					if (field[y][x] == 1) {
						if (onPower(y, x))
							prc_cnt++;// 이미 충전한 코어 cnt
						else
							prc.add(new int[] { y, x });// 나머지는 list에 추가
					}
				}
			}

			max_prc = prc_cnt;// 최대 연결 개수
			min_l = Integer.MAX_VALUE;// 최소 선 개수
			dfs(0, prc_cnt, 0);
			if (min_l == Integer.MAX_VALUE)
				min_l = 0; // 모든 코어가 이미 충전이거나 코어가 없어서 갱신 x인 경우
			sb.append(min_l).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void dfs(int in, int core, int l) {
		// 연결 core + 남은 core가 최대 core보다 적으면
		if (core + prc.size() - in < max_prc)
			return; // 기존 최대 연결 가능 코어수보다 적으면 return
		if (core + prc.size() - in == max_prc && l >= min_l)
			return;// 선 연결 수 같거나 많으면 return

		// 남은 코어 dfs, in은 연결할 코어 번호, core는 연결한 코어 수
		if (in == prc.size()) {// 탐색 끝나면
			if (core > max_prc) {
				max_prc = core;
				min_l = l;
			} else if (core == max_prc && l < min_l) {
				min_l = l;
			}
			return;
		}

		// 연결 하는 경우
		int y = prc.get(in)[0];
		int x = prc.get(in)[1];
		for (int i = 0; i < 4; i++) {
			int li = lineCount(y, x, i);
			if (li == -1)
				continue;
			line(y, x, i, li, 2);
			dfs(in + 1, core + 1, l + li);
			line(y, x, i, li, 0);
		}

		// 연결 안하는 경우
		dfs(in + 1, core, l);
	}

	static void line(int y, int x, int dir, int l, int status) {// 선 개수만큼 설치,제거 status 2 설치 0 제거
		int ny = y;
		int nx = x;
		for (int i = 0; i < l; i++) {
			ny += dy[dir]; // 진행
			nx += dx[dir];
			field[ny][nx] = status;
		}
	}

	static int lineCount(int y, int x, int dir) {// 설치가능한 선 개수 확인
		int l = 0;
		int ny = y + dy[dir];
		int nx = x + dx[dir];
		while (!inRange(ny, nx)) {// !onPower로 할 경우 가장자리 선 설치 안함.
			if (field[ny][nx] != 0)
				return -1; // 설치 불가
			ny += dy[dir]; // 진행
			nx += dx[dir];
			l++;
		}
		return l;
	}

	static boolean inRange(int y, int x) {
		return y < 0 || y > N - 1 || x < 0 || x > N - 1;
	}

	static boolean onPower(int y, int x) {
		return y == 0 || y == N - 1 || x == 0 || x == N - 1;
	}
}