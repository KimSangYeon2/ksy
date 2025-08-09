package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012_유기농_배추 {
	
	
	static boolean[][] visitable; //지렁이 방문여부 확인
	static int M, N;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			visitable = new boolean[N][M];
			
			for(int n = 0; n < K; n++) {
				StringTokenizer xy = new StringTokenizer(br.readLine());
				int cabX = Integer.parseInt(xy.nextToken());
				int cabY = Integer.parseInt(xy.nextToken());
				visitable[cabY][cabX] = true;//방문가능 처리
			}
			
			int count = 0;
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < M; x++) {
					if(visitable[y][x]) { //탐색가능구역마다 전부 탐색하고 count + 1
						bfs(y, x);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		br.close();
	}
	
	static void bfs(int y, int x) { // bfs 탐색
		visitable[y][x] = false; //이미 방문 했으니깐
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!isEnd(ny, nx) && visitable[ny][nx]) {
				visitable[ny][nx] = false; //방문 완료
				bfs(ny, nx);
			}
		}
	}
	
	static boolean isEnd (int y, int x) {
		if(y < 0 || y >= N || x < 0 || x >= M) return true;
		return false;
	}
}
