package bj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1931_회의실배정 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[n][0] = Integer.parseInt(st.nextToken());
			time[n][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {//종료시간 같으면 시작시간 빠른 순
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1]; //종료시간 빠른 순
			}
			
		});
		
		int cnt = 0;
		int prev = 0;
		for(int n = 0; n < N; n++) {
			if(prev <= time[n][0]) { //종료시간이 다음 시간보다 작거나 같으면
				prev = time[n][1];//갱신
				cnt++;
			}
		}
		
		bw.write( cnt + "\n" );
		bw.flush();
		br.close();
		bw.close();
	}
}
