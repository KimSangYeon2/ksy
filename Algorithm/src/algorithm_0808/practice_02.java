package algorithm_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice_02 {

	static boolean[][] visitable;
	static int[][] minDist;
	static int N;
	static int answer;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static Queue<int[]> queue;
	
	static class Node {
		int y, x, t;
		Node(int y, int x, int t){
			this.y = y; this.x = x; this.t = t;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		visitable = new boolean[N][N];
		boolean[][] nVisitable = new boolean[N][N];
		
		for(int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0; x < N; x++) {
				if(Integer.parseInt(st.nextToken()) == 0)
					nVisitable[y][x] = true;
			}
		}
		
		minDist = new int[N][N];
		for(int[] row : minDist) Arrays.fill(row, Integer.MAX_VALUE);
		
		for(int y = 0; y < N; y++)
			for(int x = 0; x < N; x++)
				visitable[y][x] = nVisitable[y][x];
		answer = Integer.MAX_VALUE;
		bfs(0, 0, 0);
		System.out.println("BFS 최단 거리 : " + answer);
		
		for(int y = 0; y < N; y++)
			for(int x = 0; x < N; x++)
				visitable[y][x] = nVisitable[y][x];
		visitable = nVisitable;
		answer = Integer.MAX_VALUE;
		dfs(0, 0, 0);
		System.out.println("DFS 최단 거리 : " + answer);
		
		br.close();
	}
	
	static void bfs(int y, int x, int t) {
		queue = new LinkedList<>();
		queue.offer(new int[] {y, x, t});
		visitable[y][x] = false;
		
		while(!queue.isEmpty()){//queue에 data가 있는동안
			int[] cur = queue.poll(); //queue에서 data 제거
			int cy = cur[0], cx = cur[1], ct = cur[2];
			if(cy == N - 1 && cx == N - 1){ //도착지점 시간 갱신
				answer = Math.min(answer, ct);
				return;
			}
			if(ct >= answer) return;
			if(ct >= minDist[cy][cx]) return;
			for(int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(!inRange(ny, nx) || !visitable[ny][nx]) continue; //조건 아니면 끝
				visitable[ny][nx] = false; //방문처리
				queue.offer(new int[] {ny, nx, ct + 1}); //queue에 data 추가
			}
		}
	}
	
	static void dfs(int y, int x, int t) {
		if(y == N - 1 && x == N - 1){ //도착지점 시간 갱신
			answer = Math.min(answer, t);
			return;
		}
		
		if(t >= answer) return; //최적보다 길면 중단
		if(t >= minDist[y][x]) return; //현재 지점 최단보다 길면 중단
		minDist[y][x] = t; //현재 지점 최단 갱신
			
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!inRange(ny, nx) || !visitable[ny][nx]) continue; //방문 불가면 skip
			visitable[ny][nx] = false;
			dfs(ny, nx, t + 1);
			visitable[ny][nx] = true; // 백트래킹
		}
	}
	
	static boolean inRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}
