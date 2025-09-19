package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1941_소문난_칠공주 {

	static int ans;
	static boolean[][] isGroup;
	static char[][] group = new char[5][5];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int y = 0; y < 5; y++) {
			String line = br.readLine();
			for(int x = 0; x < 5; x++) {
				group[y][x] = line.charAt(x);
			}
		}
			
		dfs(0,);
			
		System.out.println(ans);
		br.close();
	}
	
	static void dfs(int sCnt, ) {
		
	}

}
