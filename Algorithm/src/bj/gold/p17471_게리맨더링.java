package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17471_게리맨더링 {

	static int N, minP, total;
	static int[] population;
	static boolean[] visited;
	static boolean[] isUsed;
	static ArrayList<Integer>[] fromto;
	static Queue<Integer> queue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//인구수 배열에 추가
		population = new int[N + 1];
		total = 0;
		for(int n = 1; n <= N; n++) {
			population[n] = Integer.parseInt(st.nextToken());
			total += population[n];
		}
		
		//인접 node 정보 추가
		fromto = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++) fromto[n] = new ArrayList<Integer>();
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			for(int k = 0; k < K; k++) {
				fromto[n].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//사용여부, 방문여부 배열 생성
		isUsed = new boolean[N + 1];
		minP = Integer.MAX_VALUE;
		dfs(1);
		if(minP == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(minP);
	}

	//부분집합 구하기, 구역 2개면 인구수 차 구하기
	static void dfs(int n) {
		if(n > N) {
			visited = new boolean[N + 1];
			if(!areaCheck()) return;
			int popul = 0;
			for(int i = 1; i <= N; i++)
				if(isUsed[i]) popul += population[i];
			minP = Math.min(minP, Math.abs(total - 2 * popul));
			//방문여부 초기화
			return;
		}
		//선택
		isUsed[n] = true;
		dfs(n + 1);
		
		//선택x
		isUsed[n] = false;
		dfs(n + 1);
	}
	
	//탐색으로 영역 확인
	static void bfs(int in) {
		queue = new ArrayDeque<Integer>();
		queue.offer(in);
		visited[in] = true;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int x : fromto[cur]) {
				if(visited[x]) continue;
				if(isUsed[x] != isUsed[cur]) continue;
				visited[x] = true;
				queue.offer(x);
			}
		}
	}
	
	//영역 2개인지 확인
	static boolean areaCheck() {
		int cntA = 0;
		int cntB = 0;
		
		//A영역
		for(int i = 1; i <= N; i++){
			if(visited[i]) continue; //방문했으면 탐색x
			if(!isUsed[i]) continue;
			bfs(i);
			cntA++;
		}
		if(cntA != 1)return false;
		
		//B영역
		for(int i = 1; i <= N; i++){
			if(visited[i]) continue; //방문했으면 탐색x
			if(isUsed[i]) continue;
			bfs(i);
			cntB++;
		}
		if(cntB != 1)return false;
		
		return true;
	}
}
