import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solution(1000000000));
	}
	public static int solution(int n){
		int answer = 0;
		
		while(n > 0)
		{
			int div = n / 2;
			answer += n % 2;
			n = div;
		}
		
		return answer;
	}
}