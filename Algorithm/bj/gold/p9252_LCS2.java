import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9252_LCS2 {

	static char[] aString, bString;
	static int[][] dp;
	static int[] search;
	static String ans = "";
	static int N, A, B;
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		aString = br.readLine().toCharArray();
		bString = br.readLine().toCharArray();
		A = aString.length;
		B = bString.length;
		br.close();
	}
	
	static void solution() {
		LCS();
		search();
		System.out.println(N);
		System.out.println(ans);
	}
	
	static void LCS() {
		
		dp = new int[A + 1][B + 1];
		search = new int[A + 1];
		
		for(int a = 0; a <= A; a++) {
			for(int b = 0; b <= B; b++) {
				if(a == 0 || b == 0) continue;
				if(aString[a - 1] == bString[b-1]) {
					dp[a][b] = Math.max(dp[a][b], dp[a - 1][b - 1] + 1);
					search[dp[a][b]] = a;
				}
				else dp[a][b] = Math.max(dp[a][b - 1], dp[a - 1][b]);
			}
		}
		
		N = dp[A][B];
	}
	
	static void search() {
		StringBuilder sb = new StringBuilder();
		Stack<Character> rev = new Stack<>(); 
		int a = A; 
		int b = B;
		while(a > 0 && b > 0) {
			if(a == 0 || b == 0) break;
			if(aString[a - 1] == bString[b - 1]) {
				rev.push(aString[a - 1]);
				a--;
				b--;
			}
			else if (dp[a - 1][b] > dp[a][b - 1]) a--;
			else b--;
		}
		while(!rev.isEmpty()) {
			ans += rev.pop();
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		solution();
	}

}
