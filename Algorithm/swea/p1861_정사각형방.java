package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1861_정사각형방 {
	
	static int N, step;
	static int[][] field;
	static StringBuilder sb;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					field[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			//최대 거리, 최소 숫자 시작점 갱신하기
			int spCntMax = 0;
			int spMin = Integer.MAX_VALUE;
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					step = 1;
					dfs(y, x);
					if(step < spCntMax) continue;
					if(step > spCntMax) {
						spCntMax = step;
						spMin = field[y][x];//시작점 step 최대인 경우로 갱신
					} else if (step == spCntMax)
						spMin = Math.min(spMin, field[y][x]);//같으면 시작점 최솟값인 경우로 갱신
				}
			}
			
			sb.append(spMin).append(" ").append(spCntMax).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int y, int x) {
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!inRange(ny, nx)) continue; //범위 내 아니면 x
			if(field[ny][nx] != field[y][x] + 1) continue; //차이 1 아니면 x 
			step++;
			dfs(ny, nx);
			break; //1곳 이동했으면 탐색 그만
		}
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
