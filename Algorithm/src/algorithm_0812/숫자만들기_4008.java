package algorithm_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 숫자만들기_4008 {

	static int N;
	static int[] op; // + , - , * , / 순서로 개수만큼 담기
	static int[] oper; // 연산자 배열로 나열한 것
	static int[] nums; // 숫자배열

	static int calculate() {
		int ans = nums[0];
		int next = 0;
		while(next != N - 1) {
			switch(oper[next]) {
			case 0 : ans += nums[++next]; break;
			case 1 : ans -= nums[++next]; break;
			case 2 : ans *= nums[++next]; break;
			case 3 : ans /= nums[++next]; break;
			}
		}
		return ans;
	}

	static void opset(int depth) {
		
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		// 시간측정
		long startTime = System.nanoTime();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; tc++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			nums = new int[N];

			// 배열에 숫자와 연산자 담기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N - 1; n++)
				op[n] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++)
				nums[n] = Integer.parseInt(st.nextToken());

			System.out.println();
			System.out.printf("#%d %d", t, 0);
		}
		br.close();

		// 시간측정
		long endTime = System.nanoTime();
		long time = endTime - startTime;
		System.out.println("걸린 시간 : " + time);
	}
}
