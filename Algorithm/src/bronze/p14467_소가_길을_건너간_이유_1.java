package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14467_소가_길을_건너간_이유_1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cow = new int[11];
		int count = 0;
		
		for (int i = 0; i < 11; i++)//관찰x면 -1
			cow[i] = -1;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());
			if(cow[num] != point && cow[num] != -1) {//관찰 했을 때 위치 바뀐 소 count++
				count++;
			}
			cow[num] = point;
		}
		
		System.out.println(count);
	}
}
