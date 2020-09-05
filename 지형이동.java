import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] land = {{1, 1, 1, 1},{5, 8, 11, 14},{5, 8, 11, 14},{5, 8, 11, 14}};
//		int[][] land = {{1, 3, 1, 3},{3, 1, 3, 1},{1, 3, 1, 3},{3, 1, 3, 1}};
		int height = 1;
		
		System.out.println(solution(land, height));
	}
	public static int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        int[][] chk = new int[N][N];
        int[] par = new int[100000];
        
        for(int i = 1; i < 100000; i++)
        	par[i] = i;
        int idx = 1;
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++)
        		if(chk[i][j] == 0){
        			bfs(i, j, idx, N, chk, land, height);
        			++idx;
        		}
        
        ArrayList<Pair> aly = new ArrayList<>();
        for(int i = 0; i < N; i++)
        	for(int j = 0; j < N; j++){
        		for(int k = 0; k < 4; k++){
        			int nx = i + dx[k], ny = j + dy[k];
        			
        			if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] == chk[i][j])
        				continue;
        			
        			aly.add(new Pair(chk[i][j], chk[nx][ny], Math.abs(land[nx][ny] - land[i][j])));
        		}
        	}
        
        Collections.sort(aly);
        
        //최단거리 계산
        for(Pair p : aly){
        	int a = find(p.x, par), b = find(p.y, par);
        	
        	if(a == b) continue;
        	par[b] = a;
        	answer += p.cost;
        }
        
        return answer;
    }
	private static int find(int x, int[] par) {
		if(par[x] == x) return x;
		return par[x] = find(par[x], par);
	}
	private static void bfs(int x, int y, int idx, int n, int[][] chk, int[][] land, int height) {
		chk[x][y] = idx;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || chk[nx][ny] != 0 || Math.abs(land[nx][ny] - land[p.x][p.y]) > height)
					continue;
				chk[nx][ny] = idx;
				q.offer(new Pair(nx, ny));
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cost;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}