package practice.algorithm_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class p1208_Flatten {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseN = 10;
		int width = 100;
		int[] result = new int[caseN];
				
		for (int i = 0; i < caseN; i++) {
			List<Integer> Box = new ArrayList<>();
			int dumpCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 100; j++)
				Box.add(Integer.parseInt(st.nextToken()));
			
			Collections.sort(Box);
			
			for (int j = 0; j < dumpCount; j++) {
				Box.set(0, Box.get(0) + 1);
				Box.set(width - 1, Box.get(width - 1) - 1);
				Collections.sort(Box);
			}
			
			result[i] = Box.get(width - 1) - Box.get(0);
			
		}

		for (int i = 0; i < caseN; i++) {
			System.out.println("#" + (i + 1) + " " + result[i]);
		}
		
		br.close();
	}
}

//package algorithm_0804;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Flatten_1208 {
//
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int caseN = 10;
//		int width = 100;
//		int[] result = new int[caseN];
//
//		for (int t = 0; t < caseN; t++) {
//			int dumpCount = Integer.parseInt(br.readLine());
//			int[] heights = new int[101]; // 상자 높이는 1~100
//			int min = 100, max = 1;
//
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			for (int i = 0; i < width; i++) {
//				int h = Integer.parseInt(st.nextToken());
//				heights[h]++;
//				if (h < min) min = h;
//				if (h > max) max = h;
//			}
//
//			while (dumpCount-- > 0) {
//				if (max - min <= 1) break;
//
//				heights[max]--;
//				heights[max - 1]++;
//				heights[min]--;
//				heights[min + 1]++;
//
//				while (heights[max] == 0) max--;
//				while (heights[min] == 0) min++;
//			}
//
//			result[t] = max - min;
//		}
//
//		for (int i = 0; i < caseN; i++) {
//			System.out.println("#" + (i + 1) + " " + result[i]);
//		}
//
//		br.close();
//	}
//}