package practice.algorithm_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1259_금속막대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> mapScrew = new HashMap<>();
			HashSet<Integer> setFront = new HashSet<Integer>();
			HashSet<Integer> setBack = new HashSet<Integer>();
			
			//나사 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				int front = Integer.parseInt(st.nextToken());
				int back = Integer.parseInt(st.nextToken());
				mapScrew.put(front, back);
				setFront.add(front);
				setBack.add(back);
			}
			
			//시작점 찾기
			int start = 0;
			for(int n : setFront)
				if(!setBack.contains(n)) start = n;
			
			while(!mapScrew.isEmpty()) {
				int end = mapScrew.remove(start);
				sb.append(start).append(" ").append(end).append(" ");
				start = end;
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
