import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day11_1248_공통조상 {
     
	public static int vcnt, ecnt, n1, n2, cnt, ComAncestor;
	public static int[][] tree;
	public static final int Marker = -1;
	public static final int Lchild = 0;
	public static final int Rchild = 2;
	public static final int Parent = 2;
    
	public static  void traversal(int T)
	{
		if (T != 0)
		{
			cnt++;
			traversal(tree[T][Lchild]);
			traversal(tree[T][Rchild]);
		}
	}

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("day11_1248_공통조상.txt"));
        Scanner sc = new Scanner(System.in);
         
        int TC = sc.nextInt();
         
        for (int tc = 1; tc <= TC; tc++) {
             
        	vcnt = sc.nextInt();
        	ecnt = sc.nextInt();
        	n1 = sc.nextInt();
        	n2 = sc.nextInt();
            tree = new int[vcnt + 1][3]; // left child, right child, parent
            
            int parent, child;
    		for (int j = 0; j < ecnt; j++)
    		{
    			parent = sc.nextInt();
    			child = sc.nextInt();
    			if (tree[parent][Lchild] == 0) tree[parent][Lchild] = child;
    			else tree[parent][Rchild] = child;
    			tree[child][Parent] = parent;
    		}
            
    		// 시작점 n1, n2
    		int t, ancestor = tree[n1][Parent];
    		tree[n1][Parent] = Marker;
    		
    		while (ancestor != 0)
    		{
    			ancestor = tree[t = ancestor][Parent];
    			tree[t][Parent] = Marker;
    		}
    		
    		ComAncestor = tree[n2][Parent];

    		while (tree[ComAncestor][Parent] != Marker)
    			ComAncestor = tree[ComAncestor][Parent];

    		cnt = 0;
    		traversal(ComAncestor);
    		
            System.out.printf("#%d %d %d\n", tc, ComAncestor, cnt);
        }
        sc.close();
    }
}


