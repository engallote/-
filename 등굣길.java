import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] puddles = {{2,2}};
		System.out.println(solution(4, 3, puddles));
	}
	public static int solution(int m, int n, int[][] puddles) {
		int ans = 0;
		int mod = 1000000007;
		int [][] chk = new int[n][m];

		for(int i = 0; i < puddles.length; i++)
			chk[puddles[i][1]-1][puddles[i][0]-1] = -1;
		
		chk[0][0] = 1;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
			{
				if(chk[i][j] == -1 || (i == 0 && j == 0)) continue;
				if(i - 1 >= 0 && chk[i-1][j] != -1) 
					chk[i][j] += chk[i-1][j] % mod;
				if(j - 1 >= 0 && chk[i][j-1] != -1)
					chk[i][j] += chk[i][j-1] % mod;
				chk[i][j] %= mod;
			}
		
		ans = chk[n-1][m-1] % mod;
		return ans;
	}
}