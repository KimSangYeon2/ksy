package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class p2295_세_수의_합 {

	static int N, k;
	static HashMap<Integer, Integer> U;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		U = new HashMap<>();
		for(int n = 1; n <= N; n++) {
			U.put(n, Integer.parseInt(br.readLine()));
		}
		
		int ans = 0;
		System.out.println(ans);
	}

	static void binarySearch() {
		
	}
}
