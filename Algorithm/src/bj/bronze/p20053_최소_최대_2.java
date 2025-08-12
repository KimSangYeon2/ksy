package bj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

//array
public class p20053_최소_최대_2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			
			int N = sc.nextInt();
			int[] nums = new int[N];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for(int j = 0; j < N; j++) {
				nums[j] = sc.nextInt();
				if(nums[j] < min) min = nums[j];
				if(nums[j] > max) max = nums[j];
			}
			
			System.out.println(min + " " + max);
		}
		
	}
	
}

//arraylist - 정렬하는데 시간 더 들어서 scanner로는 시간초과
//public class 최소_최대_2_20053 {
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tc = Integer.parseInt(br.readLine());
//
//		for (int i = 0; i < tc; i++) {
//
//			int N = Integer.parseInt(br.readLine());
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			ArrayList<Integer> nums = new ArrayList<>();
//			
//			for (int j = 0; j < N; j++) {
//				nums.add(Integer.parseInt(st.nextToken()));
//			}
//			
//			Collections.sort(nums);
//			int min = nums.get(0);
//			int max = nums.get(N-1);
//			
//			System.out.println(min + " " + max);
//		}
//
//	}
//}