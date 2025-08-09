package algorithm_0806;

import java.util.Scanner;

public class practice_02 {
	
	public static char stack[] = new char[100];
	public static int top = -1;
	
	public static boolean check(char[] in) {
		for (int i = 0; i < in.length; i++) {	 //stack구현할 배열에 data 담기
			switch(in[i]) {                  	 //in[i]가
				case '(' :                       //'('인 경우
					stack[++top] = in[i];        //data하나 쌓기
					break;
				case ')' :                       //')'인 경우
					if (top == -1) return false; //맨처음에 ')'인 경우 검사 결과 실패
					top--;                       //아닌 경우 
					break;
			}
			
		}
		if (top != -1) return false;
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toString().toCharArray();
		if (check(arr))
			System.out.println("o");
		else
			System.out.println("x");
	}

}
