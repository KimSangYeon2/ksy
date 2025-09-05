package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1717_집합의_표현 {
	
	static int N, M;
	static int[] parent, rank;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //0 ~ N까지 집합
		
		make();
		
		M = Integer.parseInt(st.nextToken()); //연산의 수
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cal = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Cal(cal, a, b);
		}
		
		System.out.println(sb);
		br.close();
	}

	static void Cal(int cal, int a, int b) { //0이면 합치기 1이면 같은 집합 여부 확인하기
		if(cal == 0) {
			union(parent, a, b);
		}
		if(cal == 1) {
			if(find(parent, a) == find(parent, b)) {
				sb.append("YES\n");
			}
			else sb.append("NO\n");
		}
	}
	
	static void make() {
		parent = new int[N + 1]; //부모 node
		rank = new int[N + 1];   //각 node의 rank (상위 node일수록 ++), 초기값은 자식 없으므로 0
		for(int x = 0; x < N + 1; x++) parent[x] = x; //초기 node는 자기 자신
	}
	
	static int find(int[] parent, int x) {
		if(parent[x] == x) return x; //자기 자신이면 (부모 없으면) 최상위 node, return
		else return find(parent, parent[x]); //브모 노드 따라 올라가기
	}
	
	static void union(int[] parent, int a, int b) {
		int A = find(parent, a); //a의 부모
		int B = find(parent, b); //b의 부모
		
		//부모 같으면 return
		if(A == B) return;
		
		//부모 다르면 상위 rank에 합치기
		//rank 같으면 A 집합 rank 1 증가시키고 A 집합에 합치기
		if(rank[A] > rank[B]) { //A의 rank가 더 높으면 B의 부모 A로
			parent[B] = A;
		}
		else if(rank[B] > rank[A]) { //B의 rank가 더 높으면 A의 부모 B로
			parent[A] = B;
		}
		else { //같으면 
			parent[B] = A;
			rank[A]++;
		}
	}
}
