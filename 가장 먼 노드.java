import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] edge = new int[7][2];
		for(int i = 0; i < 7; i++)
			for(int j = 0; j < 2; j++)
				edge[i][j] = sc.nextInt();
		
		System.out.println(solution(N, edge));
	}
	private static int solution(int n, int[][] edge) {
		int ans = 0;
		ArrayList<Integer>[] arr = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) arr[i] = new ArrayList<>();
		
		for(int i = 0; i < edge.length; i++)
		{
			arr[edge[i][0]].add(edge[i][1]);
			arr[edge[i][1]].add(edge[i][0]);
		}
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		dist[1] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		int size = 0, max = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			
			while(size > 0)
			{
				int x = q.poll();
				
				for(int next : arr[x])
					if(dist[next] == -1)
					{
						dist[next] = dist[x] + 1;
						max = Math.max(dist[next], max);
						q.offer(next);
					}
				size--;
			}
		}
		
		for(int i = 2; i <= n; i++)
			if(max == dist[i]) ans++;
		
		return ans;
	}
}