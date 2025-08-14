package practice.algorithm_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1234_비밀번호 {
	
	static char[] nums;
	
	static char[] pass;//stack
	static int top;
	
	static StringBuilder pw(char[] in) {
		StringBuilder password = new StringBuilder();
		pass = new char[in.length];
		top = -1;
		for(int i = 0; i < in.length; i++) {
			if (top != -1 && pass[top] == in[i]) {
				top--;
			} else {
				pass[++top] = in[i];
			}
		}
		for(int i = 0; i <= top; i++) {
			password.append(pass[i]);
		}
		return password;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			nums = st.nextToken().toCharArray();
			System.out.println("#" + i + " " + pw(nums));
		}
	}
}
