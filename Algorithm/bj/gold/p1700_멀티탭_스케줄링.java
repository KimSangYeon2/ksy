package going;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1700_멀티탭_스케줄링 {

	private static int N, K;
	private static int[] todo = new int[101];
	private static HashSet<Integer> multi;
	private static HashMap<Integer, Integer> count;
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		todo = new int[K + 1];
		multi = new HashSet<Integer>();
		count = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int k = 1; k <= K; k++) {
			int in = Integer.parseInt(st.nextToken());
			todo[k] = in;
		}		
		
		br.close();
	}
	
	static void solution() {
		int cnt = 0;
		for(int k = 1; k <= K; k++) {
			
			int td = todo[k];
			
			if (multi.size() < N) {
	            multi.add(td);
	            continue;
	        }
			
			if(multi.contains(td)) continue; //이미 있으면 CONTINUE;
			
			//앞에서부터 탐색 후 가장 나중에 나오는거 or 안나오는거 뽑기
			int remove = -1;
			int last = -1;
			for (int p : multi) {
                int next = Integer.MAX_VALUE;
                for (int j = k + 1; j <= K; j++) {
                    if (todo[j] == p) {
                        next = j;
                        break;
                    }
                }

                if (next > last) {
                    last = next;
                    remove = p;
                }
            }

            multi.remove(remove);
            multi.add(td);
            cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		init();
		solution();
	}
}