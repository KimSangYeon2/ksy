package practice.algorithm_0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p2117_홈방범서비스 {

	static int N, M, ans;
	static HashSet<int[]> homeAddress;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			homeAddress = new HashSet<>();
			for(int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x = 0; x < N; x++) {
					if(Integer.parseInt(st.nextToken()) == 1) homeAddress.add(new int[] {y, x});
				}
			}
			
			ans = 0;
			searchMinHouseCnt();
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void searchMinHouseCnt() {
		int totalCnt = homeAddress.size();
		for(int k = 0; k <= N + 1; k++) {
			int cnt = cntMinHouse(k);
			//더 탐색 x
			if(!serviceAble(k, totalCnt)) break;
			if(serviceAble(k, cnt))
				ans = Math.max(ans, cnt);
		}
	}
	
	static int cntMinHouse(int K) { //K일 때 최대 집 개수
		int cnt = 0;
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N; x++) {
				int newCnt = 0;
				for(int[] house : homeAddress) {
					if(Math.abs(y - house[0]) + Math.abs(x - house[1]) < K) newCnt++;
				}
				cnt = Math.max(cnt, newCnt);
			}
		}
		return cnt;
	}
	
	static boolean serviceAble(int K, int cnt) {
		return M * cnt - (K * K + (K - 1) * (K - 1)) >= 0;
	}
}
