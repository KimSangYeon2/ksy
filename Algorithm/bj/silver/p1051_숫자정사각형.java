package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1051_숫자정사각형 {

	static int[][] rec;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		rec = new int[N][M];
		
		for(int y = 0; y < N; y++) {
			String line = br.readLine();
			for(int x = 0; x < M; x++) {
				rec[y][x] = line.toCharArray()[x];
			}
		}
		
		int max_size = 0;
		if(N > M) max_size = M; else max_size = N;//정사각형 최대 사이즈
		
		int max = 0;
		
		for(int i = 0; i <= max_size; i++) { //index값은 좌표값이 아닌 data 위치값임을 명심!!
			int nmax = aSize(i, N, M);
			if(nmax > max)
				max = nmax;
		}
		
		System.out.println(max);
	}
	
	static int aSize(int a, int N, int M) {
		for(int y = 0; y < N - a; y++) {
			for(int x = 0; x < M - a; x++) {
				if(checkSide(y, x, a))
					return (a + 1)*(a + 1);
			}
		}
		return -1;
	}
	
	static boolean checkSide(int y, int x, int a) {
		return rec[y][x] == rec[y + a][x]
				&& rec[y + a][x] == rec[y][x + a]
						&& rec[y][x + a] == rec[y + a][x + a];
	}
}
