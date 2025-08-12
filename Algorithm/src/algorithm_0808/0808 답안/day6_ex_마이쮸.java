//public class day5_ex_마이쮸 {
//
//	public static int q[] = new int[100];
//	public static int studcan[] = new int[20];
//	public static int f = -1, r = -1, candis = 20;
//
//	public static void main(String[] args) 
//	{
//	   int sn = 1, nextsn = 2;
//
//		for (int i = 0; i < 20; i++)
//			studcan[i] = 1;
//
//	   q[++r] = sn;
//	   sn = q[++f];
//
//	   while (candis > 0)
//	   {
//	       candis -= studcan[sn];
//	       studcan[sn]++;
//
//	       if (candis <= 0)
//	       {
//	    	   System.out.println(sn);
//	    	   break;
//	       }
//
//
//	       q[++r] = sn;
//	       q[++r] = nextsn++;
//	       sn = q[++f];
//	   	}
//	}
//}
package algorithm_0811;




public class day6_ex_마이쮸 {

	public static int q[] = new int[100];
	public static int studcan[] = new int[20];
	public static int f = -1, r = -1, candis = 20;

	public static void printQ( )
	{
		System.out.printf("[");
	    for (int i = f + 1; i < r + 1; i++)
	    	System.out.printf("%d ", q[i]);
	    System.out.printf("]\n\n");
	}
	
	public static void main(String[] args) 
	{
	    int sn = 1, incomming_sn = 2;
		
	    for (int i = 0; i < 20; i++)
	        studcan[i] = 1;
	    
	    q[++r] = sn;
	    System.out.printf("==>%d번 학생 : 입장하여 줄을 선다.\n", sn);
	
	    printQ( );
	
	    sn = q[++f];
	    System.out.printf("%d번 학생 : 줄에서 나와...\n", sn);
	    printQ( );
	

	    while (candis > 0)
	    {
	        candis -= studcan[sn];
	        System.out.printf("%d번 학생 : 선생님한테 사탕 %d개를 받는다.\n", sn, studcan[sn]);
	        System.out.printf("===== 남은 사탕의 개수는 %d개다.\n\n", candis);
	        studcan[sn]++;
	
	        if (candis <= 0)
	        {
		    	   System.out.println(sn);
		    	   break;
	        }
	
	        q[++r] = sn;
	        System.out.printf("%d번 학생 : 다시 줄을 선다.\n", sn);
	        printQ( );
	        System.out.printf("==>%d번 학생 : 입장하여 줄을 선다.\n", incomming_sn);
	        q[++r] = incomming_sn++;
	        printQ( );
	        sn = q[++f];
	        System.out.printf("%d번 학생 : 줄에서 나와...\n", sn);
	        printQ( );
	    }
	}
}

