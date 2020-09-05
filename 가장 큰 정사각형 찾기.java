public class Main {
	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}; 
		
		System.out.println(solution(board));
	}
	public static int solution(int[][] board) {
		int answer = 0;
		int N = board.length, M = board[0].length;
		int[][] arr = new int[N][M];
		boolean one = false;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				if(board[i][j] == 1) one = true;
				if(j - 1 >= 0 && i - 1 >= 0){
					if(board[i][j] == 1){
						arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1])) + 1;
						answer = Math.max(answer, arr[i][j]);
					}
				}
				else arr[i][j] = board[i][j];
			}
		
		if(answer == 0 && one) answer = 1;
		answer *= answer;
		return answer;
	}
}