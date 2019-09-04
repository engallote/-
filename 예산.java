import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] d = {1,3,2,5,4};
		System.out.println(solution(d, 9));
	}
	public static int solution(int[] d, int budget){
		int answer = 0;
		
		Arrays.sort(d);
		int tmp = budget;
		for(int i = 0; i < d.length; i++)
		{
			if(d[i] <= tmp)
			{
				tmp -= d[i];
				answer++;
			}
			else break;
		}
		return answer;
	}
}