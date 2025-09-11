package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p7511_소셜_네트워킹_어플리케이션 {
	
	static int N, K, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			sb.append("Scenario ").append(t).append(":\n");
			
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			
			
			for(int k = 1; k <= K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
			}
			
			
			M = Integer.parseInt(br.readLine());
			for(int m = 1; m <= M; m++) {
				
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static class Path {
		int from, to;
		public Path(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}
