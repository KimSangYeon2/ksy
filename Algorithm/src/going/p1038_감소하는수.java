package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1038_감소하는수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 1000000;
		int[] nums = new int[max + 1];
		int cnt = 0;
		
		for(int n = 0; n <= max; n++) {
			nums[n] = -1;
			if(checkNum(Integer.toString(n))) {
				nums[cnt] = n;
				cnt++;
			}
		}
		
		System.out.println(nums[N]);
	}
	
	static boolean checkNum(String num) {
		boolean decrease = true;
		
		
		return decrease;
	}
}
