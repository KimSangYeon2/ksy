package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11501_주식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) nums[n] = Integer.parseInt(st.nextToken());
			
			long ans = 0;
			int max = 0;
			for(int n = N - 1; n >= 0; n--) {
				if(nums[n] > max) max = nums[n];
				ans += max - nums[n];
			}
			
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
