package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p2667_단지번호붙이기 {

	static int[][] field;
	static int N;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		field = new int[N][N];
		for(int y = 0; y < N; y++) {
			char[] a = br.readLine().toCharArray();
			for(int x = 0; x < N; x++) {
				field[y][x] = a[x] - '0';
			}
		}
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				if(field[y][x] == 1) nums.add(dfs(y, x));
			}
		}
		
		Collections.sort(nums);
		
		System.out.println(nums.size());
		for(int i = 0; i < nums.size(); i++)
			System.out.println(nums.get(i));
		
		br.close();
	}
	
	static int dfs(int y, int x) {
		field[y][x] = 0;
		int count = 1;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(isEnd(ny, nx) || field[ny][nx] == 0) continue;
			count += dfs(ny, nx);
		}
		return count;
	}
	
	static boolean isEnd(int y, int x) {
		return y < 0 || y >= N || x < 0 || x >= N;
	}
}
