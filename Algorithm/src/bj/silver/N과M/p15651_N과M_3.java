package bj.silver.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15651_N과M_3 {

	static int N, M;
	static int[] nums;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		result = new int[M];
		for(int i = 0; i < N; i++) nums[i] = i + 1;
		subset(0);
		System.out.println(sb);
	}
	
	//NM3 중복순열
	static void subset(int depth) {
		if(depth == M) {
			for(int i = 0; i < M; i++)
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			result[depth] = nums[i]; //해당 깊이 result에 nums값 하나 입력
			subset(depth + 1);//깊이 추가해도 다른 제약x -> nums하나 추가
		}
	}
}
