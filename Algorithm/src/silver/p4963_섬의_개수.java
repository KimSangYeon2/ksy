package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4963_섬의_개수 {
	
	static boolean[][] visitable;
	static int w, h; //너비, 높이 x, y
	
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null) { //입력이 있는 동안, br.readline은 입력이 없으면 null값 return
			StringTokenizer st = new StringTokenizer(line);
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(h == 0 || w == 0) break;
			
			visitable = new boolean[h][w];
			for(int y = 0; y < h; y++) { //방문 가능 field 만들기
				StringTokenizer stF = new StringTokenizer(br.readLine());
				int[] X = new int[w];
				for(int x = 0; x < w; x++) {
					X[x] = Integer.parseInt(stF.nextToken());
					if(X[x] == 1) visitable[y][x] = true;
				}
			}
			
			int count = 0;
			for(int y = 0; y < h; y++) {
				for(int x = 0; x < w; x++) {
					if(visitable[y][x] == true) {
						dfs(y, x);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		br.close();
	}
	
	static void dfs(int y, int x) {
		visitable[y][x] = false; //방문하면 false 처리
		for(int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!isEnd(ny, nx) && visitable[ny][nx]) { //탐색하는 곳이 영역 밖이 아니고 방문가능한 곳이면
				dfs(ny, nx);
			}
		}
	}
	
	static boolean isEnd(int y, int x) {
		if (y < 0 || y >= h || x < 0 || x >= w) return true;
		return false;
	}
}
