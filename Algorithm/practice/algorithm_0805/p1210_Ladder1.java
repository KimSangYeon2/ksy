package practice.algorithm_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1210_Ladder1 {
	
	
	static int startX, leftY;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 10;
		int size = 100;
		
		for (int i = 0; i < tc; i++) {
			
			int[][] data = new int[size][size];
			br.readLine();
			for (int y = 0; y < data.length; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < data[y].length; x++) {
					data[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			leftY = data.length - 1;
			int goalX = 0;
			
			//목표 x좌표 탐색
			for (int x = 0; x < data.length; x++)
				if (data[data.length - 1][x] == 2)
					goalX = x;
			startX = goalX;
			
			//끝까지 올라가기 전까지 길찾기 수행
			while(leftY != 0) {
				search(data);
			}
			
			System.out.println("#" + (i+1) + " " + startX);
		}
		
		br.close();
	}
	
	static void search(int[][] data) {
		
	    // 왼쪽으로 이동
	    if (startX - 1 >= 0 && data[leftY][startX - 1] == 1) {
	        while (startX - 1 >= 0 && data[leftY][startX - 1] == 1) {
	            startX--;
	        }
	    }
	    
	    // 오른쪽으로 이동
	    else if (startX + 1 < 100 && data[leftY][startX + 1] == 1) {
	        while (startX + 1 < 100 && data[leftY][startX + 1] == 1) {
	            startX++;
	        }
	    }

	    // 위로 이동
	    leftY--;
	}
	
}