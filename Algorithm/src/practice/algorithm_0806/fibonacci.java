package practice.algorithm_0806;

public class fibonacci {
	
	//재귀사용
	public static long fibonacci_1(int n) {
		if (n <= 1)
			return n;
		else
			return fibonacci_1(n - 2) + fibonacci_1(n - 1);
	}
	
	//dp - 메모이제이션 사용
	public static long[] fb;
	public static long fibonacci_2(int n) {
		fb = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			if (i <= 1) fb[i] = i;
			else fb[i] = fb[i - 1] + fb[i - 2];
			}
		return fb[n];
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci_1(10));
		System.out.println(fibonacci_2(10));
	}

}
