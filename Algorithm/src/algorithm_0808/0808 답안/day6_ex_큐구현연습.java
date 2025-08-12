package algorithm_0811;

public class day6_ex_큐구현연습 {

	public static int Q[] = new int [10];
	public static int f, r;

	public static void main(String[] args) 
	{
		f = r = -1;
		
	    Q[++r] = 1;
	    Q[++r] = 2;
	    Q[++r] = 3;

		System.out.println(Q[++f]);
		System.out.println(Q[++f]);
		System.out.println(Q[++f]);
		
	}
}
