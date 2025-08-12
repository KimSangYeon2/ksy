//////  너비 우선 탐색 
// 입력 데이터
// 1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7

public class day6_ex_BFS {

	public static int G[][] = {
			 { 0, 0, 0 },
			 { 2, 3, 0 }, // 정점 1의 인접정점
			 { 1, 4, 5 }, // 정점 2의 인접정점
			 { 1, 7, 0 }, // 정점 3의 인접정점
			 { 2, 6, 0 }, // 정점 4의 인접정점
			 { 2, 6, 0 }, // 정점 5의 인접정점
			 { 4, 5, 7 }, // 정점 6의 인접정점
			 { 3, 6, 0 } };  // 정점 7의 인접정점

	public static boolean visited[] = new boolean[8];
	public static int q[] = new int [10];
	public static int f, r;

	public static void BFS(int w)
	{
		System.out.printf("%d ", q[++r] = w);
		visited[w] = true;

		while (f != r) 
		{
			w = q[++f];
			for (int i = 0; i < 3; i++) 
			{
				if (G[w][i] > 0 && !visited[G[w][i]]) 
				{
					System.out.printf("%d ", q[++r] = G[w][i]);
					visited[G[w][i]] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		f = r = -1;
		BFS(1);
	}
}


