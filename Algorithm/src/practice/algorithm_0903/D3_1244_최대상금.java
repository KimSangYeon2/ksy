package practice.algorithm_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_1244_최대상금 {

	static int N, K, max;
	static String initNum;
	static int[] num;
	static ArrayList<String>[] isUsed;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			initNum = st.nextToken();
			N = initNum.length();
			K = Integer.parseInt(st.nextToken());
			isUsed = new ArrayList[K + 1];
			for(int i = 0; i < K + 1; i++) isUsed[i] = new ArrayList<String>();
			
			max = 0;
			dfs(0, initNum);
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void dfs(int cnt, String in) {
		if(isUsed[cnt].contains(in)) return; //이번 회차에서 같은 숫자는 스킵
		if(cnt != 0)
			if(isUsed[cnt - 1].contains(in)) return; //이전 회차에서 같은 숫자는 스킵
		isUsed[cnt].add(in);
		if(cnt == K) {
			int ans = Integer.parseInt(in);
			max = Math.max(max, ans);
			return;
		}
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				String next = change(i, j, in);
				dfs(cnt + 1, next);
			}
		}
	}
	
	static String change(int i, int j, String in) {
		char[] tempIn = in.toCharArray();
		char temp = tempIn[i];
		tempIn[i] = tempIn[j];
		tempIn[j] = temp;
		return new String(tempIn);
	}
}
//한번 교환마다 최대값 저장하기
//교환마다 값 저장, 그 값보다 작거나 같으면 return
