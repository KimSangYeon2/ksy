import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2206_벽부시고이동하기 {

	static int[][] map;
	static int N, M;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static class Path {
		int y, x, isBreak;
		public Path(int y, int x, int isBreak) { //1이면 부신 상태
			this.y = y;
			this.x = x;
			this.isBreak = isBreak;
		}
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int n = 0; n < N; n++) {
			String line = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = line.charAt(m) - '0';
			}
		}
	}
	
	static void dijkstra() {
		Queue<Path> q = new ArrayDeque<>(); 
		q.offer(new Path(0, 0, 0));
		
		int[][][] dist = new int[N][M][2];
		dist[0][0][0] = 1;
		
		
		while(!q.isEmpty()) {
			Path cur = q.poll();
			int cy = cur.y; int cx = cur.x; 
			int isBreak = cur.isBreak;
			
			for(int i = 0; i < 4; i++){
				int ny = cy + dy[i]; int nx = cx + dx[i];
				
				if(!inRange(ny, nx)) continue;
				
				if(map[ny][nx] == 0 && dist[ny][nx][isBreak] == 0) {
					dist[ny][nx][isBreak] = dist[cy][cx][isBreak] + 1;
					q.offer(new Path(ny, nx, isBreak));
				}
				
				if(map[ny][nx] == 1 && isBreak == 0 && dist[ny][nx][1] == 0) {
					dist[ny][nx][1] = dist[cy][cx][isBreak] + 1;
					q.offer(new Path(ny, nx, 1));
				}
			}
		}
		
		int ans0 = dist[N - 1][M - 1][0];
		int ans1 = dist[N - 1][M - 1][1];
		int ans = 0;
		if(ans0 == 0 && ans1 == 0) ans = -1;
		else {
			ans = Math.min(ans0, ans1);
			if(ans0 == 0) ans = ans1;
			else if(ans1 == 0) ans = ans0;
		}
		
		System.out.println(ans);
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
	
	public static void main(String[] args) throws IOException {
		init();
		dijkstra();
	}

}
