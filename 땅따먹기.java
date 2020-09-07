import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
		
		System.out.println(solution(land));
	}
	public static int solution(int[][] land) {
		int answer = 0;
		int N = land.length, M = 4;
		int[][] dp = new int[N][M];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				if(i - 1 >= 0){
					for(int k = 0; k < M; k++)
						if(k != j) dp[i][j] = Math.max(dp[i-1][k], dp[i][j]);
					dp[i][j] += land[i][j];
					answer = Math.max(answer, dp[i][j]);
				}
				else dp[i][j] = land[i][j];
			}
		}
		
		return answer;
	}
}