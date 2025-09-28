package practice.algorithm_0806;

import java.util.ArrayList;
import java.util.Scanner;

public class p1219_길찾기 {

	static boolean[] visited;
	static ArrayList<Integer>[] node;
	static ArrayList<Integer> point;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 10; tc++) {
			int tC = sc.nextInt();
			int nodeC = sc.nextInt();
			
			node = new ArrayList[100];
            for (int i = 0; i < 100; i++) {
                node[i] = new ArrayList<>();
            }
            
			visited = new boolean[100];
			point = new ArrayList<>();
			
			for (int i = 0; i < nodeC; i++) {
				int in = sc.nextInt();
				int out = sc.nextInt();
				node[in].add(out);
			}
			
			dfs(0);
			
			if (visited[99]) System.out.println("#" + tC + " 1");
			else System.out.println("#" + tC + " 0");
		}
	}

	static void dfs(int nodeIndex) {
		visited[nodeIndex] = true;
		point.add(nodeIndex);
		for (int node : node[nodeIndex]) {
			if(!visited[node]) {
				dfs(node);
			}
		}
	}
}
