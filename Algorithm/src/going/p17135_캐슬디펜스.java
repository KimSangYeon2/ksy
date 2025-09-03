package going;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17135_캐슬디펜스 {

	static int N, M, D, max, cnt;
	static int[][] map, newMap;
	static int[][] dir = { {1, 0}, {0, 1}, {0, -1} };//좌상우, 화살 기준 아래는 탐색 x
	static int[] result = new int[3];
	static boolean[][] visited;
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		newMap = new int[N][M];
		for(int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		max = 0;
		archer(0, 0);
		System.out.println(max);
		br.close();
	}
	
	//궁수 배치하는 함수
	static void archer(int in, int depth) {
		if(depth == 3) {
			simul();
			for(int y = 0; y < N; y++) map[y] = newMap[y].clone();
			for(int y = N - 1; y >= 0; y--)
			max = Math.max(max, cnt);
			return;
		}
		for(int i = in; i < M; i++) {
			result[depth] = i;
			archer(i + 1, depth + 1);
		}
	}
	
	static void simul() {//해당 위치에서 화살쏘는 함수
		visited = new boolean[N][M];
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int sy = cur[0]; int sx = cur[1];
			visited[sy][sx] = true;
			for(int i = 0; i < 3; i++) {
				int ny = sy + dir[i][0]; int nx = sx + dir[i][1];
				if(!inRange(ny, nx)) continue; //범위 밖이면 탐색 x
				if(visited[ny][nx]) continue; //방문했으면 탐색 x
				if(map[ny][nx] == 1 && !visited[ny][nx]) { //화살 위치 1이면 죽이기
					visited[ny][nx] = true;
					cnt++;
				}
				queue.offer(new int[] {ny, nx});
			}
			range++;
			if(range == D) break;
		}
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
}
//궁수 3명 배치 -> dfs
//D 이하인 적 중 가장 가까운 적 처치 -> bfs
//dfs 중 3에 도달하면 해당 위치에서 화살들 한칸씩 올리면서 bfs
//끝에 도달하면 max값 갱신