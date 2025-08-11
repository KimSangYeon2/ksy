package algorithm_0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TEST {

	static int N;
	static int[] nums;
	static int[] comb = new int[6];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			nums = new int[N];
			for(int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			dfs(0, 0);
			System.out.println();
		}
	}
	
	static void dfs(int s, int d) {
	    if (d == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(comb[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = s; i < N; i++) {
            comb[d] = nums[i];
            dfs(i + 1, d + 1);//다음탐색, 깊이 1추가
        }
    }
}