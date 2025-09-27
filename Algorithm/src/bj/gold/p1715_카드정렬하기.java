package bj.gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class p1715_카드정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<>(); 
		for(int n = 0; n < N; n++) q.add(sc.nextInt());
		
		int ans = 0;
		while(q.size() != 1) {
			int a = q.poll();
			int b = q.poll();
			ans += (a + b);
			q.add(a + b);
		}
		System.out.println(ans);
	}
}
