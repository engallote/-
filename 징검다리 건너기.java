import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		System.out.println(solution(stones, k));
	}
	public static int solution(int[] stones, int k) {
		int answer = 0;
		int l = 1, r = 200000000, mid;
		
		while(l <= r){
			mid = (l + r) / 2;
			int zero = 0;
			for(int i = 0; i < stones.length; i++){
				if(stones[i] < mid){
					++zero;
					if(zero >= k) break;
				}
				else zero = 0;
			}
			
			if(zero >= k) r = mid - 1;
			else{
				answer = Math.max(answer, mid);
				l = mid + 1;
			}
		}
		
		return answer;
	}
}