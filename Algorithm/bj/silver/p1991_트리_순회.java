package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1991_트리_순회 {

	static String[][] tree;// 좌, 우 node 저장
	static int N;

	static void preOrder(String node) {// VLR
		if (node.equals("."))
			return;
		String L = tree[node.charAt(0) - 'A'][0];
		String R = tree[node.charAt(0) - 'A'][1];
		System.out.print(node);// V
		preOrder(L);// L
		preOrder(R);// R
	}

	static void inOrder(String node) {// LVR
		if (node.equals("."))
			return;
		String L = tree[node.charAt(0) - 'A'][0];
		String R = tree[node.charAt(0) - 'A'][1];
		inOrder(L);// L
		System.out.print(node);// V
		inOrder(R);// R
	}

	static void postOrder(String node) {// LRV
		if (node.equals("."))
			return;
		String L = tree[node.charAt(0) - 'A'][0];
		String R = tree[node.charAt(0) - 'A'][1];
		postOrder(L);// L
		postOrder(R);// R
		System.out.print(node);// V
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new String[26][2];
		for (int n = 1; n <= N; n++) {
			String[] in = br.readLine().split(" ");
			String p = in[0];
			tree[p.charAt(0) - 'A'][0] = in[1];
			tree[p.charAt(0) - 'A'][1] = in[2];
		}

		preOrder("A");
		System.out.println();
		inOrder("A");
		System.out.println();
		postOrder("A");

		br.close();
	}

}