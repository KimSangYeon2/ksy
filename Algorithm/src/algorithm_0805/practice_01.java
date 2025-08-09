package algorithm_0805;

public class practice_01 {
	
	public static boolean isWall(int x, int y) {
		if (x < 0 || x >= 5 || y < 0 || y >= 5) return true;
		return false;
	}
	
	public static int calAbs(int a1, int a2) {
		return (a1 - a2) > 0 ? a1 - a2 : a2 - a1;
	}
	
	public static void main(String[] args) {
	
		int ary[][] = {
				{1, 1, 1, 1, 1},
				{1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1},
				{1, 0, 0, 0, 1},
				{1, 1, 1, 1, 1}};
		
		int dx[] = {0, 0, -1, 1};
		int dy[] = {-1, 1, 0, 0};
		int sum = 0;
		
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++) {
				int tsum = 0;
				for (int dir = 0; dir < 4; dir++){
					int newX, newY;
					newX = x + dx[dir];
					newY = y + dy[dir];
					if (!isWall(newX, newY))
						tsum += calAbs(ary[y][x], ary[newY][newX]);
				}
				sum += tsum;
			}
		}
		System.out.println(sum);
	}
}
