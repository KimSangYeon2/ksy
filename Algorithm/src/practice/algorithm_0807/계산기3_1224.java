package practice.algorithm_0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계산기3_1224 {

	static char[] f; // 식 입력받는 곳

	static char[] cal; // 후위식 stack
	static int cTop;
	
	static char[] op; // 연산자  stack
	static int oTop;

	static int[] nums; // 계산용 숫자 stack
	static int nTop;
	
	static int isp(char in) {//들어갈 때 우선순위
		switch (in) {
		case '(': return 0;
		case '*': case '/': return 2;
		case '+': case '-': return 1;
		}
		return -1;
	}

	static int icp(char in) {//쌓을 때 우선순위
		switch (in) {
		case '(': return 3;
		case '*': case '/': return 2;
		case '+': case '-': return 1;
		}
		return -1;
	}
	
	static char[] postfix(char in[]) {
		cTop = -1;
		oTop = -1;
		cal = new char[in.length];
		op = new char[in.length];
		for(int i = 0; i < in.length; i++) {
			switch (in[i]) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6'
			: case'7': case '8': case '9':
				cal[++cTop] = in[i];
				break;
			case '(' :
				op[++oTop] = in[i];
				break;
			case ')' :
				while(oTop != -1 && op[oTop] != '(') {
					cal[++cTop] = op[oTop--];
				}
				oTop--;
				break;
//			case '+': case '-': case '*': case '/' :
//				if (icp(in[i]) > isp(op[oTop]) && oTop != -1) {//icp가 isp보다 높으면 연산자 스택에 push
//					op[++oTop] = in[i];
//				} else {//같거나 작으면 연산자 스택에서 pop하고 계산 스택에 추가
//					cal[++cTop] = op[oTop];
//					op[oTop] = in[i];
//				}
//				break;
//			}
				//gpt가 보완해준 부분
			case '+': case '-': case '*': case '/':
	            while (oTop != -1 && icp(in[i]) <= isp(op[oTop])) {
	                cal[++cTop] = op[oTop--];
	            }
	            op[++oTop] = in[i];
	            break;
	        }
		}
		while (oTop != -1) { //남은 연산자 처리
		    cal[++cTop] = op[oTop--];
		}
		return cal;
	}

	static int calculate(char[] in) {
		nTop = -1;
		nums = new int[in.length];
		for(int i = 0; i < in.length; i++) {
			switch (in[i]) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6'
			: case'7': case '8': case '9':
				nums[++nTop] = in[i] - 48;
				break;
			case '+' :
				nums[nTop - 1] = nums[nTop - 1] + nums[nTop];
				--nTop;
				break;
			case '-' :
				nums[nTop - 1] = nums[nTop - 1] - nums[nTop];
				--nTop;
				break;
			case '*' :
				nums[nTop - 1] = nums[nTop - 1] * nums[nTop];
				--nTop;
				break;
			case '/' :
				nums[nTop - 1] = nums[nTop - 1] / nums[nTop];
				--nTop;
				break;
			default:
				break;
			}
		}
		return nums[0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			f = br.readLine().toCharArray();
			System.out.println("#" + tc + " " + calculate(postfix(f)));
		}
		br.close();
	}
}
