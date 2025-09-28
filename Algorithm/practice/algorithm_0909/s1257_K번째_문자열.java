package practice.algorithm_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s1257_K번째_문자열 {

	public static void main(String[] args) throws IOException {
		long startMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			long K = Long.parseLong(br.readLine());
			String str = br.readLine();

			// SA
			int L = str.length();
			Integer[] SA = new Integer[L];
			for (int i = 0; i < L; i++)
				SA[i] = i;

			// SA 사전순 정렬
			Arrays.sort(SA, (o1, o2) -> str.substring(o1).compareTo(str.substring(o2)));

			// test SA
			System.out.println("Suffix Array:");
			for (int i = 0; i < L; i++)
				System.out.printf("%d: %s\n", SA[i], str.substring(SA[i]));

			// LCP
			int LCP[] = new int[L];
			for (int i = 1; i < L; i++) {
				int min = Math.min(L - SA[i], L - SA[i - 1]); //두 문자열 중 더 짧은 길이 기준
				for(int n = 0; n < min; n++) { //이전 문자열과 같으면 ++ 아니면 다음 index로
					if(str.charAt(SA[i - 1] + LCP[i]) != str.charAt(SA[i] + LCP[i])) break;
					LCP[i]++;
				}
			}

			// test LCP
			System.out.println("LCP:");
			for (int i = 0; i < L; i++)
				System.out.printf("%d: %s\n", LCP[i], str.substring(SA[i]));

			String ans = "none";
			for (int i = 0; i < L; i++) {
				int len = L - SA[i];
				long num = len - LCP[i];
				if(K > num) K -= num; //K <= num일 때 정답 포함한 substr
				else {
					ans = str.substring(SA[i], SA[i] + LCP[i] + (int) K);
					break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);
		br.close();
		long endTime = System.currentTimeMillis();
		long endMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("=== 성능 측정 결과 ===");
		System.out.println("실행 시간: " + (endTime - startTime) + " ms");
		System.out.println("메모리 사용량: " + (endMem - startMem) / 1024 + " KB");
	}
}