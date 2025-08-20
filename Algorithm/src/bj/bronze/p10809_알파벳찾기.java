package bj.bronze;

import java.util.Scanner;

public class p10809_알파벳찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String input = sc.next();
		for(int i = 0; i < 26; i++) {
			int ans = -1;
			for(char in : input.toCharArray()) {
				if(in - 'a' == i) ans = input.indexOf(in);
			}
			sb.append(ans).append(" ");
		}
		System.out.println(sb);
	}
}
