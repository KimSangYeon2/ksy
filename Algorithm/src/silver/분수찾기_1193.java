package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 분수찾기_1193 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int i = 0;
		int sum = 0;
		
		while (sum < n) { // n <= 1+2+3....+(i-1) 를 만족하는 i 구하기
			sum += i;
			i++;
		}
		//i 는 n번째 분자 분모의 합
		//sum은 1부터 i-1까지 합
		int a = sum - n + 1;
		int b = i - a;
		
		if (i % 2 == 0) {//대각선 우상향
			System.out.println(a + "/" + b);
			
		} else {//대각선 좌하향
			System.out.println(b + "/" + a);
		}
		
		br.close();
	}		
}