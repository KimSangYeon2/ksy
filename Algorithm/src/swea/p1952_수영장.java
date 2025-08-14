package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1952_수영장 {
	
	static int[] cost, plan;
	static int price;
	
	//3달씩 잘라서 탐색
	//1달 기준 
	static void totalPrice(int m, int sum) {
	    if (m > 12) {//
	        price = Math.min(price, sum);
	        return;
	    }
	    if (sum >= price) return;//기존 가격보다 높으면 탐색 x
	    if (plan[m] == 0) {
	    	totalPrice(m + 1, sum);//해당 달 수영장 안가면 일일 이용권 x
	        return;
	    }
	    totalPrice(m + 1, sum + plan[m] * cost[0]);//일일 이용권
	    totalPrice(m + 1, sum + cost[1]);//월 간 이용권
	    totalPrice(m + 3, sum + cost[2]);//3달 이용권
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			cost = new int[4];
			plan = new int[13];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < 4; n++)
				cost[n] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= 12; n++)
				plan[n] = Integer.parseInt(st.nextToken());
			
			price = Integer.MAX_VALUE;
			totalPrice(1, 0);//가격 더하기
			price = Math.min(price, cost[3]);
			
			sb.append("#").append(t).append(" ").append(price).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}

