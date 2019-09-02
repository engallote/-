import java.util.*;

public class Main {
	static int MOD = 20170805;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] city_map = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(3, 3, city_map));
	}
	public static int solution(int m, int n, int[][] city_map) {
		int answer = 0;
		int[][] dp1 = new int[m+1][n+1], dp2 = new int[m+1][n+1], arr = new int[m+1][n+1];
		dp1[1][1] = dp2[1][1] = 1;
		
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++)
				arr[i][j] = city_map[i-1][j-1];
		
		for(int i = 1; i <= m; i++)
			for(int j = 1; j <= n; j++)
			{
				if(i == 1 && j == 1) continue;
				if(arr[i][j] == 0)
				{
					dp1[i][j] = (dp1[i-1][j] + dp2[i][j-1]) % MOD;
					dp2[i][j] = (dp1[i-1][j] + dp2[i][j-1]) % MOD;
				}
				else if(arr[i][j] == 2)
				{
					dp1[i][j] = dp1[i-1][j];
					dp2[i][j] = dp2[i][j-1];
				}
			}
		answer = dp2[m][n];
		return answer;
	}
}