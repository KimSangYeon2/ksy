package algorithm_0806;

import java.util.ArrayList;

public class practice_DFS_NodebyNode {
	static ArrayList<Integer>[] nodeList;
	static int[] visited;
	
	public static void main(String[] args) {
		int N = 5;
		int[][] nodes = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
		
		//리스트 배여 초기화
		nodeList = new ArrayList[N];
		for(int i = 0; i < N; i++) nodeList[i] = new ArrayList<>();
		visited = new int[N];
				
		//입력받은 간선을 간선 리스트에 저장
		//무방향성 양쪽을 저장
		for(int[] e : nodes){
			nodeList[e[0]].add(e[1]);
			nodeList[e[1]].add(e[0]);
		}
		
		visited[0] = 1; //0에서 출발, 0은 방문처리
		dfs(0);
	}
	
	static void dfs(int cur) {
		System.out.print(cur + " ");
		for(int next : nodeList[cur]) {//연결된 nodelist들에 대해서
			if(visited[next] == 0) {//방문하지 않았으면
				visited[next] = 1;//방문처리
				dfs(next);//해당 point부터 재귀
			}
		}
	}
}
