package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2193_이친수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] pn = new long[N + 1];
		pn[0] = 0; pn[1] = 1;
		for(int n = 2; n <= N; n++) pn[n] = pn[n - 1] + pn[n - 2];
		System.out.println(pn[N]);
		br.close();
	}
}
//3, 4
// 1 1 2 3 5 > 피보나치
// 10 100 > 100 경우의수 100 10 > 10 경우의수

// 100/01  1000/0