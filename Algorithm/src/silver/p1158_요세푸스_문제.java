package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class p1158_요세푸스_문제 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int remove = 0;//제거한 사람 수
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		remove = (remove + k - 1) % list.size();
		sb.append("<").append(list.get(remove));
		list.remove(remove);
		
		while(!list.isEmpty()) {
			remove = (remove + k - 1) % list.size();
			sb.append(", ").append(list.get(remove));
			list.remove(remove);
		}
		
		sb.append(">");
		
		System.out.println(sb);
		br.close();
	}
}