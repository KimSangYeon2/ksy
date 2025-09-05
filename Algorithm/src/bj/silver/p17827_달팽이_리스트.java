package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17827_달팽이_리스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[] snail = new int[N + 1];
		 st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++) snail[n] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			long K = Long.parseLong(br.readLine());
			if(K < V) {
				sb.append(snail[(int) K + 1]).append("\n");
			}
			else {
				long A = (K - (V - 1)) % (N - V + 1);
				sb.append(snail[(int) (A + V)]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
