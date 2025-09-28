package bj.silver.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p15649_N과M_1 {

	static int N, M;
	static int[] nums;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		nums = new int[N + 1];
		visited = new boolean[N];
		result = new int[M];
		for(int i = 0; i < N; i++) nums[i] = i + 1;
		subset(0);
	}
	
	//NM1 순열
	static void subset(int depth) {
		//완성 후 출력
		if(depth == M) {
			for(int i = 0; i < M; i++) 
				System.out.print(result[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {//i번째 방문 안했으면
				visited[i] = true; //방문처리
				result[depth] = nums[i]; //대상 배열의 i번 index값 가져오기
				subset(depth + 1);
				visited[i] = false; //다음 순열 뽑기 위해 방문처리 제거
			}
		}
	}
}
