package bj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1916_최소비용_구하기 {
	
	static int N, M, s, e;
	static ArrayList<Bus>[] fromto;
	static Queue<Bus> q;
	static int[] totalPrice;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		fromto = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++) fromto[n] = new ArrayList<>();
		
		for(int n = 0; n < M; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			fromto[from].add(new Bus(to, price));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		totalPrice = new int[N + 1]; //각 지점까지 최솟값 저장
		for(int n = 1; n <= N; n++) totalPrice[n] = Integer.MAX_VALUE;
		totalPrice[s] = 0;
		dijkstra();
		
		bw.write(totalPrice[e] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static void dijkstra() {
		q = new PriorityQueue<>();
		q.offer(new Bus(s, 0));
		
		while(!q.isEmpty()) {
			Bus cb = q.poll();
			int point = cb.to;
			
			if(cb.price > totalPrice[point]) continue;
			
			for(Bus nb : fromto[point]) {
				if(totalPrice[nb.to] > totalPrice[point] + nb.price){//도착지점 최댓값이 새 탐색비용보다 비싸면
					totalPrice[nb.to] = totalPrice[point] + nb.price;
					q.offer(new Bus(nb.to, totalPrice[nb.to]));
				}
			}
		}
	}
	
	static class Bus implements Comparable<Bus>{
		
		int from, to, price;
		
		public Bus(int to, int price) {
			this.to = to;
			this.price = price;
		}

		@Override
		public int compareTo(Bus o) {
			return this.price - o.price;
		}
	}
}
