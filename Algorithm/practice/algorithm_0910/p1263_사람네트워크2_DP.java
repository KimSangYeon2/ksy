package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1263_사람네트워크2_DP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[][] D = new int[N + 1][N + 1];
				
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(i == j) D[i][j] = 0;
					else if(n == 1) D[i][j] = 1;
					else D[i][j] = Integer.MAX_VALUE;
				}
			
			for(int k = 1; k <= N; k++)
				for(int i = 1; i <= N; i++)
					for(int j = 1; j <= N; j++) {
						if (D[i][k] == Integer.MAX_VALUE || D[k][j] == Integer.MAX_VALUE) continue;
						D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
					}
			
			int ans = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++) {
				int newAns = 0;
				for(int j = 1; j <= N; j++) {
					newAns += D[i][j];
				}
				ans = Math.min(ans, newAns);
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
