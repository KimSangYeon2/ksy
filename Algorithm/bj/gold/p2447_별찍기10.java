package bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class p2447_별찍기10 {
	static char[][] arr;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
 
		arr = new char[N][N];
        
		star(0, 0, N, false);
 
		for (int i = 0; i < N; i++) {
			bw.write(arr[i]);
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
 
	static void star(int y, int x, int N, boolean isBlank) {
		if(isBlank) { //빈칸일 경우
			for(int i = y; i < y + N; i++) {
				for(int j = x; j < x + N; j++) {
					arr[y][x] = ' ';
				}
			}
			return;
		}
		if(N == 1) {
			arr[y][x] = '*';
			return;
		}
		int cnt = 0;
		for(int i = y; i < y + N; i += N / 3) {
			for(int j = x; j < x + N; j += N / 3) {
				cnt++;
				if(cnt == 5) star(i, j, N / 3, true);
				else star(i, j, N / 3, false);
			}
		}
	}
}