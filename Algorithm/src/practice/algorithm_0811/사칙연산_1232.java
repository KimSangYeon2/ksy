package practice.algorithm_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사칙연산_1232 {
	
	static int[][] tree;
	
	static void inOrder(int in) { //LRV, 후위식으로 해야할듯
		if (in == 0) return;
		inOrder(tree[in][1]);
		inOrder(tree[in][2]);
		System.out.print((char) tree[in][0]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for(int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			tree = new int[101][3];//0번에 char값을 int로, 1에 왼쪽 노드, 2에 오른쪽 노드
			for(int n = 1; n <= N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int pr = Integer.parseInt(st.nextToken());//부모 index
				tree[pr][0] = st.nextToken().charAt(0);
				if(st.hasMoreTokens()) // 토큰 더 있으면 왼쪽 node 정보
					tree[pr][1] = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) // 토큰 더 있으면 오른쪽 node 정보
					tree[pr][2] = Integer.parseInt(st.nextToken());
			}
			
			System.out.print("#" + t + " ");
			inOrder(1);
			System.out.println();
		}
		br.close();
	}

}
