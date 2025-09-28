package practice.algorithm_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1861_정사각형_방 {
	
	static int[][] room;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			
			n = Integer.parseInt(br.readLine());
			room = new int[n][n];
			
			for (int y = 0; y < n; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < n; x++) {
					room[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int start = 0;
			int maxCnt = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					int cnt = dfs(y, x);
					if(cnt > maxCnt) {
						maxCnt = cnt;
						start = room[y][x];
					} else if(cnt == maxCnt && room[y][x] < start) {//경로 길이 같고 방번호 작으면 갱신
						start = room[y][x];
					}
				}
			}
			
			System.out.println("#" + i + " " + start + " " + maxCnt);
		}
		br.close();
	}
	
	static int dfs(int y, int x) {
		int maxCnt = 1;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!isEnd(ny,nx) && room[ny][nx] - room[y][x] == 1) {//이동하려는 곳이 벽이 아니고 차이 1일 때
				int cnt = 1 + dfs(ny, nx);
				if(cnt > maxCnt) maxCnt = cnt; //최대경로 탐색
			}
		}
		return maxCnt;
	}
	
	static boolean isEnd(int y, int x) {
		if (x < 0 || x >= n || y < 0 || y >= n) return true;
		return false;
	}

}
