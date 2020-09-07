import java.util.*;

public class Main {
	public static void main(String[] args) {
		int n = 10;
		
		System.out.println(solution(n));
	}
	public static int solution(int n) {
		int answer = 0;
		boolean[] chk = new boolean[n+1];
		chk[0] = chk[1] = true;
		
		for(int i = 2; i <= n; i++){
			if(chk[i]) continue;
			++answer;
			for(int j = i + i; j <= n; j+=i)
				chk[j] = true;
		}
		
		return answer;
	}
}