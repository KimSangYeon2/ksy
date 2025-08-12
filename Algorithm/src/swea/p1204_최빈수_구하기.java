package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1204_최빈수_구하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int students = 1000;
		int[] grades = new int[students];
		int[] mFreqNum = new int[N];
		// N가지 case
		for (int i = 0; i < N; i++) {

			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());

			// grades 학생 수 만큼 입력받기
			for (int j = 0; j < students; j++)
				grades[j] = Integer.parseInt(st.nextToken());

			// 최대값 갱신
			int max = 0;
			for (int j = 0; j < students; j++) {
				if (grades[j] >= max)
					max = grades[j];
			}

			// 각 성적을 index값으로 가지는 배열 count
			int[] freq = new int[max + 1];
			for (int j = 0; j < students; j++) {
				freq[grades[j]]++;
			}

			// 최대빈도수 구하기
			// 최대빈도수 갱신하면서 해당 index 숫자 return
			int mFreq = 0;
			for (int j = 0; j < freq.length; j++) {
				if (freq[j] >= mFreq) {
					mFreqNum[i] = j;
					mFreq = freq[j];
				}
			}

		}

		for (int i = 0; i < N; i++) {
			System.out.println("#" + (i + 1) + " " + mFreqNum[i]);
		}
		
		br.close();
	}

}
