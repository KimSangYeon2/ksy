package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p9205_맥주마시면서걸어가기 {

	static int N;
	static Place[] address;
	static Queue<Place> queue;
	static String state;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		ArrayList<int[]> q = new ArrayList<int[]>();
		for(int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());
			address = new Place[N + 2];
			for(int n = 0; n < N + 2; n++) address[n] = new Place( 0, 0, false );
			
			//집
			StringTokenizer st = new StringTokenizer(br.readLine());
			address[0].x = Integer.parseInt(st.nextToken()); address[0].y = Integer.parseInt(st.nextToken());
			
			//편의점
			for(int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				address[n].x = Integer.parseInt(st.nextToken()); address[n].y = Integer.parseInt(st.nextToken());
			}
			
			//페스티벌
			st = new StringTokenizer(br.readLine());
			address[N + 1].x = Integer.parseInt(st.nextToken()); address[N + 1].y = Integer.parseInt(st.nextToken());
			
			state = "sad";
			bfs();
			
			sb.append(state).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void bfs() {
		queue = new ArrayDeque<>();
		queue.offer(address[0]); //집 좌표, 거리
		while(!queue.isEmpty()) { //queue 빌 때 까지
			
			Place p = queue.poll();
			
			if(p.x == address[N + 1].x && p.y == address[N + 1].y) { //도착 하면 happy 하고 함수 종료
				state = "happy";
				return;
			}
			
			for(Place np : address) {
				if(np.visited) continue; //방문했으면 탐색 x
				if(distance(np, p) > 1000) continue; //거리 1000보다 멀면 탐색 x
				np.visited = true;
				queue.offer(np);
			}
		}
	}
	
	static int distance(Place p1, Place p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y); 
	}
	
	static class Place {
		int x, y;
		boolean visited;
		Place(int x, int y, boolean visited) {
			this.x = x;
			this.y = y;
			this.visited = visited;
		}
	}
}

//한박스 20개
//20m당 맥주 1병
//가는 길에 편의점
//가장 가까운 점이랑 매칭
//그 점에서 다시 출발 
//1000m 이내 node들을 queue에 넣음
//bfs 돌려서 도착점 오면 happy
//아니면 sad