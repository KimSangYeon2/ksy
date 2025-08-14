package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4012_요리사 {

    static int N, min, halfComb1, halfComb2;
    static int[] subfood, leftfood, subfood_two;
    static boolean[] isUsed;
    static int[][] table;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            table = new int[N][N];
            isUsed = new boolean[N];
            for (int y = 0; y < N; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < N; x++) {
                    table[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            subfood = new int[N / 2];
            min = Integer.MAX_VALUE;

            subfood[0] = 0;
            isUsed[0] = true;
            subset(1, 1);

            sb.append(min).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void subset(int in, int d) {
        if (d == N / 2) {
            foodComb();
            int newMin = Math.abs(halfComb1 - halfComb2);
            if (newMin < min) min = newMin;
            return;
        }
        for (int i = in; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                subfood[d] = i;
                subset(i + 1, d + 1);
                isUsed[i] = false;
            }
        }
    }

    static void subfood1() { // A그룹 시너지 계산
        subfood_two = new int[2];
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int a = subfood[i];
                int b = subfood[j];
                halfComb1 += table[a][b] + table[b][a];
            }
        }
    }

    static void subfood2() { // B그룹 시너지 계산
        leftfood = new int[N / 2];
        int idx = 0;
        for (int n = 0; n < N; n++) {
            if (!isUsed[n]) { // 사용 안한 재료
                leftfood[idx++] = n;
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                int y = leftfood[i];
                int x = leftfood[j];
                halfComb2 += table[y][x] + table[x][y];
            }
        }
    }

    static void foodComb() {
    	halfComb1 = 0;
    	halfComb2 = 0;
        subfood1();
        subfood2();
    }
}