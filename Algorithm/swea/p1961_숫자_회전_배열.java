package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1961_숫자_회전_배열 {

	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] arr_90 = new int[N][N];
			arr_90 = rotate_90(arr);
			
			int[][] arr_180 = new int[N][N];
			arr_180 = rotate_90(arr_90);
			
			int[][] arr_270 = new int[N][N];
			arr_270 = rotate_90(arr_180);
			
			sb.append("#").append(t).append("\n");
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) sb.append(arr_90[y][x]);
				sb.append(" ");
				for(int x = 0; x < N; x++) sb.append(arr_180[y][x]);
				sb.append(" ");
				for(int x = 0; x < N; x++) sb.append(arr_270[y][x]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
	
	//90도 돌리기
	static int[][] rotate_90(int[][] in) {
		int[][] arr = new int[N][N];
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				arr[y][x] = in[N - 1 - x][y];
			}
		}
		return arr;
	}
	
}
