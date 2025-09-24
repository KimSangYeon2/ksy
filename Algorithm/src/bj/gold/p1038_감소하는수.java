package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p1038_감소하는수 {

	static ArrayList<Long> nums = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(long n = 0; n <= 9; n++) dfs(n);		
		
		Collections.sort(nums);
		
		if(N >= nums.size()) System.out.println(-1);
		else System.out.println(nums.get(N));
	}
	
	static void dfs(long n) {
		nums.add(n);
		long last = n % 10;
		for(int i = 0; i < last; i++) {
			dfs(n * 10 + i);
		}
	}
}
