package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p10815_숫자_카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> cards = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) 
			cards.add(Integer.parseInt(st.nextToken()));
		
		int M  = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			if(cards.contains(Integer.parseInt(st.nextToken()))) 
				sb.append(1).append(" ");
			else 
				sb.append(0).append(" ");
		}
		System.out.println(sb);
		br.close();
	}
}
