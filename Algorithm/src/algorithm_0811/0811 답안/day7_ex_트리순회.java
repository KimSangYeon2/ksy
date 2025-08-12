import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day7_ex_트리순회 {
	public static int tree[][] = new int [100][2];
	public static int q[] = new int [10];
	public static int f, r;

	public static void inorder_traverse(int T)
	{
		if (T != 0)
		{
			 inorder_traverse(tree[T][0]);
			 System.out.printf(" %d", T);
			 inorder_traverse(tree[T][1]);
	 	}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("day7_ex_트리순회_input.txt"));
		int N;
		N = sc.nextInt();
		 
		int p, c;
		for (int i = 1; i < N; i++)
		{
			 p = sc.nextInt();
			 c = sc.nextInt();
			 if (tree[p][0] == 0 ) tree[p][0] = c;
			 else    tree[p][1] = c;
		}
		inorder_traverse(1);
		sc.close();
	}
}


