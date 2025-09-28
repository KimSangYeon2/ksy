package bj.silver.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15652_N과M_4 {

	static int N, M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N + 1];
		result = new int[M];
		for(int i = 0; i < N; i++) nums[i] = i + 1;
		subset(0, 0);
	}
	
	//NM4 중복조합, stringbuilder로 시간 줄일 필요 있음
	static void subset(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			result[depth] = nums[i];
			subset(i, depth + 1);//i만 현재 i를 계속 탐색하도록 해주면 됨
		}
	}
}