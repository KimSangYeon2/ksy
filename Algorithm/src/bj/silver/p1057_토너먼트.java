package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1057_토너먼트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int jN = Integer.parseInt(st.nextToken());
		int mN = Integer.parseInt(st.nextToken());
		int round = 0;
		
		while(jN != mN) {
			jN = (jN + 1) / 2;
			mN = (mN + 1) / 2;
			round++;
		}
		
		System.out.println(round);
	}
}
