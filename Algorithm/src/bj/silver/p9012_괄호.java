package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9012_괄호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Case = Integer.parseInt(br.readLine());
		for(int n = 0; n < Case; n++) {
			if(check(br.readLine().toCharArray())) System.out.println("YES");
			else System.out.println("NO");
		}
		br.close();
	}
	
	static boolean check(char[] in) {
		int size = in.length;
		int idx = 0;
		
		for(int n = 0; n < size; n++) {
			if(in[n] == '(') {
				idx++;
			}
			else if(idx == 0) {
				return false;
			}
			else {
				idx--;
			}
		}
		
		if(idx == 0) return true;
		else return false;
	}
}
