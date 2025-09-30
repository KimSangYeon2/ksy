import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2110_공유기설치 {

	static int N, C, dist;
	static int[] house;
	static int last = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];
		for(int n = 0; n < N; n++) house[n] = Integer.parseInt(br.readLine());
		Arrays.sort(house);
		binarySearch(0, house[N - 1]);
		System.out.println(dist);
	}
	
	static void binarySearch(int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if(isAble(mid)) { //설치 가능하면 
				dist = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
	}
	
	static boolean isAble(int d) {//d이상으로 C개 배치 가능하면
		int start = 0;
		int end = 1;
		int cnt = 1;
		while(end < N) {
			if(house[end] - house[start] >= d) {
				start = end;
				cnt++;
			}
			end++; //d보다 길어질 때 까지
		}
		return cnt >= C;
	}
}
