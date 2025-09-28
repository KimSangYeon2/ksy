package practice.algorithm_0808;

public class practice_01 {//큐 구현하기
	
	public static int Q[] = new int[10];
	public static int f,r;
	
	public static void main(String[] args) {
		f = r = -1;
		
		Q[++r] = 1;
		Q[++r] = 2;
		Q[++r] = 3;
		
		System.out.println(Q[++f]);
		System.out.println(Q[++f]);
		System.out.println(Q[++f]);
	}

}
