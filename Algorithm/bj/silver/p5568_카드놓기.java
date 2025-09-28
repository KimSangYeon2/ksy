package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p5568_카드놓기 {

	static int n, k;
	static int[] nums;
	static boolean[] isUsed;
	static ArrayList<String> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		nums = new int[n];
		for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());
		
		isUsed = new boolean[n];
		result = new ArrayList<>();
		dfs(0,"");
		System.out.println(result.size());
	}
	
	static void dfs(int depth, String ans) {
		if(depth == k) {
			if(result.contains(ans)) return;
			result.add(ans);
			return;
		}
		for(int i = 0; i < n; i++) {
			if(isUsed[i]) continue;
			isUsed[i] = true;
			dfs(depth + 1, ans + nums[i]);
			isUsed[i] = false;
		}
	}
}
