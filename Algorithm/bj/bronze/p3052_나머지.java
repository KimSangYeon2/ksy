package bj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3052_나머지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int[] nums = new int[10];
		for(int i = 0; i < 10; i++) {
			nums[i] = Integer.parseInt(br.readLine()) % 42;
		}
		
		for(int i = 0; i < 10; i++) {
			boolean isSame = true;
			for(int j = i + 1; j < 10; j++) {
				if(nums[i] == nums[j]) {
					isSame = false;
					continue;
				}
			}
			if(isSame) count++;
		}
		System.out.println(count);
	}
}
