package practice.algorithm_0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Suffix Array + LCP (Kasai) 시간복잡도 : O(N logN) + O(N)
//나중에 추가 공부
public class s1257_K번째_문자열2 {

	public static void main(String[] args) throws IOException {
		long startMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();

			// SA
			int L = str.length();
			Integer[] SA = new Integer[L];
			// SA (O(N log N) 방식)
			int[] rank = new int[L];
			int[] tmp = new int[L];
			
			for (int i = 0; i < L; i++) {
				SA[i] = i;
				rank[i] = str.charAt(i);
			}
			
			for (int k = 1; k < L; k <<= 1) {
				final int kk = k;
				Arrays.sort(SA, (a, b) -> {
					if (rank[a] != rank[b])
						return rank[a] - rank[b];
					int ra = (a + kk < L) ? rank[a + kk] : -1;
					int rb = (b + kk < L) ? rank[b + kk] : -1;
					return ra - rb;
				});
				tmp[SA[0]] = 0;
				for (int i = 1; i < L; i++) {
					tmp[SA[i]] = tmp[SA[i - 1]];
					if (rank[SA[i - 1]] != rank[SA[i]] || ((SA[i - 1] + kk < L ? rank[SA[i - 1] + kk]
							: -1) != (SA[i] + kk < L ? rank[SA[i] + kk] : -1))) {
						tmp[SA[i]]++;
					}
				}
				for (int i = 0; i < L; i++)
					rank[i] = tmp[i];
				if (rank[SA[L - 1]] == L - 1)
					break;
			}

			// LCP
			int LCP[] = new int[L];
			int h = 0;
			for (int i = 0; i < L; i++) {
				if (rank[i] > 0) {
					int j = SA[rank[i] - 1];
					while (i + h < L && j + h < L && str.charAt(i + h) == str.charAt(j + h)) {
						h++;
					}
					LCP[rank[i]] = h;
					if (h > 0)
						h--;
				}
			}

			//k번째 문자열 찾기
			String ans = "";
			long k = N;
			for (int i = 0; i < L; i++) {
				int suffixLen = L - SA[i];
				int newSubs = suffixLen - LCP[i]; // 새로 생기는 부분 문자열 개수
				if (k <= newSubs) {
					ans = str.substring(SA[i], SA[i] + (LCP[i] + (int) k));
					break;
				} else {
					k -= newSubs;
				}
			}
			
			// test SA
			System.out.println("Suffix Array:");
			for (int i = 0; i < L; i++)
				System.out.printf("%d: %s\n", SA[i], str.substring(SA[i]));

			// test LCP
			System.out.println("LCP:");
			for (int i = 0; i < L; i++)
				System.out.printf("%d: %s\n", LCP[i], str.substring(SA[i]));

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

//kasai를 이용하면 더 빠르게 가능