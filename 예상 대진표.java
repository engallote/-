import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solution(8,1,8));
	}
	public static int solution(int n, int a, int b){
		int answer = 0;
		
		int A = a, B = b, cnt = 1;
		while(n > 1)
		{
			int rank = 1;
			boolean aa = false, bb = false;
			for(int i = 1; i < n; i+=2)
			{
				if(aa && bb) break;
				if((A == i && B == i + 1) || (A == i + 1 && B == i))
				{
					answer = cnt;
					break;
				}
				else if(A == i || A == i + 1) 
				{
					A = rank;
					aa = true;
				}
				else if(B == i || B == i + 1) 
				{
					B = rank;
					bb = true;
				}
				rank++;
			}
			if(answer != 0) break;
			cnt++;
			n /= 2;
		}
		
		return answer;
	}
}