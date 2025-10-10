package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] line = br.readLine().toCharArray();
		int lSize = line.length;
		char[] bomb = br.readLine().toCharArray();
		int bSize = bomb.length;
		
		//폭탄문자열 확인용 char
		char last = bomb[bSize - 1];
		
		//stack에 line 넣으면서 확인하기
		Stack<Character> str = new Stack();
		for(int i = 0; i < lSize; i++) {
			
			str.push(line[i]);
			
			int sSize = str.size();
			char c = line[i];
			
			if(c == last && bSize <= sSize) {
				boolean isBomb = true;
				for(int j = 0; j < bSize; j++) {
					if(str.get(sSize - j - 1) != bomb[bSize - j - 1]) {
						isBomb = false;
						break;
					}
				}
				if(isBomb) {
					for(int j = 0; j < bSize; j++) {
						str.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : str) sb.append(c);
		System.out.println(str.empty() ? "FRULA" : sb);
	}
}
