package 기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2025_상반기_오후_2번_여왕_개미 {

	static int[] house = new int[20001];
	static int last = 1_000_000_000;
	static int idx = 0; //0은 여왕 집
	//Main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		for(int q = 0; q < Q; q++) {
			order(br.readLine());
		}
	}

	//order
	static void order(String in) {
		StringTokenizer st = new StringTokenizer(in);
		int orderNum = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		switch (orderNum) {
		case 100 :
			for(int n = 1; n <= num; n++) 
				add(Integer.parseInt(st.nextToken()));
			break;
		case 200 :
			add(num);
			break;
		case 300 :
			remove(num);
			break;
		case 400 :
			recon(0, last, num);
			break;
		default : 
			break;
		}
	}
	
	//100 집 건설
	//200 집 추가
	static void add(int add) {
		house[++idx] = add;
	}
	//300 집 제거
	static void remove(int del) {
		house[del] = -1;
	}
	
	//400
	static void recon(int start, int end, int ants) {
		//start ~ end 이진탐색 돌리면서 개미 배치하기 -> 배치 가능하면 loop 끊고 return
		int ans = end;
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(isAble(mid, ants)) {
				ans = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}
	
	//개미 배치하면서 확인하기
	static boolean isAble(int d, int ants) {
		
		//1 ~ 2까지
		int start = 1;
		int end = 2;
		
		//개미 수
		int cnt = 1;
		
		while(end <= idx) {
			if(house[start] == -1) {
				start++;
				end++;
				continue;
			}
			if(house[end] == 0) { //끝이면 break
				break;
			}
			if(house[end] == -1) { //삭제 skip
				end++;
				continue;
			}
			if(house[end] - house[start] > d) {
				start = end;
				cnt++;
			}
			end++;
		}
		
		return cnt <= ants;
	}
}
