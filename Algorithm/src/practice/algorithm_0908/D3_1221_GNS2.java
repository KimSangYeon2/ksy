package practice.algorithm_0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1221_GNS2 {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		String[] code = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append("\n");
			int N = Integer.parseInt(st.nextToken());
			
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) nums[n] = Arrays.asList(code).indexOf(st.nextToken());
			
			Arrays.sort(nums);
			for(int n = 0; n < N; n++) sb.append(code[nums[n]]).append(" ");
				
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
	}
}