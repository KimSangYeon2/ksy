package practice.algorithm_0806;

import java.util.ArrayList;
import java.util.Scanner;

public class practice_03 {


	// 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[9];
	
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	// 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void main(String[] args) {
		dfs(1);
	}
	
	static void dfs(int nodeIndex) {
		// 방문 처리
		vistied[nodeIndex] = true;
		
		// 방문 노드 출력
		System.out.print(nodeIndex + " -> ");
		
		// 방문한 노드에 인접한 노드 찾기
		for (int node : graph[nodeIndex]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}
}

//int[][]
//알파벳 빠른 순으로 탐색, visited 0 ~ 7 모두 false, 알파벳 순 탐색
//정점 a 방문
// -> v[0] t, 방문하지 않은 정점 v[?] = f 있으면 정점 w있으면 v를 스택에 push
//방문하지 않은 정점 v[?] = f 없으면 스택을 pop, 마지막 방문 정점 v로 이동
// -> 부터 다시 반복
