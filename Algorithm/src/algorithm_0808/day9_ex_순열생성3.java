package algorithm_0808;

public class day9_ex_순열생성3 {

	static int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int [] tr = new int [10];
	static int [] visited = new int [10];
	static int N = 3, R = 2;
	
	static int cnt = 1;

	static void SWAP(int i, int j)
	{
		int t = arr[i];  arr[i] = arr[j]; arr[j] = t;
	}

	static void print_arr1()
	{
		System.out.printf("[%d] : ", cnt++);
		for (int i = 0; i < R; i++)
			System.out.printf("%d ", tr[i]);
		System.out.println();
	}

	static void print_arr2()
	{
		System.out.printf("[%d] : ", cnt++);
		for (int i = 0; i < R; i++)
			System.out.printf("%d ", arr[i]);
		System.out.println();
	}


	static void perm3(int k)
	{
		if (k == R) print_arr1();
		else
		{
			for (int i = 0; i < N; i++)
			{
				if (visited[i] == 1) continue;

				tr[k] = arr[i];
				visited[i] = 1;
				perm3(k + 1);
				visited[i] = 0;
			}
		}
	}

	static void perm2(int k)
	{
		if (k == R) print_arr2();
		else
		{
			for (int i = k; i < N; i++)
			{
				SWAP(k, i);
				perm2(k + 1);
				SWAP(k, i);
			}
		}
	}


	static void perm1(int n, int r)
	{
		if (r == 0) print_arr1();
		else
		{
			for (int i = n - 1; i >= 0; i--)
			{
				SWAP(i, n - 1);
				tr[r - 1] = arr[n - 1];
				perm1(n - 1, r - 1);
				SWAP(i, n - 1);
			}
		}
	}

	static void perm_i()
	{
		for (int x1 = 0; x1 < N; x1++)
			for (int x2 = 0; x2 < N; x2++) if (x2 != x1)
			{
				tr[0] = arr[x1];
				tr[1] = arr[x2];
				print_arr1();
			}
	}

	
	public static void main(String[] args) 
	{
		perm_i();

		System.out.println("=================\n"); cnt = 1;
		perm1(N, R);

		System.out.println("=================\n"); cnt = 1;
		perm2(0);

		System.out.println("=================\n"); cnt = 1;
		perm3(0);
	}
}


