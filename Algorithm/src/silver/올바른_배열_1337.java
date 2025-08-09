package silver;

import java.io.*;
import java.util.*;
 
public class 올바른_배열_1337 {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      //중복 제거를 위해 hashset으로 받기
      Set<Integer> input = new HashSet<>();
      for(int i = 0; i < N; i++) {
    	  input.add(Integer.parseInt(br.readLine()));
      }
      
      //정렬을 위해 list에 hashset 담고 정렬
      List<Integer> nums = new ArrayList<Integer>(input);
      Collections.sort(nums);
      
      //+4 범위 안에 몇개의 숫자가 있는지 탐색, count 저장
      //count 값 중 최대값 찾기
      int count = 0;
      for(int i = 0; i < nums.size(); i++) {
    	  int newCount = 0;
    	  for (int j = 1; j < nums.size() - i; j++) {
    		  if (nums.get(i + j) <= nums.get(i) + 4)
    			  newCount++;
    	  }
    	  if (newCount > count)
    		  count = newCount;
      }
      
      System.out.println(4 - count);
      br.close();
   }
}