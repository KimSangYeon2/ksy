package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class p3190_뱀 {

	static int N, K, L;
	static int dir, time = 0;
	static boolean isEnd = false;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static Deque<Pos> snake = new ArrayDeque<>();
	static HashSet<Pos> apple = new HashSet<>();
	static HashMap<Integer, Character> direction = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < K; n++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			apple.add(new Pos(y, x));
		}
		
		L = Integer.parseInt(br.readLine());
		for(int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			direction.put(t, d);
		}
		
		snake.offer(new Pos(1, 1));
		
		while(true) {
			simulate();
			if(isEnd) break;
		}
		
		System.out.println(time);
		br.close();
	}

	static void simulate() {
		time++;
		Pos cur = snake.peekFirst();
		int ny = cur.y + dy[dir];
		int nx = cur.x + dx[dir];
		Pos head = new Pos(ny, nx);
		
		checkEnd(head);
		
		//머리 이동, 사과 있으면 늘리고 없으면 꼬리 제거
		snake.offerFirst(head);
		if(!apple.contains(head)) snake.pollLast();
		else apple.remove(head);
		
		//시간체크
		if(direction.containsKey(time)) dir(direction.get(time));
	}
	
	static void checkEnd(Pos head) {
		if(!inRange(head)) isEnd = true;
		if(snake.contains(head)) isEnd = true;
	}
	
	static void dir(char d) {
		if(d == 'D') dir = (dir + 1) % 4;
		else dir = (dir + 3) % 4;
	}
	
	static boolean inRange(Pos p) {
		int y = p.y; int x = p.x;
		return y >= 1 && y <= N && x >= 1 && x <= N;
	}
	
	static class Pos{
		
		int y, x;
		
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(!(o instanceof Pos)) return false;
			Pos pos = (Pos) o;
			return y == pos.y && x == pos.x;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(y, x);
		}
	}
}
