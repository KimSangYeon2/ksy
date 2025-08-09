package algorithm_0805;

public class practice_02 {
	
	public static void main(String[] args) {
	
		int arr[] = {-1, 3, -9, 6, 7, -6, 1, 5, 4, -2};
		int sum;
		int count = 0;
		
		for (int i = 0; i < (1 << 10); i++) {
			sum = 0;
			for (int j = 0; j < 10; j++)
				 if((i&(1<<j)) != 0) sum += arr[j]; 
			if (sum == 0) {
				System.out.printf("[ %d ]", ++count);
				for (int j = 0; j < 10; j++) {
					if((i&(1<<j)) != 0) {
						System.out.printf("%d ", arr[j]);
					}
				}
				System.out.println();
			}
		}
		
	}
}
