package practice.algorithm_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1245_균형점2 {

	static int N;
	static double left, right;
	static double[] ans;
	static int[] X, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			X = new int[N];
			M = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) X[n] = Integer.parseInt(st.nextToken());
			for(int n = 0; n < N; n++) M[n] = Integer.parseInt(st.nextToken());
			
		    ans = new double[N - 1];
		    
		    for(int n = 0; n < N - 1; n++) { //ans 배열에 값 입력하기
		    	for(int k = X[n]; k < X[n + 1]; k++) { //정수 부분 조절하기
		    		if(cal(k, n) == -1) {
		    			if(cal(k + 1, n) != -1) {
		    				ans[n] = k;
		    				decimalPoint(n);
		    			}
		    		}
		    		if(cal(k, n) == 0) {
		    			ans[n] = k;
		    			break;
		    		}
		    	}
		    }
		
			for(int n = 0; n < N - 1; n++) sb.append(String.format("%.10f", ans[n])).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}

	static void decimalPoint(int n) {
    	for(int i = 1; i <= 11; i++) { //소수점 11번째 자리수까지 입력
    		for(int j = 0; j < 10; j++) { //0 ~ 9까지 값 확인하면서 비교, 소수점 구하기
    			double newAns = ans[n] + j * divide(i);
    			if(cal(newAns, n) == -1) {
    				if(cal(newAns + divide(i), n) != -1) {
    					ans[n] = newAns;
    					break;
    				}
    			}
    			else if(cal(newAns, n) == 0) {
    				ans[n] = newAns;
    				break;
    			}
    		}
    	}
	}
	
	static double divide(int in) {
		double out = 1;
		for(int i = 1; i <= in; i++) {
			out /= 10.0;
		}
		return out;
	}
	
	static int cal(double n, int in) { // 0 <= n <= N - 2, 왼쪽값이 더 크면 -1, 오른쪽값이 더 크면 1, 같으면 0 반환
		left = 0; right = 0;
		for(int i = 0; i <= in; i++) {
			left += M[i] / (( n - X[i] ) * ( n - X[i] ));
		}
		for(int i = N - 1; i > in; i--) {
			right += M[i] / (( X[i] - n ) * ( X[i] - n ));
		}
		if(right > left) return 1;
		else if(left > right) return -1;
		return 0;
	}
}
//