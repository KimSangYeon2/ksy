package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2447_별찍기10 {
	
	static char[][] stars;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stars = new char[N][N];
		
		star(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				sb.append(stars[y][x]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	
	static void star(int y, int x, int n) {
		if(n == 1) return;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; i++) sb.append(0);
		sb.append("\n");
		sb.append(false);
	}
}
