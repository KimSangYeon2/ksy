package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1216_회문2 {

	static char[][] Char;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			Char = new char[100][100];
			for(int y = 0; y < 100; y++) {
				String line = br.readLine();
				for(int x = 0; x < 100; x++) {
					Char[y][x] = line.charAt(x);
				}
			}
			
			ans = 1; //최소길이
			
			searchbyX();
			searchbyY();
			
			sb.append("#").append(N).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static void searchbyX() {
		boolean checkAble;
		for(int n = 100; n >= 1; n--) { //최대 길이부터 확인
			for(int y = 0; y < 100; y++) {
				for(int x = 0; x <= 100 - n; x++) {
					checkAble = true;
					for(int i = 0; i < n / 2; i++) { //회문인지 확인
						if(Char[y][x + i] != Char[y][x + (n - i) - 1]) {
							checkAble = false;
							break;
						}
					}
					if(checkAble) { //최대 길이 찾았으므로 return
						ans = Math.max(ans, n);
						return;
					}
				}
			}	
		}
	}
	
	static void searchbyY() {
		boolean checkAble;
		for(int n = 100; n >= 1; n--) { //최대 길이부터 확인
			for(int x = 0; x < 100; x++) {
				for(int y = 0; y <= 100 - n; y++) {
					checkAble = true;
					for(int i = 0; i < n / 2; i++) { //회문인지 확인
						if(Char[y + i][x] != Char[y + (n - i) - 1][x]) {
							checkAble = false;
							break;
						}
					}
					if(checkAble) { //최대 길이 찾았으므로 return
						ans = Math.max(ans, n);
						return;
					}
				}
			}	
		}
	}
}
