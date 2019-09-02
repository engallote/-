import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	public static int solution(int[][] maps) {
		int answer = -1;
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		int N = maps.length, M = maps[0].length;
		int[][] chk = new int[N][M];
		
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0, 1));
		chk[0][0] = 0;
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			if(p.x == N - 1 && p.y == M - 1)
			{
				answer = p.cnt;
				break;
			}
			
			for(int i = 0; i < 4; i++)
			{
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || maps[nx][ny] == 0 || chk[nx][ny] <= p.cnt + 1)
					continue;
				chk[nx][ny] = p.cnt + 1;
				pq.offer(new Pair(nx, ny, p.cnt + 1));
			}
		}
		return answer;
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : 1;
	}
}