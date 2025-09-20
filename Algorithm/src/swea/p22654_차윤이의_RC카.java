package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p22654_차윤이의_RC카 {
	
	static int sy, sx, N;
	static char[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t);
			
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for(int y = 0; y < N; y++) {
				String line = br.readLine();
				for(int x = 0; x < N; x++) {
					map[y][x] = line.charAt(x);
					if(map[y][x] == 'X') {
						sy = y; sx = x;
					}
				}
			}
			
			int Q = Integer.parseInt(br.readLine());
			for(int q = 0; q < Q; q++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				char[] command = st.nextToken().toCharArray();
				sb.append(" ").append(Command(command));
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int Command(char[] in) {
		int y = sy; int x = sx; int dir = 0;
		for(int i = 0; i < in.length; i++) {
			char c = in[i];
			if(c == 'R') dir = (dir + 1) % 4;
			if(c == 'L') dir = (dir + 3) % 4;
			if(c == 'A') {
				int ny = y + dy[dir]; int nx = x + dx[dir];
				if(!inRange(ny, nx)) continue;
				if(map[ny][nx] == 'T') continue;
				y = ny; x = nx;
			}
		}
		if(map[y][x] == 'Y') return 1;
		else return 0;
	}
	
	static boolean inRange(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < N;
	}
}
