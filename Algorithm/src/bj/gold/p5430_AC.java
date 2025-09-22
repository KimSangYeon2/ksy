package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p5430_AC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			String err = "";
			boolean reverse = false;
			String AC = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			ArrayList<Integer> arr = new ArrayList<>();
			if (N > 0) {
				nums = nums.substring(1, nums.length() - 1);
				String[] numArr = nums.split(",");
				for (String num : numArr) {
                    arr.add((Integer.parseInt(num)));
                }
			}
			
			for(int n = 0; n < AC.length(); n++) {
				if(AC.charAt(n) == 'R') { 
					reverse = !reverse;
				}
				if(AC.charAt(n) == 'D') {
					if(arr.size() == 0) {
						err = "error";
						break;
					}
					else {
						if(!reverse) arr.remove(0);
						else arr.remove(arr.size() - 1);
					}
				}
			}
			
			StringBuilder ansSb = new StringBuilder();
			if(err == "") {
				ansSb.append("[");
				if(!reverse) {
					for(int n = 0; n < arr.size(); n++) {
						if(n == arr.size() - 1) ansSb.append(arr.get(n));
						else ansSb.append(arr.get(n)).append(",");
					}
				}
				else {
					for(int n = arr.size() - 1; n >= 0; n--) {
						if(n == 0) ansSb.append(arr.get(n));
						else ansSb.append(arr.get(n)).append(",");
					}
				}
				sb.append(ansSb).append("]\n");
			}
			else sb.append(err).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
