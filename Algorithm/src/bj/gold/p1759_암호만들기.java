package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1759_암호만들기 {

    static char[] arr;
    static int L, C;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);

        sb = new StringBuilder();
        dfs(0, "");
        System.out.println(sb);
    }

    static void dfs(int s, String in) {
        if (in.length() == L) { //길이 도달하면 끝, sb에 부분집합 추가
            if (isValid(in))
                sb.append(in).append("\n");
            return;
        }

        for (int i = s; i < C; i++) //시작점 기준 남은 단어 중에서
            dfs(i + 1, in + arr[i]); //다음 알파벳 추가.
    }

    static boolean isValid(String in) {
        int vC = 0, cC = 0;
        for (int i = 0; i < in.length(); i++) {
            if (isVowel(in.charAt(i))) vC++;
            else cC++;
        }
        return vC >= 1 && cC >= 2;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}