import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] arr = {1, 2, 3};
    	solution(arr);
	}
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < numbers.length; i++)
        	for(int j = i + 1; j < numbers.length; j++)
        		if(i != j && !pq.contains(numbers[i] + numbers[j]))
        			pq.offer(numbers[i] + numbers[j]);
        
        int len = pq.size();
        answer = new int[len];
        
        for(int i = 0; i < len; i++)
        	answer[i] = pq.poll();
        
        return answer;
    }
}