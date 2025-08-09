package algorithm_0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sum_1209 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int caseN = 10;
		int size = 100;
		int[] result = new int[caseN];
		
		for (int i = 0; i < caseN; i++) {

			int[][] arr = new int[size][size];
			int[] sum = new int[2 * size + 2];
			
			br.readLine();
			for (int j = 0; j < arr.length; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());// 줄바꾸면서 읽기
				for (int k = 0; k < arr[j].length; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());// 배열 담기
				}
			}
			
			//가로세로 합
			for (int j = 0; j < size; j++) {
				int sumR = 0;
				int sumC = 0;
				for (int k = 0; k < size; k++) {
					sumR += arr[j][k];
					sumC += arr[k][j];
				}
				sum[j] = sumR;
				sum[j + size] = sumC;
			}
			
			//대각선 합
			int sumCross_1 = 0;
			int sumCross_2 = 0;
			for (int j = 0; j < size; j++) {
				sumCross_1 += arr[j][j];
				sumCross_2 += arr[j][size - 1 - j];
			}
			sum[sum.length - 2] = sumCross_1;
			sum[sum.length - 1] = sumCross_2;
			
			//최대값 갱신하기ㄴㄴ
			int max = 0;
			for (int j = 0; j < sum.length; j++) {
				if(sum[j] > max)
					max = sum[j];
			}
			result[i] = max;
			
		}

		for (int i = 0; i < caseN; i++) {
			System.out.println("#" + (i + 1) + " " + result[i]);
		}

	}
}