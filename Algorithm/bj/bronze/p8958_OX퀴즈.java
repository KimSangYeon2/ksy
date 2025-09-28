package bj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			char[] ans = br.readLine().toCharArray();
			int score = 0;
			int count = 0;
			
			if(ans[0] == 'O') score++;
			
			for(int i = 1; i < ans.length; i++) {
				if(ans[i] == 'O') score++;
				if(ans[i] == 'O' && ans[i - 1] == 'O') {
					count++;
					score += count;
				}
				else count = 0;
			}
			
			sb.append(score).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
