package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1248_공통조상 {

	static class Node {
		int child, parent;
		
		public Node(int child, int parent) {
			this.child = child;
			this.parent = parent;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
		
			
			sb.append("#").append(t).append(" ").append(0).append(" ").append(0).append("\n");
		}
	}
}
