package practice.algorithm_0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_1245_균형점 {

	static int N;
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
		    	ans[n] = binarySearch(X[n], X[n + 1], n);
		    }
		
			for(int n = 0; n < N - 1; n++) sb.append(String.format("%.10f", ans[n])).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static double binarySearch(double start, double end, int in) {
		double mid = (start + end) / 2.0;
	    double l = left(mid, in);
	    double r = right(mid, in);

		if (end - start < 1e-12) return mid;
	    if (l < r) return binarySearch(start, mid, in); // 오른쪽이 더 강하면 왼쪽으로
	    else return binarySearch(mid, end, in); // 왼쪽이 더 강하면 오른쪽으로
	}
	
	static double left(double n, int in) {
		double left = 0;
		for(int i = 0; i <= in; i++) {
			left += M[i] / (( n - X[i] ) * ( n - X[i] ));
		}
		return left;
	}
	
	static double right(double n, int in) {
		double right = 0;
		for(int i = N - 1; i > in; i--) {
			right += M[i] / (( X[i] - n ) * ( X[i] - n ));
		}
		return right;
	}
}
//