package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 0;
		
		int[] coin = new int[N];
		for(int n = N - 1; n >= 0; n--) coin[n] = Integer.parseInt(br.readLine());
		
		for(int n = 0; n <  N; n++) {
			int a = K / coin[n];
			result += a;
			K -= a * coin[n];
		}
		
		System.out.println(result);
	}
}
