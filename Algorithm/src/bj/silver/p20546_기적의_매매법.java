package bj.silver;

import java.util.Scanner;

public class p20546_기적의_매매법 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int day = 14;
		
		int jh = m;
		int jhS = 0;
		int sm = m;
		int smS = 0;
		
		int[] price = new int[day];
		for (int i = 0; i < day; i++) {
			price[i] = sc.nextInt();
			
			//jh 돈이 가능하면 매수
			if(jh >= price[i]) {
				jhS += jh / price[i]; //주식수갱신
				jh = jh % price[i]; //매수
			}
			
			//sm 연속 3번 하락 매수, 연속 3번 상승 매입
			if(i >= 3 && price[i - 3] > price[i - 2] && price[i - 2] > price[i - 1]) {	//하락하면 매입
				smS += sm / price[i];
				sm = sm % price[i];
			} else if (i >= 3 && price[i - 3] < price[i - 2] && price[i - 2] < price[i - 1]) { //상승하면 매수
				sm += smS * price[i];
				smS = 0;
			}
			
		}
		
		jh += jhS * price[day - 1];
		sm += smS * price[day - 1];
		
		if (jh > sm) System.out.println("BNP");
		else if (jh < sm) System.out.println("TIMING");
		else System.out.println("SAMESAME");
	}

}
