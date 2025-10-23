package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class p1744_수묶기 {

	private static int N;
	private static PriorityQueue<Integer> pos = new PriorityQueue<>((o1, o2) -> o2 - o1); //내림차순
	private static PriorityQueue<Integer> neg = new PriorityQueue<>(); //오름차순ㄴ
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0) pos.offer(num);
			else neg.offer(num);
		}
		
		br.close();
	}
	
	static int sum(PriorityQueue<Integer> pq) {
		int res = 0;
		while(!pq.isEmpty()) {
			int a = pq.poll();
			if(!pq.isEmpty()) {
				int b = pq.poll();
				res += Math.max(a + b, a * b);
			}
			else {
				res += a;
			}
		}
		return res;
	}
	
	static void solution() {
		int ans = sum(pos) + sum(neg);
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		solution();
	}
}
