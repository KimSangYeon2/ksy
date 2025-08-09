package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14469_소가_길을_건너간_이유_3 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] cow = new int[n][2]; // 도착시간 0, 검문시간 1
		int time = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cow[i][0] = Integer.parseInt(st.nextToken());
			cow[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 도착시간 순 버블정렬
		for (int i = 0; i < n-1; i++){//0 ~ n-1까지 뒤에 있는 수랑 비교
			for (int j = 0; j < n - i - 1; j++) {//뒤에서 부터 하나씩 고정, 범위--
				if(cow[j][0] > cow[j + 1][0]) {//큰 수 뒤로 정렬
					int cow_at = cow[j][0];
					int cow_ct = cow[j][1];
					cow[j][0] = cow[j + 1][0];
					cow[j][1] = cow[j + 1][1];
					cow[j + 1][0] = cow_at;
					cow[j + 1][1] = cow_ct;
				}
			}
		}
		
		// 시간 계산
		for (int i = 0; i < n; i++) {
			int at = cow[i][0];
			int ct = cow[i][1];
			if (time < at) { //도착시간보다 빨리 들어가면 갱신
				time = at;
			}
			time += ct; //아니면 검문시간 추가
		}
		
		System.out.println(time);
	}
}
