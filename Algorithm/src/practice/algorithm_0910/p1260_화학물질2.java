package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1260_화학물질2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N + 2][N + 2];
			
			for(int y = 1; y <= N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 1; x <= N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<int[]> matrix = new ArrayList<>();
			for(int y = 1; y <= N; y++) {
				for(int x = 1; x <= N; x++) {
					if(map[y][x] == 0) continue;
					if(!(map[y - 1][x] == 0 && map[y][x - 1] == 0)) continue;//배열 시작점 찾기
					int row = 0; int col = 0;
					while(map[y + row][x] != 0) row++;
					while(map[y][x + col] != 0) col++;
					matrix.add(new int[] {row, col});
				}
			}
			
			int L = matrix.size();
			int[][] dp = new int[L][L];
			for(int )
			
			sb.append("#").append(t).append(" ").append(0).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}