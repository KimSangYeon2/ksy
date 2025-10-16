import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p24042_횡단보도 {

	static int N, M;
	static ArrayList<CrossWalk>[] fromto;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		fromto = new ArrayList[N + 1];
		for(int n = 1; n <= N; n++) {
			fromto[n] = new ArrayList<>();
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			fromto[a].add(new CrossWalk(b, 0, m % M));
			fromto[b].add(new CrossWalk(a, 0, m % M));
		}
		
		dijkstra();
		System.out.println(ans);
	}
	
	//time % M == 1 + i 일 때 시간에만 신호등을 건널 수 있음
	//q에 다음 crosswalk상태 넣을 때 time에 다음 주기까지 남은 시간을 더한다.
	
	static void dijkstra() {
		PriorityQueue<CrossWalk> pq = new PriorityQueue<>();
		pq.offer(new CrossWalk(1, 0, 0));
		
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;
		
		while(!pq.isEmpty()) {
			CrossWalk cur = pq.poll();
			int from = cur.to;
			long curT = cur.time;
			
			if(curT > dist[from]) continue;
			if(from == N) break;
			
			for(CrossWalk c : fromto[from]) {
				long nextT = curT + (c.cTime - curT % (long) M + M) % M + 1;
				int to = c.to;
				if(nextT >= dist[to]) continue;
				dist[to] = nextT;
				pq.offer(new CrossWalk(to, nextT, 0));
			}
		}
		
		ans = dist[N];
	}
	
	static class CrossWalk implements Comparable<CrossWalk> {
		int to, cTime;
		long time;
		
		public CrossWalk(int to, long time, int cTime) {
			this.to = to;
			this.time = time;
			this.cTime = cTime;
		}
		
		@Override
		public int compareTo(CrossWalk o) {
			return Long.compare(this.time, o.time);
		}
	}
}
