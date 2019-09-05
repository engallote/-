import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] stages = {4,4,4,4,4};
		System.out.println(solution(4, stages));
	}
	public static int[] solution(int N, int[] stages){
		int[] answer = new int[N];
		int len = stages.length;
		double[] pass = new double[N+1], cur = new double[N+11];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = len - 1; i >= 0; i--){
			for(int j = 1; j < stages[i]; j++)
				pass[j]++;
			cur[stages[i]]++;
		}
		
		for(int i = 1; i <= N; i++)
		{
			if(pass[i] == 0 && cur[i] == 0) pq.offer(new Pair(i, 0));
			else pq.offer(new Pair(i, cur[i]/pass[i]));
		}
		
		int idx = 0;
		while(!pq.isEmpty()) 
			answer[idx++] = pq.poll().idx;
		
		return answer;
	}
}
class Pair implements Comparable<Pair>{
	int idx;
	double rate;
	Pair(int idx, double rate){
		this.idx = idx;
		this.rate = rate;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.rate > this.rate) return 1;
		else if(o.rate == this.rate)
		{
			if(o.idx > this.idx) return -1;
			else return 1;
		}
		else return -1;
	}
}