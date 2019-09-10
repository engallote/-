import java.util.*;

public class Main {
	static int N;
	static boolean[] chk;
	static int[][] com;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		chk = new boolean[N];
		com = new int[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				com[i][j] = sc.nextInt();
		
		int res = solve(N);
		System.out.println(res);
	}
	private static int solve(int n) {
		int ans = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; i++)
		{
			if(chk[i]) continue;
			ans++;
			q.offer(i);
			while(!q.isEmpty())
			{
				int x = q.poll();
				
				for(int j = 0; j < N; j++)
					if(x != j && !chk[j] && com[x][j] == 1)
					{
						chk[j] = true;
						q.offer(j);
					}
			}
		}
		
		return ans;
	}
}