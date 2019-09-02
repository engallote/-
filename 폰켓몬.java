import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = {3,3,3,2,2,4};
		System.out.println(solution(nums));
	}
	public static int solution(int[] nums) {
		int answer = -1;
		int len = nums.length, pick = len / 2;
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < len; i++) hs.add(nums[i]);
		
		if(hs.size() >= pick) answer = pick;
		else answer = hs.size();
		
		return answer;
	}
}