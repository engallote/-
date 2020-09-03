import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < i + 1; j++)
				arr[i][j] = sc.nextInt();
		
		System.out.println(solution(arr));
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		int N = triangle.length;
		int[][] dp = new int[N][N];
		
		dp[0][0] = triangle[0][0];
		
		for(int i = 1; i < N; i++){
			for(int j = 0; j <= i; j++){
				dp[i][j] = Math.max(dp[i-1][j] + triangle[i][j], dp[i][j]);
				if(j - 1 >= 0) dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i][j]);
			}
		}
		
		for(int i = 0; i < N; i++)
			answer = Math.max(answer, dp[N-1][i]);
		return answer;
	}
}