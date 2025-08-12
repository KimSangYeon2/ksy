import java.util.Scanner;

public class day6_1238_Contact {

	public static boolean [] visited;
	public static int [][] G; //G[x][0] x에 연결된 정점의 개수
	public static int [] q = new int[200];
	public static int f, r;
	
	public static void init()
	{
		f = r = -1;
		visited = new boolean [101];
		G = new int[101][100];
	}

	public static int BFS(int v)
	{
		int ans = -1;

		q[++r] = v;
		visited[v] = true;
		q[++r] = -1; // 같은 레벨 마크

		while (true)
		{
			v = q[++f];
			if (ans < v) ans = v;

			if (v == -1)
			{
				if (f == r) break;

				ans = q[++r] = -1;
				continue;
			}

			for (int i = 0; i < G[v][0]; i++)
			{
				if (!visited[G[v][i + 1]])
				{
					visited[G[v][i + 1]] = true;
					q[++r] = G[v][i + 1];
				}
			}
		}

		return ans;
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
    		int n, s;
    		n = sc.nextInt();
    		s = sc.nextInt();
    		
    		init();
    		
    		for (int i = 0; i < n / 2; i++)
    		{
    			int u, v;
    			u = sc.nextInt();
    			v = sc.nextInt();
    			G[u][++G[u][0]] = v;
    		}
    		
            System.out.println("#" + tc + " " + BFS(s));

	    }
        sc.close();
    }
}







