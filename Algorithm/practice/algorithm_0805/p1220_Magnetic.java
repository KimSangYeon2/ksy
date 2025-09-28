package practice.algorithm_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1220_Magnetic {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 10;

		for (int i = 0; i < tc; i++) {

			int count = 0;
			// 배열로 받기
			int size = Integer.parseInt(br.readLine());
			int[][] arr = new int[size][size];
			for (int y = 0; y < arr.length; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < arr[y].length; x++) {
					arr[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			// 탐색 시작, 교착 상태 true면
			for (int y = 0; y < arr.length; y++) {
				for (int x = 0; x < arr[y].length; x++) {
					if (isDeadlock(arr, x, y))
						count++;
				}
			}

			// 결과 출력
			System.out.println("#" + (i + 1) + " " + count);
		}

		br.close();
	}
	
	// arr[][], x, y값 받아옴
	// 초기값은 false
	// arr[y][x] == 1인 경우 y로 한칸씩 내려가면서 탐색
	// 1을 만나지 않은 경우 2를 만나면 true, break
	static boolean isDeadlock(int[][] arr, int x, int y) {
		boolean isDeadlock = false;
		for (int i = 1; i < arr.length - y; i++) {
			if (arr[y + i][x] == 1 && arr[y][x] == 1)
				break;
			if (arr[y + i][x] == 2 && arr[y][x] == 1) {
				isDeadlock = true;
				break;
			}
		}
		return isDeadlock;
	}
}