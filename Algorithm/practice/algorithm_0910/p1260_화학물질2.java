package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
			
			HashMap<Integer, Integer> mapMatrix = new HashMap<>();
			HashSet<Integer> setRow = new HashSet<>();
			HashSet<Integer> setCol = new HashSet<>();
			for(int y = 1; y <= N; y++) {
				for(int x = 1; x <= N; x++) {
					if(map[y][x] == 0) continue;
					if(!(map[y - 1][x] == 0 && map[y][x - 1] == 0)) continue;//배열 시작점 찾기
					int row = 0; int col = 0;
					while(map[y + row][x] != 0) row++;
					while(map[y][x + col] != 0) col++;
					mapMatrix.put(row, col);
					setRow.add(row);
					setCol.add(col);
				}
			}
			
			//시작행렬찾아서 곱셈 순서 맞추기
			int start = 0;
			for(int r : setRow)
				if(!setCol.contains(r)) start = r;
			
			ArrayList<int[]> matrix = new ArrayList<>();
			while(!mapMatrix.isEmpty()) {
				int end = mapMatrix.remove(start);
				matrix.add(new int[] {start, end});
				start = end;
			}
			
			int L = matrix.size();
			int[] nums = new int[L + 1];
			for(int i = 0; i < L; i++) nums[i] = matrix.get(i)[0];
			nums[L] = matrix.get(L - 1)[1];
			
			int[][] dp = new int[L + 1][L + 1];
			for(int l = 1; l < L; l++) {
				for(int s = 1; s <= L - l; s++) {
					int e = s + l;
					dp[s][e] = Integer.MAX_VALUE;
					for(int k = s; k < e; k++) {
						dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k + 1][e] + nums[s - 1] * nums[k] * nums[e]);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[1][L]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}