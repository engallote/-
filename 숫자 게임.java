import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] A = {5,1,3,7}, B = {8,2,6,2};
		System.out.println(solution(A, B));
	}
	public static int solution(int[] A, int[] B){
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int idx = 0;
		for(int i = 0; i < A.length && idx < A.length; i++)
		{
			while(idx < B.length){
				if(A[i] >= B[idx]) idx++;
				else
				{
					idx++;
					answer++;
					break;
				}
			}
		}
		return answer;
	}
}