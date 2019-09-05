import java.util.*;

public class Main {
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] edge_list = {{1,2},{1,3},{2,3},{2,4},{3,4},{3,5},{4,6},{5,6},{5,7},{6,7}};
		int[] gps_log = {1,2,3,3,6,7};
		System.out.println(solution(7, 10, edge_list, 6, gps_log));
	}
	public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log){
		int answer = -1;
		arr = new ArrayList[n+1];
		int[][][] chk = new int[n+1][n+1][k+1];
		
		for(int i = 1; i <= n; i++)
		{
			arr[i] = new ArrayList<>();
			for(int j = 0; j <= n; j++)
				Arrays.fill(chk[i][j], 10000000);
		}
		
		for(int i = 0; i < m; i++)
		{
			arr[edge_list[i][0]].add(edge_list[i][1]);
			arr[edge_list[i][1]].add(edge_list[i][0]);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(gps_log[0], 1, 0));
		chk[gps_log[0]][gps_log[0]][0] = 0;
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
//			System.out.println(p.time + " : " + p.x + ", " + p.cnt);
			if(p.time == k)
			{
				if(p.x == gps_log[k-1])
				{
					answer = p.cnt;
					break;
				}
				else continue;
			}
			
			if(gps_log[p.time] == p.x && chk[p.x][p.x][p.time] > p.cnt)
			{
				chk[p.x][p.x][p.time] = p.cnt;
				pq.offer(new Pair(p.x, p.time + 1, p.cnt));
			}
			else if(chk[p.x][p.x][p.time] > p.cnt + 1)
			{
				chk[p.x][p.x][p.time] = p.cnt + 1;
				pq.offer(new Pair(p.x, p.time + 1, p.cnt + 1));
			}
			for(int next : arr[p.x]){
				if(gps_log[p.time] == next && chk[p.x][next][p.time] > p.cnt) 
				{
					chk[p.x][next][p.time] = p.cnt;
					pq.offer(new Pair(next, p.time + 1, p.cnt));
				}
				else if(chk[p.x][next][p.time] > p.cnt + 1)
				{
					chk[p.x][next][p.time] = p.cnt + 1;
					pq.offer(new Pair(next, p.time + 1, p.cnt + 1));
				}
			}
		}
		
		return answer;
	}
}
class Pair implements Comparable<Pair>{
	int x, time, cnt;
	Pair(int x, int time, int cnt){
		this.x = x;
		this.time = time;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}