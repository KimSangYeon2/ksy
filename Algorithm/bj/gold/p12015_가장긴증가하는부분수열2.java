package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12015_가장긴증가하는부분수열2 {

	static int N;
	static int idx = 0;
	static int[] nums;
	static int[] subNums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		subNums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++)
			nums[n] = Integer.parseInt(st.nextToken());
		
		subset();
		System.out.println(idx + 1);
	}
	
	static void subset() {
		subNums[idx] = nums[0];
		for(int n = 1; n < N; n++) {
			if(nums[n] > subNums[idx]) {
				subNums[++idx] = nums[n];
			}
			else {
				int new_idx = binarysearch(0, idx, nums[n]);
				subNums[new_idx] = nums[n];
			}
		}
	}
	
	//num이 들어갈 index 찾아주기.
	static int binarysearch(int start, int end, int num) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(num <= subNums[mid]) {
				 end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return start;
	}
}