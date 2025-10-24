import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int[][] alpSetNum = new int[26][2]; //0은 cnt, 1은 num
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N; n++) {
			char[] alp = br.readLine().toCharArray();
			int len = alp.length;
			for(int i = 0; i < len; i++) {
				int al = alp[i] - 'A';
				alpSetNum[al][0] += (int) Math.pow(10, len - i - 1);
			}
		}
		br.close();
	}
	
	static void sum() {
		
		Arrays.sort(alpSetNum, (o1, o2) -> o2[0] - o1[0]);
		
		int i = -1;
		int n = 9;
		int ans = 0;
		
		while(alpSetNum[++i][0] != 0) {
			ans += alpSetNum[i][0] * n--;
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		sum();
	}
}
