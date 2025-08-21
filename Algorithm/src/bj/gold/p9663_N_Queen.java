package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9663_N_Queen {

	static int N, Case;
	static int[][] board;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		Case = 0;
		dfs(0);
		System.out.println(Case);
		br.close();
	}
	
	//열마다 queen 1개씩 배치
	static void dfs(int y) {
		if (y == N) {
			Case++;
			return;
		}
		for (int x = 0; x < N; x++) {
			if (board[y][x] == 0) {
				board[y][x] = 1;    //퀸 배치
				setBoard(y, x, 1);  //공격 가능
				dfs(y + 1);
				setBoard(y, x, 0);  //공격 취소
				board[y][x] = 0;    //퀸 무르기
			}
		}
	}

	// 공격 가능 경로 세팅, q가 1이면 공격 가능, 0이면 무르기
	static void setBoard(int y, int x, int q) {
		for (int i = 0; i < 8; i++) {
			for (int n = 1; n < N; n++) {
				int ny = y + n * dy[i];
				int nx = x + n * dx[i];
				if (inRange(ny, nx)) {
					if (q == 1)
						board[ny][nx]++;
					else
						board[ny][nx]--;
				}
			}
		}
	}

	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
// 1면 queen, 2면 queen의 경로 (놓을 수 없음)
// 