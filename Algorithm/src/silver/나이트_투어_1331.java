package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 나이트_투어_1331 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] n = new char[36][2];
		boolean isValid = true;
		
		for (int i = 0; i < n.length; i++) {
			String input = br.readLine();
			n[i][0] = input.charAt(0);
			n[i][1] = input.charAt(1);
			
			for (int j = 0; j < i; j++) { //중복 검사
                if (n[i][0] == n[j][0] && n[i][1] == n[j][1]) {
                    isValid = false;
                }
            }
		}
		
		for (int i = 0; i < n.length - 1; i++) { //경로 확인
			int dif0 = Math.abs(n[i][0]-n[i + 1][0]);
			int dif1 = Math.abs(n[i][1]-n[i + 1][1]);
			if (!((dif0 == 1 && dif1 == 2)||(dif0 == 2 && dif1 == 1)))
				isValid = false;
		}
		
		int dif0 = Math.abs(n[35][0]-n[0][0]);//마지막 지점에서 시작점 이동 확인
		int dif1 = Math.abs(n[35][1]-n[0][1]);
		if (!((dif0 == 1 && dif1 == 2)||(dif0 == 2 && dif1 == 1)))
			isValid = false;
		
		
		System.out.println(isValid ? "Valid" : "Invalid");
		
		br.close();
	}
}