import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
		System.out.println(solution(key, lock));
	}
	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false, flag;
		int x = -1, y = - 1, N = key.length;
		int r = 0, minC = 0, maxC = 0;
		ArrayList<Pair> aly = new ArrayList<>();
		
		for(int i = 0; i < lock.length; i++)
			for(int j = 0; j < lock.length; j++)
				if(lock[i][j] == 0){
					if(x == -1){
						x = i;
						y = j;
					}
					else aly.add(new Pair(i - x, j - y));
				}
		
		loop:for(int k = 0; k < 4; k++){
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++){
					if(key[i][j] == 1){
						flag = true;
						r = -1;
						minC = N;
						maxC = -1;
						
						//키 체크
						for(Pair p : aly){
							int nx = i + p.x, ny = j + p.y;
							if(nx < 0 || ny < 0 || nx >= N || ny >= N || key[nx][ny] == 0){
								flag = false;
								break;
							}
							r = Math.max(r, nx);
							minC = Math.min(minC, ny);
							maxC = Math.max(maxC, ny);
						}//pair
						if(!flag) continue;
						
						//범위 체크
						int sum = 0;
						for(int a = i; a <= r; a++)
							for(int b = minC; b <= maxC; b++)
								if(key[a][b] == 1) ++sum;
						
						if(sum > aly.size() + 1) continue;
						
						answer = true;
						break loop;
					}//if
				}
			rotate(key);//키 돌리기
		}
				
		return answer;
	}
	private static void rotate(int[][] key) {
		int N = key.length;
		int[][] tmp = new int[N][N];
		int r = 0, c = 0;
		
		for(int i = 0; i < N; i++){
			r = N - 1;
			for(int j = 0; j < N; j++){
				tmp[i][j] = key[r][c];
				--r;
			}
			++c;
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				key[i][j] = tmp[i][j];
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}