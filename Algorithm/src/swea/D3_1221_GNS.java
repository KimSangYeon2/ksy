package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D3_1221_GNS {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append("\n");
			int N = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Code> solve = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) solve.add(new Code(st.nextToken()));
			
			for(int n = 0; n < N; n++) sb.append(solve.poll().code).append(" ");
				
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
	}
	
	static HashMap<String, Integer> map = new HashMap<>();
	static {
		map.put("ZRO", 0);
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THR", 3);
		map.put("FOR", 4);
		map.put("FIV", 5);
		map.put("SIX", 6);
		map.put("SVN", 7);
		map.put("EGT", 8);
		map.put("NIN", 9);
	}
	
	static class Code implements Comparable<Code>{
		String code;
		int num;
		
		public Code(String code) {
			this.code = code;
			this.num = map.get(code);
		}
		
		@Override
		public int compareTo(Code o) {
			return this.num - o.num;
		}
	}
}
