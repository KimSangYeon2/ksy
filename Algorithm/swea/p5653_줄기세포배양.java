package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class p5653_줄기세포배양 {
 
    static int N, M, K;
    static Cell[][] cells;
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static Queue<Cell> queue, newQueue;
 
    static class Cell {
        int y, x, life, timer;//0이면 사망 life랑 같으면 활성
        Cell (int y, int x, int life, int timer){
            this.y = y;
            this.x = x;
            this.life = life;
            this.timer = timer;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
 
            cells = new Cell[N + 2 * K][M + 2 * K];
            queue = new ArrayDeque<>();
            
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                	int life = Integer.parseInt(st.nextToken());
                	if(life != 0) {
                		Cell c = new Cell(y + K, x + K, life, 2 * life);
                		cells[y + K][x + K] = c;
                		queue.offer(c);
                	}
                }
            }
             
            bfs();
            
            sb.append("#").append(t).append(" ").append(queue.size()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
 
    static void bfs() {
    	for (int k = 0; k < K; k++) {
    		newQueue = new ArrayDeque<>();
    		int cellsNum = queue.size();
    		for(int n = 0; n < cellsNum; n++) {
    			Cell c = queue.poll();
    			if (c.timer == c.life) { //활성
    				for (int i = 0; i < 4; i++) {
    					int ny = c.y + dy[i]; int nx = c.x + dx[i];
    					Cell nc = new Cell(ny, nx, c.life, 2 * c.life);
    					if (cells[ny][nx] == null) {
    						cells[ny][nx] = nc;
    						newQueue.offer(nc);
    					} else if (cells[ny][nx].timer == 2 * cells[ny][nx].life && 
    							cells[ny][nx].life < c.life) { //값 갱신
    						cells[ny][nx] = nc;
    					}
    				}
    			} 
    			c.timer--;
    			if (c.timer > 0) queue.offer(c);//살아있으면 다시 추가
    		}
    		queue.addAll(newQueue);
    	}
    }
}