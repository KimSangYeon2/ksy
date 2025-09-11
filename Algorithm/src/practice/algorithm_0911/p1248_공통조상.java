package practice.algorithm_0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1248_공통조상 {
	
	static int V, E, A, B, minParent, cnt;
	static Node[] Tree;
	static Queue<Integer> q;
	static ArrayList<Integer> parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			Tree = new Node[V + 1];
			for(int v = 0; v <= V; v++) Tree[v] = new Node();
			
			st = new StringTokenizer(br.readLine());
			for(int e = 0; e < E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				if(Tree[parent].left == 0) Tree[parent].left = child;
				else Tree[parent].right = child;
				Tree[child].parent = parent;
			}
			
			minParent = 1;
			parents = new ArrayList<>();
			//findParent();
			findParent2(A, B);
			
			cnt = 0;
			countSubtree(Tree[minParent]);
			//countSubtree2(Tree[minParent]);
			
			sb.append("#").append(t).append(" ").append(minParent).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	//부모찾기 by while문
	static void findParent() {
		boolean[] visited = new boolean[V + 1];
		while(true) {
			if(A != 1) {
				int parent = Tree[A].parent;
				if (visited[parent]) {
					minParent = parent; 
					break;
				}
				visited[parent] = true;
				A = parent;
			}
			if(B != 1) {
				int parent = Tree[B].parent;
				if (visited[parent]) {
					minParent = parent; 
					break;
				}
				visited[parent] = true;
				B = parent;
			}
		}
	}
	
	//부모찾기 by list 비교
	static void findParent2(int A, int B) {
		if(A != 0 && parents.contains(A)) {
			minParent = A;
			return;
		} 
		else if( (B != 0 && parents.contains(B)) || A == B) {
			minParent = B;
			return;
		}
		parents.add(A);
		parents.add(B);
		findParent2(Tree[A].parent, Tree[B].parent);
	}
	
	//stack DFS
	static void countSubtree(Node root) {
		Deque<Node> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			cnt++;
			if(node.left != 0) stack.push(Tree[node.left]);
			if(node.right != 0) stack.push(Tree[node.right]);
		}
	}
	
	//재귀 DFS
	static void countSubtree2(Node root) {
		cnt++;
		if(root.left != 0) countSubtree2(Tree[root.left]);
		if(root.right != 0) countSubtree2(Tree[root.right]);
	}
	
	static class Node {
		int parent, left, right;
	}
}
