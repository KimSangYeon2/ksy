//import java.util.Scanner;
//
//public class day7_1231_중위순회 {
//
//	static char [] tree;
//	static int N;
//	
//	public static void inorder_traverse(int T)
//	{
//		if (T <= N)
//		{
//			inorder_traverse(T * 2);
//			System.out.print(tree[T]);
//			inorder_traverse(T * 2 + 1);
//		}
//	}
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//
//        for(int tc = 1; tc <= 10; tc++) {
//
//    		N = sc.nextInt();
//    		sc.nextLine();
//    		tree = new char[N + 1];
//    		
//    		for (int i = 1; i <= N; i++)
//    		{
//    			String line = sc.nextLine();
//                String[] inputs = line.split(" ");
//                tree[i] = inputs[1].charAt(0);
//    		}
//    		
//            System.out.printf("#%d ", tc);
//            inorder_traverse(1);
//            System.out.println();
//
//	    }
//        sc.close();
//    }
//}





import java.util.Scanner;

class Node
{
	char val;
	int left;
	int right;
}

public class day7_1231_중위순회 {

	static Node[] tree;
	static int N;
	
	public static void inorder_traverse(int T)
	{
		if (T != 0)
		{
			inorder_traverse(tree[T].left);
			System.out.print(tree[T].val);
			inorder_traverse(tree[T].right);
		}
	}

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {

    		N = sc.nextInt();
    		sc.nextLine();
    		
    		tree = new Node[N + 1];
    		for(int i = 0; i <= N; i++)
    			tree[i] = new Node();
    		
    		for (int i = 1; i <= N; i++)
    		{
    			String line = sc.nextLine();
                String[] inputs = line.split(" ");
                tree[i].val = inputs[1].charAt(0);
                if (inputs.length >= 3) {
                    tree[i].left = Integer.parseInt(inputs[2]);
                }
                if (inputs.length == 4) {
                	tree[i].right = Integer.parseInt(inputs[3]);
                }
    		}
    		
            System.out.printf("#%d ", tc);
            inorder_traverse(1);
            System.out.println();

	    }
        sc.close();
    }
}









