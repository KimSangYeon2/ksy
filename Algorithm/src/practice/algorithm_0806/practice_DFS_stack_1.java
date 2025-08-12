package practice.algorithm_0806;

import java.util.ArrayList;
import java.util.Stack;

public class practice_DFS_stack_1 {
	static boolean[] visited = new boolean[9];
	static int[][] graph = {{}, {2, 3, 8}, {1, 6, 8}, {1, 5}, {5, 7}, {3, 4, 7}, {2}, {4, 5}, {1, 2}};
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//시작 노드
		stack.push(1);
		//시작노드 방문 처리
		visited[1] = true;
		// 스택이 비어있지 않으면
		while(!stack.isEmpty()) {
			//스택에서 하나씩 꺼내면서 해당 nodeIndex 출력
			int nodeIndex = stack.pop();
			System.out.print(nodeIndex + " ");
			arr.add(nodeIndex);
			//꺼낸 노드와인접한 노드 찾기
			for (int linkedNode : graph[nodeIndex]) {//이동 가능한 node찾기
				//인접한 노드 방문하지 않은 경우
				if(!visited[linkedNode]) {
					//스택에 넣고 방문처리
					stack.push(linkedNode);
					visited[linkedNode] = true;
				}
			}
		}
		System.out.print(arr);
	}

}
