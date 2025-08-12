package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1206_View {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//case수
		int N = 10;
		int[] answer = new int[N]; 
		
		for(int i = 0; i < N; i++) {
			int width = Integer.parseInt(br.readLine());
			int[] Height = new int[width];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < width; j++) {
				Height[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 2; j < width - 2; j++) {
				
				int maxHeightN = Height[j - 2];
				if (Height[j - 1] > maxHeightN)
					maxHeightN = Height[j - 1];
				if (Height[j + 1] > maxHeightN)
					maxHeightN = Height[j + 1];
				if (Height[j + 2] > maxHeightN)
					maxHeightN = Height[j + 2];
				if (Height[j] > maxHeightN)
					answer[i] += Height[j] - maxHeightN;
			}
				
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println("#" + (i+1) + " " + answer[i]);
		}
		br.close();
	}
}

//거리 2 이상 공간 확보되어야 조망권 확보
//array에서 해당 index 숫자와 index+-2 범위 숫자 차이 확인
//차이 최소값이 0이하면 +0, 0 이상이면 차이 최소값을 더해준다.
//처음부터 끝까지 확인
//case 수 n개, #n 건물개수