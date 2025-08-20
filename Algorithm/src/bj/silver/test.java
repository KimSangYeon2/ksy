package bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

	static int N, M, K, min;
	static StringBuilder sb;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			dfs(1, 1, 1, 1); //1번 맞추고 시작
			sb.append(min).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void dfs(int next, int total, int count, int score) {
		if (next > N) return;
		if (total == M) {
			min = Math.min(min, score);
			return;
		}
		// 맞출 경우
		//count k면
		if (count + 1 == K) {
		    dfs(next + 1, total + 1, 0, (score + 1) * 2);
		} else {
		    dfs(next + 1, total + 1, count + 1, score + 1);
		}
		dfs(next + 1, total, 0, score);
	}
}
//3
//8 7 3
//3 3 3
//5 2 3