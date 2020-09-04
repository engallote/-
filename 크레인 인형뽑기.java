import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		solution(board, moves);
	}
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = moves.length, N = board.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < len; i++){
        	int c = moves[i] - 1;
        	for(int r = 0; r < N; r++)
        		if(board[r][c] != 0){
        			if(!st.isEmpty() && st.peek() == board[r][c]){
        				answer += 2;
        				st.pop();
        			}
        			else st.push(board[r][c]);
        			board[r][c] = 0;
        			break;
        		}
        }
        
        return answer;
    }
}