package practice.algorithm_0812;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Solution {
public class 벌꿀채취2115 {

	public static int N, M, C; // 벌통들의 크기 N, 선택할 수 있는 벌통의 개수 M, 꿀을 채취할 수 있는 최대 양 C
	public static int beehiveNN[][] = new int[10][10];
	public static int valuearray[] = new int[100];
	public static int ans;

	public static int cal(int r, int c) {
		int ret = 0;

		for (int i = 1; i < (1 << M); i++) {
			int tsum = 0, ttsum = 0;

			for (int j = 0; j < M; j++) {
				if ((i & (1 << j)) > 0) {
					tsum += beehiveNN[r][c + j];
					ttsum += (beehiveNN[r][c + j] * beehiveNN[r][c + j]);
				}
			}
			if (tsum <= C && ret < ttsum)
				ret = ttsum;
		}
		return ret;
	}

	public static void main(String[] args) throws FileNotFoundException {

		// long start = System.currentTimeMillis();

		// System.setIn(new FileInputStream("벌꿀채취2115input.txt"));
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();

			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					beehiveNN[i][j] = sc.nextInt();

			int v_idx = 0;
			for (int i = 0; i < N; i++) {
				int j;
				for (j = 0; j < N - M + 1; j++)
					valuearray[v_idx++] = cal(i, j);
				for (; j < N; j++)
					valuearray[v_idx++] = 0;
			}

			ans = 0;

			for (int i = 0; i < v_idx - M; i++)
				for (int j = i + M; j < v_idx; j++)
					if (ans < (valuearray[i] + valuearray[j]))
						ans = valuearray[i] + valuearray[j];

			System.out.printf("#%d %d\n", tc, ans);
		}
		// System.out.println(( System.currentTimeMillis() - start )/1000.0 );
		sc.close();
	}
}
