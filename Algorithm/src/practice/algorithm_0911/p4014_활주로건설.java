package practice.algorithm_0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4014_활주로건설 {

	static int N, X, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			int[][] mapTemp = new int[N][N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					int in = Integer.parseInt(st.nextToken());
					map[y][x] = in;
					mapTemp[x][y] = in;
				}
			}

			ans = 0;
			check(map);
			check(mapTemp);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static void check(int[][] arr) {
		boolean isAble;
		int len;
		for (int y = 0; y < N; y++) {
			len = 1;
			isAble = true;
			for (int x = 1; x < N; x++) {
				int dif = arr[y][x] - arr[y][x - 1];
				
				//평지
				if (dif == 0)len++;
				
				//오르막길
				else if (dif == 1) {
					if (len < X) { //설치 못하는 경우
						isAble = false;
						break;
					}
					len = 1;					
				} 
				
				//내리막길
				else if (dif == -1) {
				    for (int k = 0; k < X; k++) {
				    	if(x + k >= N || arr[y][x + k] != arr[y][x]) { //범위 밖이라 설치 못하는 경우, 설치 못하는 경우
				    		isAble = false;
				            break;
				    	}
				    }
				    x = x + X - 1;
					len = 0;
				} 
				
				//높이차 1보다 큰 경우
				else {
					isAble = false;
					break;
				}
			}
			if (isAble)
				ans++;
		}
	}
}

//같은 길이 x이상이여야 활주로 설치 가능
//감소하는 활주로 경우 x 길이 활주로, 활주로에서 x길이 이내 증가하면 false
//증가하는 활주로 경우 x 길이 활주로

//시작점부분 낮아질 때 길이체크 pass
//마지막부분 높아질 때 길이체크 pass