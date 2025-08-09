package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1010_다리_놓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] ans = new long[N];
		
		for (int i = 0; i < N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if (r < l || l < 0 || r < 0) {
				System.out.println("Wrong input");
				return;
			}
			
			ans[i] = combination(r,l);
		}
		
		for (int i = 0; i < N ;i++) {
			System.out.println(ans[i]);
		}
		br.close();
		
	}

	private static long combination(int n, int r) {
	    long result = 1;
	    for (int i = 1; i <= r; i++) {
	        result *= (n - i + 1); 
	        result /= i;           
	    }
	    return result;
	}

}
