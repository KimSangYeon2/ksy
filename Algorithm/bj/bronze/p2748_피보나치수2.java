package bj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2748_피보나치수2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] f = new long[N + 1];
		f[0] = 0;
		f[1] = 1;
		for(int i = 2; i <= N; i++) {
			f[i] = f[i - 1] + f[i -2];
		}
		System.out.println(f[N]);
		br.close();
	}
}