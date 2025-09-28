package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p13305_주유소 {
	
	static int N;
	static long minPrice, p;
	static long[] dist, price;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dist = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N - 1; i++) dist[i] = Long.parseLong(st.nextToken());
		
		price = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) price[i] = Long.parseLong(st.nextToken());
		
		p = Long.MAX_VALUE;
		minPrice = 0;
		for(int i = 1; i < N; i++) {
			p = Math.min(p, price[i]);
			minPrice += p * dist[i];
		}
		
		System.out.println(minPrice);
	}
}
