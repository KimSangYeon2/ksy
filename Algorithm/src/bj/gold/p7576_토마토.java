package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576_토마토 {
	
	static int[][] tomato;
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());//field 크기 입력
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		for(int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < M; x++) {
				tomato[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() { // day를 어느 위치에 추가해야하는지????
		int day = 0;
		int[][] tday = new int[N][M]; //각 지점 tomato익는 최솟값
		queue = new LinkedList<int[]>();
		
		for(int y = 0; y < N; y++)
			for(int x = 0; x < M; x++)
				if(tomato[y][x] == 1) queue.offer(new int[] {y, x});//1인 지점 모두 시작점으로
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int sy = cur[0]; int sx = cur[1];
			for(int i = 0; i < 4; i++) {
				int ny = sy + dy[i]; int nx = sx + dx[i];
				if(!inRange(ny, nx)) continue;//범위 밖이면 탐색x
				if(tomato[ny][nx] != 0) continue;//토마토 칸 -1이거나 1일 경우 탐색 x
				queue.offer(new int[] {ny, nx});
				tday[ny][nx] = tday[sy][sx] + 1;//각 칸마다 날짜 기록, 한칸 이동하면 day + 1
				if(tday[ny][nx] > day) day = tday[ny][nx];//익지 않은 곳 익으면 날짜 갱신
				tomato[ny][nx] = 1;//익음처리
			}
		}
		
		for(int y = 0; y < N; y++)
			for(int x = 0; x < M; x++)
				if(tomato[y][x] == 0) return -1;//0인 지점 남으면 -1 return
				
		return day;
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M; 
	}
}
//토마토 다 익는 최소일수 구하기