package bj.silver;

import java.util.Scanner;

public class p2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] isBlack = new boolean[101][101];
		int n = sc.nextInt();
		int size = 0;
		
		for(int i = 0; i < n; i++) {
			int xb = sc.nextInt();
			int yb = sc.nextInt();
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++)
					isBlack[yb + j][xb + k] = true;
			}
		}
		
		for(int y = 0; y < 101; y++) {
			for(int x = 0; x < 101; x++) {
				if(isBlack[y][x] == true) size++;
			}
		}
		
		System.out.println(size);
	}
}
