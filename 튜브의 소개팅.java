import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] time_map = {{0,1,1,-1,2,4},{-1,7,2,1,5,7},{-1,1,-1,1,6,3},{-1,1,-1,-1,7,0}};
		System.out.println(solution(4,6,25,time_map));
	}
	public static int[] solution(int m, int n, int s, int[][] time_map){
		int moveDistance = 0;
	    int sumOfTalkTime = 0;
	    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	    long[][][] chk = new long[2501][m][n];
	    
	    for(int i = 0; i < 2501; i++)
	    	for(int j = 0; j < m; j++)
	    		Arrays.fill(chk[i][j], Long.MAX_VALUE);
	    	
	    Queue<Pair> q = new LinkedList<Pair>();
	    q.offer(new Pair(0, 0));
	    chk[0][0][0] = 0;
	    
	    int size = 0, time = 1;
	    while(!q.isEmpty())
	    {
	    	size = q.size();
	    	while(size > 0)
	    	{
	    		size--;
	    		Pair p = q.poll();
	    		
	    		for(int i = 0; i < 4; i++)
	    		{
	    			int nx = p.x + dx[i], ny = p.y + dy[i];
	    			if(nx < 0 || ny < 0 || nx >= m || ny >= n || time_map[nx][ny] == -1 || chk[time-1][p.x][p.y] + time_map[nx][ny] > s || chk[time][nx][ny] <= chk[time-1][p.x][p.y] + time_map[nx][ny]) 
	    				continue;
	    			chk[time][nx][ny] = chk[time-1][p.x][p.y] + time_map[nx][ny];
	    			q.offer(new Pair(nx, ny));
	    		}
	    	}
	    	if(chk[time][m-1][n-1] != Long.MAX_VALUE)
	    	{
	    		moveDistance = time;
	    		sumOfTalkTime = (int)chk[time][m-1][n-1];
	    		break;
	    	}
	    	time++;
	    }
	    
	    int[] answer = new int[2];
	    answer[0] = moveDistance;
	    answer[1] = sumOfTalkTime;
	      
//	    System.out.println(moveDistance + ", " + sumOfTalkTime);
	    return answer;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}