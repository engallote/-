import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] times = new int[2];
		for(int i = 0; i < 2; i++) times[i] = sc.nextInt();
		System.out.println(solution(N, times));
	}
	public static long solution(int n, int[] times) {
        long ans = Long.MAX_VALUE;
		int len = times.length;
		Arrays.sort(times);
		long l = 0, r = Long.MAX_VALUE, mid, sum;
		while(l <= r)
		{
			mid = (l + r) / 2;
			sum = 0;
			
			for(int i = 0; i < len; i++)
			{
				sum += mid / times[i];
				if(sum >= n) break;
			}
			
			if(sum >= n)
			{
				ans = Math.min(ans, mid);
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		return ans;
	}
}