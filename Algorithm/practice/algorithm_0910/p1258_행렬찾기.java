package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1258_행렬찾기 {

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
			
			PriorityQueue<Matrix> matrix = new PriorityQueue<>();
			for(int y = 1; y <= N; y++) {
				for(int x = 1; x <= N; x++) {
					if(map[y][x] == 0) continue;
					if(!(map[y - 1][x] == 0 && map[y][x - 1] == 0)) continue;//배열 시작점 찾기
					int row = 0; int col = 0;
					while(map[y + row][x] != 0) row++;
					while(map[y][x + col] != 0) col++;
					matrix.offer(new Matrix(row, col));
				}
			}
			
			sb.append("#").append(t).append(" ").append(matrix.size()).append(" ");
			
			while(!matrix.isEmpty()) {
				Matrix m = matrix.poll();
				sb.append(m.row).append(" ").append(m.col).append(" ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static class Matrix implements Comparable<Matrix>{
		int row, col, size;
		
		public Matrix(int m, int n) {
			this.row = m;
			this.col = n;
			this.size = m * n;
		}
		
		@Override
		public int compareTo(Matrix o) {
			int n = this.size - o.size;
			if(n == 0) return this.row - o.row;
			else return n;
		}
	}
}