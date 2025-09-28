package practice.algorithm_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1226_미로1 {

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	static int size = 16;
	static char[][] maze;
	static int[][] visited;//0방문x, 1방문, 2벽 
	static Queue<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		for(int tc = 0; tc < 10; tc++) {
			
			maze = new char[size][size];
			visited = new int[size][size];
			
			int sx = 0; int sy = 0; //출발점
			int ex = 0; int ey = 0; //도착점
			
			String tcN = br.readLine();
			for(int y = 0; y < size; y++) {
				char[] in = br.readLine().toCharArray();
				for(int x = 0; x < size; x++) {
					maze[y][x] = in[x];
					if(maze[y][x] == '1') visited[y][x] = 2; 
					if(maze[y][x] == '2') { sx = x; sy = y; }
					if(maze[y][x] == '3') { ex = x; ey = y; }
				}
			}
			
			bfs(sy, sx);
			if(visited[ey][ex] == 1) System.out.println("#" + tcN + " 1");
			else System.out.println("#" + tcN + " 0");
		}
	}
	
	static void bfs(int y, int x) { //bfs
		visited[y][x] = 1;//방문처리
		queue = new LinkedList<int[]>();
		queue.offer(new int[] {y, x});
		while (!queue.isEmpty()) { //재귀처리 x 방문 가능한 곳 없을 때 까지
			int[] cur = queue.poll();
			int sy = cur[0];
			int sx = cur[1];
			for (int i = 0; i < 4; i++) {
				int ny = sy + dy[i];
				int nx = sx + dx[i];
				if (!isWall(ny, nx) && visited[ny][nx] == 0) {//벽이 아니고 방문하지 않았다면
					queue.offer(new int[]{ny, nx});
					visited[ny][nx] = 1;
				}
			}
		}
	}
	
	static boolean isWall(int y, int x) {
		if(x < 0 || x > size - 1 || y < 0 || y > size - 1) return true;
		return false;
	}
}
//참고코드
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Stack;
// 
// 
//public class Solution {
//     
//    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         
//        int[] dy = {0,0,1,-1};
//        int[] dx = {1,-1,0,0};
//         
//        for(int test_case = 1; test_case <= 10; test_case++)
//        {
//             
//            int T = Integer.parseInt(br.readLine());
//             
//             
//            Cell[][] maze = new Cell[16][16];
//            for(int i = 0; i < 16; i++) {
//                String s = br.readLine();
//                for(int j = 0; j < 16; j++) {
//                    maze[i][j] = new Cell(i,j, Integer.parseInt(String.valueOf(s.charAt(j)) ));
//                }
//            }
//             
//            Queue<Cell> q = new LinkedList<>();
//            q.add(maze[1][1]);
//            maze[1][1].val = 1;
//             
//            int ans = 0;
//            outer:while(!q.isEmpty()) {
//                 
//                Cell curCell = q.poll();
////              System.out.println("current cell: ( r=" + curCell.r + ", c=" + curCell.c + ") ");
//                 
//                 
//                for(int i = 0; i<4; i++) {
//                    int nextR = curCell.r + dy[i];
//                    int nextC = curCell.c + dx[i];
//                    if (isValid(nextR,nextC)) {
//                        Cell nextCell = maze[nextR][nextC];
//                        if ( nextCell.val == 0) {q.add(nextCell); nextCell.val = 1;}
//                        else if (nextCell.val == 3) {ans = 1; break outer;}
//                    }
//                }
//                 
//                 
//            }
//     
//             
// 
//            System.out.println("#" + test_case + " " + ans);
//             
//        }           
// 
//         
//         
//    }
//     
//    static boolean isValid(int r, int c) {
//        return r >= 0 && r < 16 && c >= 0 && c < 16;
//    }
//     
//     
//    private static class Cell {
//        int r;
//        int c;
//        int val;
//         
//        Cell(int r, int c, int val) {
//            this.r = r; this.c = c;
//            this.val = val;
//        }
//    }
//}

//import java.util.Scanner;
//import java.io.FileInputStream;
// 
///*
//   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
//   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
// */
//class Solution
//{
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static int[][] arr;
//    static boolean[][] visited;
//     
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = 10;
//         
//        for(int tc = 1; tc <= T; tc++) {
//            sc.nextInt();
//            arr = new int[16][16]; // 1은 벽, 0은 길
//            int[] start = new int[2];
//            int[] end = new int[2];
//            visited = new boolean[16][16];
//             
//            for(int i = 0; i < 16; i++) {
//                String s = sc.next();
//                for(int j = 0; j < 16; j++) {
//                    arr[i][j] = s.charAt(j) - '0';
//                     
//                    if(arr[i][j] == 2) {
//                        start[0] = i;
//                        start[1] = j;
//                    }
//                     
//                    if(arr[i][j] == 3) {
//                        end[0] = i;
//                        end[1] = j;
//                    }
//                }
//            }
//             
//            if(dfs(start[1], start[0], end[1], end[0])) {
//                System.out.println("#" + tc + " 1");
//            }
//            else {
//                System.out.println("#" + tc + " 0");
//            }
//             
//        }
//    }
//     
//    static boolean dfs(int x, int y, int endX, int endY) {
//        if(x == endX && y == endY) return true;
//         
//        visited[x][y] = true;
//         
//        for(int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//             
//            if(isValid(nx, ny)) {
//                if(dfs(nx, ny, endX, endY)) {
//                    return true;
//                }
//            }
//        }
//         
//        return false;
//    }
//     
//    static boolean isValid(int x, int y) {
//        return (x >= 0 && x < 16 && y >= 0 && y < 16) 
//                && (arr[x][y] == 0 || arr[x][y] == 3) 
//                && !visited[x][y];
//    }
//}