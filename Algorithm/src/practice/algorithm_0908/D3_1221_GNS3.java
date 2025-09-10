package practice.algorithm_0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D3_1221_GNS3 {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> codetoNum = new HashMap<>();
		codetoNum.put("ZRO", 0);
		codetoNum.put("ONE", 1);
		codetoNum.put("TWO", 2);
		codetoNum.put("THR", 3);
		codetoNum.put("FOR", 4);
		codetoNum.put("FIV", 5);
		codetoNum.put("SIX", 6);
		codetoNum.put("SVN", 7);
		codetoNum.put("EGT", 8);
		codetoNum.put("NIN", 9);
		
		HashMap<Integer, String> numtoCode = new HashMap<>();
		numtoCode.put(0, "ZRO");
		numtoCode.put(1, "ONE");
		numtoCode.put(2, "TWO");
		numtoCode.put(3, "THR");
		numtoCode.put(4, "FOR");
		numtoCode.put(5, "FIV");
		numtoCode.put(6, "SIX");
		numtoCode.put(7, "SVN");
		numtoCode.put(8, "EGT");
		numtoCode.put(9, "NIN");
		
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append("\n");
			int N = Integer.parseInt(st.nextToken());
			int[] codes = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) codes[n] = codetoNum.get(st.nextToken()); 
			
			Arrays.sort(codes);
			for(int n = 0; n < N; n++) sb.append(numtoCode.get(codes[n])).append(" ");
				
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) + "ms");
	}
}
