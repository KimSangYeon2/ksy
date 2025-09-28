package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2579_계단_오르기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		for(int n = 1; n <= N; n++) stairs[n] = Integer.parseInt(br.readLine());
		
		int[] score = new int[N+1]; //각 계단별 가능한 최대 점수
		score[1] = stairs[1];
		if(N > 1) score[2] = stairs[1] + stairs[2];
		for(int n = 3; n <= N; n++) {
			score[n] = Math.max(score[n - 2] + stairs[n], score[n - 3] + stairs[n - 1] + stairs[n]);
		}
		
		System.out.println(score[N]);
		br.close();
	}

}

//2번째 칸 오르는 경우의 수 11 2가지 경우
//3번째 칸 오르는 경우의 수 101 011 2가지 경우 1번째 + 01, 0번째 + 011
//4번째 > 1101 / 1011 > 2번째 + 01, 1번째 + 011
//5번째 > 10101 01101 / 11011 > 3번째 + 01, 2번째 + 011
//score[n - 2] + stairs[n]
//score[n - 3] + stairs[n - 1] + stairs[n]