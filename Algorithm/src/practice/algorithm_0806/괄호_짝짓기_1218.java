package practice.algorithm_0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 괄호_짝짓기_1218 {
	
	static char[] arr;
	static char[][] stack;
	static int[] top;
	
	public static boolean check(char[] in) {
		top = new int[4];//0,1,2,3 각각 (),[],{},<> index, 초기값 -1(배열없을때)
		stack = new char[4][in.length];//0,1,2,3 각각 (),[],{},<> 체크
		for (int i = 0; i < 4; i++)
			top[i] = -1;
		for (int i = 0; i < in.length; i++) {
			switch(in[i]) {
			case '(':
				stack[0][++top[0]] = in[i];
				break;
			case ')':
				if (top[0] == -1) return false;
				top[0]--;
				break;
			case '[':
				stack[1][++top[1]] = in[i];
				break;
			case ']':
				if (top[1] == -1) return false;
				top[1]--;
				break;
			case '{':
				stack[2][++top[2]] = in[i];
				break;
			case '}':
				if (top[2] == -1) return false;
				top[2]--;
				break;
			case '<':
				stack[3][++top[3]] = in[i];
				break;
			case '>':
				if (top[3] == -1) return false;
				top[3]--;
				break;
			}
		}
		for (int i = 0; i < 4; i++)
			if (top[i] != -1)
				return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;
		for (int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = br.readLine().toCharArray();
			if (check(arr)) System.out.println("#" + i + " 1"); //유효하면 1
			else System.out.println("#" + i + " 0");              //아니면 0
		}
		
	}	
}
