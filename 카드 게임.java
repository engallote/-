import java.util.*;

public class Main {
	static int[][] dp = new int[2001][2001];
	static int llen = 0, rlen = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] left = new int[3], right = new int[3];
		for(int i = 0; i < 3; i++)
			left[i] = sc.nextInt();
		for(int i = 0; i < 3; i++)
			right[i] = sc.nextInt();
		
		System.out.println(solution(left, right));
	}
	private static int solution(int[] left, int[] right) {
		int ans = 0;
		
		for(int i = 0; i <= 2000; i++) Arrays.fill(dp[i], -1);
		
		llen = left.length;
		rlen = right.length;
		ans = solve(0, 0, left, right);
		return ans;
	}
	private static int solve(int l, int r, int[] left, int[] right) {
		if(l == llen || r == rlen) return 0;
		if(dp[l][r] != -1) return dp[l][r];
		int ret = 0;
		if(left[l] > right[r]) ret = Math.max(ret, solve(l, r + 1, left, right) + right[r]);
		ret = Math.max(ret, solve(l + 1, r + 1, left, right));
		ret = Math.max(ret, solve(l + 1, r, left, right));
		
		return dp[l][r] = ret;
	}
}