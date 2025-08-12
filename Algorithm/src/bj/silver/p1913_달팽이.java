package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1913_달팽이 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		int[][] snail = new int[N][N];

		int dir = 0; // 0위 1오 2아래 3왼
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };

		int x = N / 2;
		int y = N / 2;
		int move = 1;
		
		int num = 1;
		snail[y][x] = num++;
		
		while (num <= N * N) {
			for (int i = 0; i < 2; i++) { //2번씩 끊어서 같은 칸 이동
				for (int j = 0; j < move; j++) {
					x += dx[dir];
					y += dy[dir];
					if (!(x < 0 || x > N - 1 || y < 0 || y > N - 1)) // 범위 내라면
						snail[y][x] = num++;
				}
				dir = (dir + 1) % 4; //move 후 방향전환
			}
			move++; //move 한칸씩 증가
		}
		
		int tx = 0;
		int ty = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (snail[i][j] == t) {
					tx = i + 1;
					ty = j + 1;
					break;
				}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(snail[i][j] + " ");
			System.out.println();
		}
		System.out.print(tx + " " + ty);
		br.close();
	}
	
}
