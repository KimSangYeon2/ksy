package practice.algorithm_0901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D3_단순_2진_암호코드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] code = new char[N][M];
			
			int sy = 0;
			int sx = 0;
			for (int y = 0; y < N; y++) {
				String line = br.readLine();
				for (int x = M - 1; x >= 0; x--) {
					code[y][M - 1 - x] = line.charAt(x);
					if (sy == 0 && sx == 0 && code[y][M - 1 - x] == '1') {
						sy = y;
						sx = M - 1 - x;
					}
				}
			}

			int sum = 0;
			int check = 0;
			String line = new String(code[sy]);
			for (int i = 0; i < 56; i += 7) { // 7개씩 잘라서
				 String num = line.substring(sx + i, sx + i + 7);
				 sum += checkNum(num);
				 if((i / 7) % 2 == 1) check += 3 * checkNum(num);
				 else check += checkNum(num);
			}
			
			if(check % 10 == 0) sb.append(sum);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	static HashMap<String, Integer> map = new HashMap<>();
	static{
        map.put("1011000", 0);
        map.put("1001100", 1);
        map.put("1100100", 2);
        map.put("1011110", 3);
        map.put("1100010", 4);
        map.put("1000110", 5);
        map.put("1111010", 6);
        map.put("1101110", 7);
        map.put("1110110", 8);
        map.put("1101000", 9);
    };
	
    static int checkNum(String num) {
        return map.get(num);
    }
}
