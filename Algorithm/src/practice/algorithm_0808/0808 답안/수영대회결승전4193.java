//import java.io.*;
//import java.util.*;
//
////public class Solution {
//public class 수영대회결승전4193 {
//
//	static class Player{
//		int x, y, dist;
//		public Player(int x, int y, int dist) {
//			this.x = x;
//			this.y = y;
//			this.dist = dist;
//		}
//	}
//	
//	static int ans, N;
//	static int [][] mat;
//	static boolean[][] visit;
//	static int[] dx = {-1, 0, 1, 0};
//	static int[] dy = {0, 1, 0, -1};
//	static int startX, startY, targetX, targetY;
//
//	
//	private static int solve() {
//		Queue<Player> q = new LinkedList<>();
//		q.add(new Player(startX, startY, 0));
//		visit[startX][startY] = true;
//		
//		while(!q.isEmpty()) {
//			Player player = q.poll();
//			
//			if(player.x == targetX && player.y == targetY) {
//				return player.dist;
//			}
//			
//			for (int i = 0; i < 4; i++) {
//				int xx = player.x + dx[i];
//				int yy = player.y + dy[i];
//				
//				if(xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
//				if(mat[xx][yy] == 1 || visit[xx][yy]) continue;
//				
//				if(mat[xx][yy] == 0) {
//					visit[xx][yy] = true;
//					q.add(new Player(xx, yy, player.dist + 1));					
//				}
//				else if(mat[xx][yy] == 2) {  
//					if(player.dist % 3 == 2) {
//						visit[xx][yy] = true;
//						q.add(new Player(xx, yy, player.dist + 1));
//					}else {
//						q.add(new Player(player.x, player.y, player.dist + 1));
//					}					
//				}
//			}
//		}
//		return -1;
//	}
//
//
//	
//	public static void main(String[] args) throws FileNotFoundException {
//		
//		System.setIn(new FileInputStream("수영대회결승전4193input.txt"));
//        Scanner sc = new Scanner(System.in);
//        
//    	int TC = sc.nextInt();
//    	
//        for(int tc = 1; tc <= TC; tc++) {
//
//			N = sc.nextInt(); 
//
//			mat = new int [N][N];
//			visit = new boolean[N][N];
//			
//    		for (int i = 0; i < N; i++)
//    			for (int j = 0; j < N; j++)
//    				mat[i][j] = sc.nextInt();
//    		
//    		startX = sc.nextInt();
//			startY = sc.nextInt();
//			targetX = sc.nextInt();
//			targetY = sc.nextInt();
//			
//    		System.out.printf("#%d %d\n", tc, solve());
//	    }
//        sc.close();
//	}
//}






import java.io.*;
import java.util.*;

//public class Solution {
public class 수영대회결승전4193 {

	static class XYwithDist{
		int x, y, dist;
		public XYwithDist(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	static int ans, N;
	static int [][] mat;
	static boolean[][] visit;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int startX, startY, targetX, targetY;

	static Comparator<XYwithDist> comparator = new Comparator<XYwithDist>() {
		@Override
		public int compare(XYwithDist o1, XYwithDist o2) {
			return o1.dist - o2.dist;
		}
	};
	
	public static boolean isMoveable(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= N) return false;
		if(mat[x][y] == 1 || visit[x][y]) return false;
		
		return true;
	}
	
	public static int solvePQ() {
		PriorityQueue<XYwithDist> pq = new PriorityQueue<>(comparator);
		pq.add(new XYwithDist(startX, startY, 0));
		visit[startX][startY] = true;
		
		while(!pq.isEmpty()) {
			XYwithDist curxywith_min_dist = pq.poll();
			
			if(curxywith_min_dist.x == targetX && curxywith_min_dist.y == targetY) 
				return curxywith_min_dist.dist;
			
			for (int i = 0; i < 4; i++) {
				int xx = curxywith_min_dist.x + dx[i];
				int yy = curxywith_min_dist.y + dy[i];
				
				if(!isMoveable(xx, yy)) continue;
				
				int dist;
				
				if(mat[xx][yy] == 0) dist = curxywith_min_dist.dist + 1;
				else dist = ((curxywith_min_dist.dist + 3)/3)*3;

				pq.add(new XYwithDist(xx, yy, dist));

				visit[xx][yy] = true;
			}
		}
		return -1;
	}


	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("수영대회결승전4193input.txt"));
        Scanner sc = new Scanner(System.in);
        
    	int TC = sc.nextInt();
    	
        for(int tc = 1; tc <= TC; tc++) {

			N = sc.nextInt(); 

			mat = new int [N][N];
			visit = new boolean[N][N];
			
    		for (int i = 0; i < N; i++)
    			for (int j = 0; j < N; j++)
    				mat[i][j] = sc.nextInt();
    		
    		startX = sc.nextInt();
			startY = sc.nextInt();
			targetX = sc.nextInt();
			targetY = sc.nextInt();
			
    		System.out.printf("#%d %d\n", tc, solvePQ() );
	    }
        sc.close();
	}
}







