package bj.silver.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p15664_N과M_10 {

	static int N, M;
	static int[] nums, result;
	static boolean[] isUsed;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		nums = new int[N];
		result = new int[M];
		isUsed = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(nums);
		subset(0, 0);
		System.out.println(sb);
		br.close();
	}

	static void subset(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++)
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		int check = 0;
		for (int i = start; i < N; i++) {
			if(nums[i] == check) continue;
			result[depth] = nums[i];
			check = nums[i];
			subset(i + 1, depth + 1);
		}
	}
}
