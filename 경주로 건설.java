import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		
		System.out.println(solution(board));
	}
	public static int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int N = board.length, M = board[0].length, size;
		int[][][] chk = new int[N][M][4];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				Arrays.fill(chk[i][j], 1000000000);
		
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, 0, 0, 0));
		q.offer(new Pair(0, 0, 1, 0, 0));
		q.offer(new Pair(0, 0, 2, 0, 0));
		q.offer(new Pair(0, 0, 3, 0, 0));
		chk[0][0][0] = chk[0][0][1] = 100;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1){
					answer = Math.min(answer, chk[p.x][p.y][p.d]);
					continue;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || board[nx][ny] == 1)
						continue;
					
					int cost = p.straight * 100 + p.curve * 500, st = p.straight, cur = p.curve;
					if(p.x == 0 && p.y == 0){
						cost += 100;
						++st;
					}
					else if(i == p.d){
						cost += 100;
						++st;
					}
					else{
						cost += 600;
						++st;
						++cur;
					}
					
					if(chk[nx][ny][i] <= cost) continue;
					chk[nx][ny][i] = cost;
					q.offer(new Pair(nx, ny, i, st, cur));
				}
			}
		}
		
		return answer;
	}
}
class Pair{
	int x, y, d, straight, curve;
	Pair(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
	Pair(int x, int y, int d, int straight, int curve){
		this.x = x;
		this.y = y;
		this.d = d;
		this.straight = straight;
		this.curve = curve;
	}
}