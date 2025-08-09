package algorithm_0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact_1238 {

	static boolean[] visited = new boolean[101];
	static ArrayList<Integer>[] process; // node들의 연결 담을 list
	static Queue<Integer> queue;// node 이동 담을 queue, 오름차순으로 들어감

	static int bfs(int in) {
		int last = in;
		visited[in] = true;
		queue = new LinkedList<Integer>();
		queue.offer(in); // nodeList 삽입
		while (!queue.isEmpty()) {
			int max = 0;
			int n = queue.size();
			int[] node = new int[n];
			for (int i = 0; i < n; i++) {
				node[i] = queue.poll();
				if (node[i] > max) max = node[i];//마지막 node 최댓값 갱신
				for (int nextNode : process[node[i]]) {
					if (!visited[nextNode]) {//방문 가능한 경우
						queue.offer(nextNode);//queue에 node 추가
						visited[nextNode] = true;//방문 후 true
					}
				}
			}
			last = max;
		}
		return last;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 10;

		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer std = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			// 배열 초기화
			visited = new boolean[101];
			process = new ArrayList[101];
			for (int n = 1; n <= 100; n++) {
				process[n] = new ArrayList<>();
			}

			for (int n = 1; n <= N / 2; n++) {
				process[Integer.parseInt(std.nextToken())].add(Integer.parseInt(std.nextToken()));
			}

			System.out.println("#" + i + " " + bfs(start));
		}
		br.close();
	}
}
// 시작지점부터 연결된 node 탐색
// 연결된 node 중에서 바로 이동 가능하면 list로 queue에 들어감
// 들어온 node queue 빌 때 까지 poll 하면서 poll하면서 가져온 list에 있는 node에서 탐색 가능한 node queue에 들어감
// 연락 더 이상 받을 수 없을 때 queue getlast() 하면 정답 탐색 가능