import java.util.*;

public class Main {
	static Pair[][] arr = new Pair[7][2];
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	int[][] arr = {{3,0,0,2}, {0,0,1,0}, {0,1,0,0}, {2,0,0,3}};
    	solution(arr, 0, 1);
	}
    public static int solution(int[][] board, int r, int c) {
        int answer = 0, idx = 0;
        
        for(int i = 0; i < 4; i++)
        	for(int j = 0; j < 4; j++) {
        		if(board[i][j] != 0) {
        			if(arr[board[i][j]][0] == null) arr[board[i][j]][0] = new Pair(i, j);
        			else arr[board[i][j]][1] = new Pair(i, j);
        			idx = Math.max(idx, board[i][j]);
        		}
        	}
        
        ArrayList<Pair> path = new ArrayList<>();
        answer = dfs(0, idx, 0, path, r, c, board);
//        System.out.println(">> " + answer);
        
        return answer;
    }
	private static int dfs(int cnt, int idx, int chk, ArrayList<Pair> path, int r, int c, int[][] board) {
		if(cnt == idx) {
			int res = solve(path, r, c, board);
			return res;
		}
		
		int ret = 1000000000;
		for(int i = 1; i <= idx; i++)
			if((chk&(1<<i)) == 0) {
				path.add(new Pair(i, 0));
				path.add(new Pair(i, 1));
				ret = Math.min(ret, dfs(cnt + 1, idx, chk|(1<<i), path, r, c, board));
				path.remove(path.size() - 1);
				path.remove(path.size() - 1);
				
				path.add(new Pair(i, 1));
				path.add(new Pair(i, 0));
				ret = Math.min(ret, dfs(cnt + 1, idx, chk|(1<<i), path, r, c, board));
				path.remove(path.size() - 1);
				path.remove(path.size() - 1);
			}
		
		return ret;
	}
	private static int solve(ArrayList<Pair> path, int r, int c, int[][] board) {
		int[][] tmp = new int[4][4];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				tmp[i][j] = board[i][j];
		
		int x = r, y = c, sum = 0;
		Queue<Pair> q = new LinkedList<>();
		
		for(Pair cur : path) {
			int a = cur.x, b = cur.y;
			Pair p = arr[a][b];
//			System.out.print("(" + cur.x + ", " + cur.y + ") ");
			q.clear();
			q.offer(new Pair(x, y));
			int time = 0;
			boolean[][] chk = new boolean[4][4];
			chk[x][y] = true;
			
			loop:while(!q.isEmpty()) {
				int size = q.size();
				while(--size >= 0) {
					Pair np = q.poll();
					
					if(np.x == p.x && np.y == p.y) break loop;
					
					for(int i = 0; i < 4; i++) {
						boolean flag = false;
						for(int j = 1; j < 4; j++) {
							int nx = np.x + dx[i] * j, ny = np.y + dy[i] * j;
							if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || tmp[nx][ny] == 0) continue;
							flag = true;
							q.offer(new Pair(nx, ny));
							break;
						}
						
						if(!flag) {
							int nx = np.x, ny = np.y;
							if(i == 0) nx = 3;
							else if(i == 1) ny = 3;
							else if(i == 2) nx = 0;
							else ny = 0;
							
							q.offer(new Pair(nx, ny));
						}
					}
					for(int i = 0; i < 4; i++) {
						int nx = np.x + dx[i], ny = np.y + dy[i];
						if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || chk[nx][ny]) continue;
						chk[nx][ny] = true;
						q.offer(new Pair(nx, ny));
					}
				}
				++time;
			}
//			System.out.println(":: " + time);
			sum += time + 1;
//			System.out.println(">>> " + sum);
			
			x = p.x;
			y = p.y;
			tmp[p.x][p.y] = 0;//카드 삭제
		}
//		System.out.println("-------------------- " + sum);
		return sum;
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}