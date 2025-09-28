package practice.algorithm_0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class D4_1251_하나로 {

	static int N;
	static double E, ans;
	static long[][] point;
	static int[] parent, rank; 
	static ArrayList<Path> P;
	
	static class Path implements Comparable<Path>{
		int from, to;
		double price;
		
		public Path(int from, int to) {
			this.from = from;
			this.to = to;
			this.price = price(point[from], point[to]);
		}
		
		@Override
		public int compareTo(Path o) {
			return Double.compare(this.price, o.price);
		}
	}
	
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			
			N = Integer.parseInt(br.readLine());
			point = new long[N][2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) point[n][0] = Integer.parseInt(st.nextToken()); //x좌표
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) point[n][1] = Integer.parseInt(st.nextToken()); //y좌표
			
			E = Double.parseDouble(br.readLine());
			
			kruskal();
			
			sb.append("#").append(t).append(" ").append(Math.round(ans)).append("\n");
		}
		System.out.println(sb);
		br.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
	}
	
	static void kruskal() {
		ans = 0;
		make();
		P = new ArrayList<>();
		for(int from = 0; from < N; from++)
			for(int to = 0; to < N; to++)
				P.add(new Path(from, to));
		
		Collections.sort(P);
		
		for(Path p : P) { //P에 있는 p들 중에서
			if(find(p.from) != find(p.to)) { //부모가 다른 경우
				ans += p.price;
				union(p.from, p.to);
			}
		}
	}
	
	static void make() {
		parent = new int[N];
		rank = new int[N];
		for(int n = 0; n < N; n++) parent[n] = n;
	}
	
	static int find(int n) {
		if(parent[n] == n) return n;
		else return find(parent[n]);
	}
	
	static void union(int a, int b) {
		int A = find(a); //a부모
		int B = find(b); //b부모
		
		if(A == B) return;
		if(rank[A] > rank[B]) {
			parent[B] = A;
		}
		else if(rank[B] > rank[A]) {
			parent[A] = B;
		}
		else { //같으면 A에 합치고 A rank 1증가
			parent[B] = A;
			rank[A]++;
		}
	}

	static double price(long[] from, long[] to) { //간선 간 가격 구하기
		return E * ((from[0] - to[0]) * (from[0] - to[0]) + (from[1] - to[1]) * (from[1] - to[1]));
	}
}