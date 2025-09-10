package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1260_화학물질2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N + 1][N + 1];
			
			for(int y = 1; y <= N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x = 1; x <= N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			sb.append("#").append(t).append(" ").append(0).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}