package algorithm_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영대회_결승전_4193 {
	
	static int[][] field;
	static int[][] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int n = 0; n < tc; n++) {
			N = Integer.parseInt(br.readLine());
			
			field = new int[N][N];
			visited = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				
			}
		}
		br.close();
	}
	
	static int bfs(int sy, int sx, int ey, int ex) {
		int cnt = 0;
		return cnt;
	}
	
	static boolean isEnd(int y, int x) {
		
		return false;
	}
}
