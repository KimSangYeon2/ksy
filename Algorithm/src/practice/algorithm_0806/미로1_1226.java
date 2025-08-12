package practice.algorithm_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 미로1_1226 {

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int size = 16;
	static char[][] maze;
	static int[][] visited;//0방문x, 1방문, 2벽 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int tc = 0; tc < 10; tc++) {
			
			maze = new char[size][size];
			visited = new int[size][size];
			
			String tcN = br.readLine();
			for(int y = 0; y < size; y++) {
				char[] in = br.readLine().toCharArray();
				for(int x = 0; x < size; x++) {
					maze[y][x] = in[x];
					if(maze[y][x] == '1') visited[y][x] = 2; 
				}
			}
			
			int sx = 0; int sy = 0; //출발점
			int ex = 0; int ey = 0; //도착점
			for(int y = 0; y < size; y++) {
				for(int x = 0; x < size; x++) {
					if(maze[y][x] == '2') {
						sx = x; sy = y;
					}
					if(maze[y][x] == '3'){
						ex = x; ey = y;
					}
				}
			}
			
			dfs(sx, sy);
			if(visited[ey][ex] == 1) System.out.println("#" + tcN + " 1");
			else System.out.println("#" + tcN + " 0");
		}
	}
	
	static void dfs(int x, int y) { //재귀 dfs
		visited[y][x] = 1;//방문처리
		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if(visited[nY][nX] == 0 && !isWall(nX, nY)) { //벽이 아니고 방문 안한 장소면
				dfs(nX, nY); //새로운 좌표에서 탐색 시작
			}
		}
	}
	
	static boolean isWall(int x, int y) {
		if(x < 0 || x > size - 1 || y < 0 || y > size - 1) return true;
		return false;
	}
}
