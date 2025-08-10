package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class p2467_조합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		System.out.println(combination(N,M));
	}
	
	static BigInteger combination(int n, int m) {
		if(m > n - m) m = n - m;
		BigInteger result = BigInteger.ONE;
	    for (int i = 1; i <= m; i++) {
	        result = result.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
	    }
	    return result; 
	}
}