import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] works = {2, 1, 2};
		int n = 1;
		
		System.out.println(solution(n, works));
	}
	public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < works.length; i++)
        	pq.offer(works[i]);
        
        while(!pq.isEmpty() && --n >= 0){
        	int time = pq.poll();
        	if(time <= 0) return 0;
        	pq.offer(time - 1);
        }
        
        while(!pq.isEmpty()){
        	int x = pq.poll();
        	
        	answer += (long)x * (long)x;
        }
        return answer;
    }
}