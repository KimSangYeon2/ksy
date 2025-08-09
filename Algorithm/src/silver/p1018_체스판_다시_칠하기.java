package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1018_체스판_다시_칠하기 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] MN = br.readLine().split(" ");
		int M = Integer.parseInt(MN[0]);
		int N = Integer.parseInt(MN[1]);
		char[][] chess = new char[M][N];

		for (int i = 0; i < M; i++) {
			String chessLine = br.readLine();
			for (int j = 0; j < N; j++) {
				chess[i][j] = chessLine.charAt(j);
			}
		}

		int min = 64;
		for (int i = 0; i <= M - 8; i++) {
			for (int j = 0; j <= N - 8; j++) {
				int b = colorCount(i, j, chess, 'B');//??
				int w = colorCount(i, j, chess, 'W');
				int newMin = (b < w) ? b : w;
				min = (min > newMin) ? newMin : min;
			}
		}

		System.out.println(min);
	}
	
	static int colorCount(int M, int N, char[][] chess, char BW) {
		int count = 0;//색 배치 맞는 color count하기
		boolean needChange = false;
		//i+j 짝수일 때 chess[i][j] = BW이면 count++
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	needChange = (i + j) % 2 == 0 ? 
            			(chess[M + i][N + j] == BW ? true : false) : (chess[M + i][N + j] != BW ? true : false);
            	if (needChange)
            		count++;
            }
        }
		
		return 64 - count;
	}

}