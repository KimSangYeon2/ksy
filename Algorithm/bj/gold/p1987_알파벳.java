import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1987_알파벳 {

	static int R, C, ans;
	static char[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static HashSet<Character> visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0; c < C; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		
		visited = new HashSet<>();
		ans = 1;
		dfs(0, 0, 1);
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int cnt) {
		
		visited.add(board[r][c]);
		ans = Math.max(ans, cnt);
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!inRange(nr, nc) || visited.contains(board[nr][nc])) continue;
			dfs(nr, nc, cnt + 1);
		}
		
		visited.remove(board[r][c]);
	}
	
	static boolean inRange(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
