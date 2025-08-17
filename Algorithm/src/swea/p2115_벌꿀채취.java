package swea;

import java.util.Scanner;
 
public class p2115_벌꿀채취 {
    static int n, m, c;
    static int arr[][];
    static int val[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
            c = sc.nextInt();
            arr = new int[n][n];
            val = new int[n*n];
             
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int num = 0;
            for(int h = 0; h < n; h++) {
                int i;
                for(i = 0; i <= n-m; i++) {
                    val[num++] = cal(h,i);
                }
                for(; i < n; i++) {
                    val[num++] = 0;
                }
            }
            int max = 0;
            for(int i = 0; i < num-m; i++) {
                for(int j = i+m; j < num; j++) {
                    if(val[i] + val[j] > max) max = val[i]+val[j];
                }
            }
            System.out.println("#" + t + " " + max);
             
        }
    }
     
    public static int cal(int a, int b) {
        int max = 0;
        for(int i = 1; i < (1 << m); i++) {
            int tcal = 0;
            int ttcal = 0;
            for(int j = 0; j < m; j++) {
                if((i & (1 << j)) >0) {
                    tcal += arr[a][b+j];
                    ttcal += arr[a][b+j]*arr[a][b+j];
                }               
            }           
            if(tcal <= c && ttcal > max) max = ttcal;
        }
        return max;
    }
}