package bj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2675_문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t  < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			String result = "";
			for(int i = 0; i < S.length(); i++)
				for(int j = 0; j < N; j++) 
					result += S.charAt(i);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
