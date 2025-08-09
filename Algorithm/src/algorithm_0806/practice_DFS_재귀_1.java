package algorithm_0806;

import java.util.ArrayList;
import java.util.Scanner;

public class practice_DFS_재귀_1 {
	static boolean[] visited = new boolean[9];
	static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
	static ArrayList<Integer> point = new ArrayList<>(); //모든 경로 저장하기
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		dfs(sc.nextInt());
		System.out.println();
		System.out.println(point.getLast());
	}
	
	static void dfs(int nodeIndex) {
		visited[nodeIndex] = true; //방문한 nodeIndex true 처리
		point.add(nodeIndex);
		System.out.print(nodeIndex + " ");
		for (int node : graph[nodeIndex]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
}
