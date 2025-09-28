package bj.silver.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15650_N과M_2 {

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
	
	//NM2 조합
	static void subset(int start, int depth) {
		// 완성 후 출력
		if (depth == M) {
			for (int i = 0; i < M; i++)
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}
		//depth 하나씩 늘려가면서 start 지점부터 끝 중 숫자 하나 선택
		//해당 숫자의 index는 i, i 뒤에서부터 부분집합 탐색
		for (int i = start; i < N; i++) {
			result[depth] = nums[i];//현재 depth를 index값으로 하는 곳에 nums[i] 입력
			subset(i + 1, depth + 1);//
		}
	}
}