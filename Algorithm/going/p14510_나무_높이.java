package going;
//swea
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14510_나무_높이 {
	
	static int N, maxHeight;
	static int[] trees;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			trees = new int[N];
			maxHeight = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				trees[n] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, trees[n]);
			}
			sb.append("#").append(t).append(" ").append(result()).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static int result() {
		int date = 0;
		int oddNum = 0;
		int evenNum = 0;
		
		for(int n = 0; n < N; n++) {
			int dif = maxHeight - trees[n];
			if(dif == 0) continue;
			evenNum += dif / 2;
			oddNum += dif % 2;
		}
		
		if (evenNum > oddNum)
		    while (Math.abs(evenNum - oddNum) > 1) {
		        evenNum--;
		        oddNum += 2;
		    }
		
		if(oddNum > evenNum) date = oddNum * 2 - 1;
		else if(evenNum > oddNum) date = evenNum * 2;
		else date = oddNum + evenNum;
		
		return date;
	}
}
