package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p4008_숫자만들기 {

	static int N, max, min;
	static int[] op; // + , - , * , / 순서로 개수만큼 담기
	static int[] oper; // 연산자 배열로 나열한 것
	static int[] nums; // 숫자배열

	static int calculate() { //연산자 값 계산
		// oper[i]인 경우 ans와 nums[i+1] 두 값을 계산
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
		if(depth == N - 1) {
			int result = calculate();//연산자 배치 끝나면 결과 계산하기
			max = Math.max(result, max); //최대최소 갱신
			min = Math.min(result, min);
			return;
		}
		for(int i = 0; i < 4; i++) {//연산자 배치하기
			if(op[i] > 0) {
				op[i]--;
				oper[depth] = i;
				opset(depth + 1);
				op[i]++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			oper = new int[N - 1];
			nums = new int[N];

			// 배열에 연산자 담기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < 4; n++)
				op[n] = Integer.parseInt(st.nextToken());
			// 배열에 숫자 담기
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++)
				nums[n] = Integer.parseInt(st.nextToken());
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			opset(0);
			
			sb.append("#").append(t).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
		br.close();
//		long end = System.currentTimeMillis();
//		System.out.println("걸린 시간(ms): " + (end - start));
	}
}
