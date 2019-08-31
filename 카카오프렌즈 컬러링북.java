import java.util.*;

public class Main {
	static int N, M, count;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		System.out.println(solution(6, 4, picture));
	}
	public static int[] solution(int n, int m, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      N = n;
	      M = m;
	      chk = new boolean[N][M];
	      
	      HashMap<Integer, Integer> cnt = new HashMap<>(), size = new HashMap<>();
	      for(int i = 0; i < N; i++)
	    	  for(int j = 0; j < M; j++)
	    		  if(picture[i][j] != 0 && !chk[i][j])
	    		  {
	    			  numberOfArea++;
	    			  count = 0;
	    			  dfs(i, j, picture[i][j], picture);
	    			  maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
	    		  }
	      
//	      System.out.println(numberOfArea + " " + maxSizeOfOneArea);
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	}
	private static void dfs(int x, int y, int num, int[][] picture) {
		count++;
		chk[x][y] = true;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || picture[nx][ny] != num)
				continue;
			dfs(nx, ny, num, picture);
		}
	}
}