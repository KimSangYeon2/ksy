package 기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2025_상반기_오후_2번_여왕_개미 {

	static int[] house = new int[20001];
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
			add(Integer.parseInt(st.nextToken()));
			break;
		case 300 :
			remove(Integer.parseInt(st.nextToken()));
			break;
		case 400 :
			recon(Integer.parseInt(st.nextToken()));
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
	static void recon(int ants) {
		int t = (house[idx] - house[1]) / ants;
		
	}
}
