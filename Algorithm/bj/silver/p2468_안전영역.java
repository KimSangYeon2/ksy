package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2468_안전영역 {

	static int[][] field;
	static int[][] visited; // 0 방문가능 1 방문함 2 방문불가(잠김)
	static int N;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		field = new int[N][N];
		
		for(int y = 0; y < N; y++) { //필드에 높이 등록
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0; x < N; x++) {
				field[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i = 0; i <= 100; i++) { //비 확인, 잠긴 높이 따라 방문가능여부 다시 확인
			int nMax = rain(i);
			if(nMax > max) max = nMax;
		}
		
		System.out.println(max);
		br.close();
	}

	static int rain(int i) {
		visited = new int[N][N];
		int count = 0; //영역의 수
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(i >= field[y][x]) visited[y][x] = 2; //잠긴 경우 방문 불가
			}
		}
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(visited[y][x] == 0) { //방문 가능하면 완전탐색 시작
					dfs(y, x);
					count++;
				}
			}
		}
		return count;
	}
	
	static void dfs(int y, int x) { //영역 탐색
		visited[y][x] = 1;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!isEnd(ny, nx) && visited[ny][nx] == 0) {
				dfs(ny, nx);
			}
		}
	}

	static boolean isEnd(int y, int x) {
		if (y < 0 || y >= N || x < 0 || x >= N)
			return true;
		return false;
	}
}
