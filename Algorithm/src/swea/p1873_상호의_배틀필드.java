package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1873_상호의_배틀필드 {

	static int H, W, ty, tx, C, dir;
	static char tank;
	static char[] command;
	static char[][] field;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			field = new char[H][W];

			// 필드 생성 및 탱크 찾기
			for (int y = 0; y < H; y++) {
				String in = br.readLine();
				for (int x = 0; x < W; x++) {
					field[y][x] = in.charAt(x);
					if (field[y][x] == '<' || field[y][x] == '>' || field[y][x] == '^' || field[y][x] == 'v') {
						ty = y;
						tx = x;
						tank = field[y][x];
					}
				}
			}

			C = Integer.parseInt(br.readLine());
			command = br.readLine().toCharArray();

			for (char in : command)
				control(in);
			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++)
					sb.append(field[y][x]);
				sb.append('\n');
			}
		}
		System.out.println(sb);
		br.close();
	}

	static void control(char in) {
		switch (in) {
		case 'U':
			move(0);
			break;
		case 'D':
			move(1);
			break;
		case 'L':
			move(2);
			break;
		case 'R':
			move(3);
			break;
		case 'S':
			shoot();
			break;
		default:
			break;
		}
	}

	static void move(int in) {// 움직이기
		int ny = ty + dy[in];
		int nx = tx + dx[in];
		switch (in) {// 이동 못해도 방향은 변경
		case 0:
			tank = '^';
			break;
		case 1:
			tank = 'v';
			break;
		case 2:
			tank = '<';
			break;
		case 3:
			tank = '>';
			break;
		}
		if (inRange(ny, nx) && field[ny][nx] == '.') {// 이동가능한 경우
			field[ty][tx] = '.';//이동 전 위치 평지화
			ty = ny;
			tx = nx;
			field[ny][nx] = tank;//이동한 위치 탱크 
		} else
			field[ty][tx] = tank;//이동 못했어도 탱크 상태 변경
	}

	static void shoot() {// 탱크 방향으로 쏘기
		int y = ty;
		int x = tx;
		int dir = 0;
		switch (tank) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		while (inRange(y, x)) {// 범위 내에 있는 동안
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			y = ny; x = nx;
			if (!inRange(ny, nx)) break;
			if (field[ny][nx] == '*') {
				y = ny; x = nx; 
				field[ny][nx] = '.';
				break;
			}
			if (field[ny][nx] == '#') {
				y = ny; x = nx; 
				break;
			}
		}
	}

	static boolean inRange(int y, int x) {
		return y >= 0 && y < H && x >= 0 && x < W;
	}
}
