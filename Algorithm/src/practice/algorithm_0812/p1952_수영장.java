package practice.algorithm_0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1952_수영장 {
	
	static int[] cost, plan;
	static int price;
	
	//3달씩 잘라서 탐색
	//1달 기준 
	static void dfs(int m, int sum) { //???
//	    if (m > 12) {
//	        price = Math.min(price, sum);
//	        return;
//	    }
//	    if (sum >= price) return;
//	    if (plan[m] == 0) {
//	        dfs(m + 1, sum);
//	        return;
//	    }
//	    dfs(m + 1, sum + plan[m] * cost[0]);
//	    dfs(m + 1, sum + cost[1]);
//	    dfs(m + 3, sum + cost[2]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			cost = new int[4];// 1일, 1달, 3달, 1년 이용권 가격
			plan = new int[13];// 각 달 사용 날 저장

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < 4; n++)
				cost[n] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int n = 1; n <= 12; n++)
				plan[n] = Integer.parseInt(st.nextToken());
			
			price = Integer.MAX_VALUE;
			dfs(1, 0);//가격 더하기
			price = Math.min(price, cost[3]);
			
			sb.append("#").append(t).append(" ").append(price).append("\n");
		}
		System.out.println(sb);
		br.close();
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간(ms): " + (end - start));
	}

}
