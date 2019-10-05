import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int N = truck_weights.length;
        Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < N; i++)
			q.offer(truck_weights[i]);
		
		Queue<Pair> q2 = new LinkedList<Pair>();
		int sum = 0;//다리 위 무게
		int size = 0, cnt = 0, time = 1;
		boolean out = false;
		while(!q.isEmpty() || !q2.isEmpty())
		{
			out = false;
			//다리 끝에 있는 차 빼기
			size = q2.size();
			while(size > 0)
			{
				size--;
				Pair p = q2.poll();
				if(!out && p.time >= bridge_length)
				{
					out = true;
					cnt--;
					sum -= p.num;
					continue;
				}
				q2.offer(new Pair(p.num, p.time + 1));
			}
			//비어있으면 진입
			if(cnt < bridge_length && !q.isEmpty() && sum + q.peek() <= weight)
			{
				cnt++;
				sum += q.peek();
				q2.offer(new Pair(q.poll(), 1));
			}
//			System.out.println();
			if(q.isEmpty() && q2.isEmpty()) break;
			time++;
		}
        answer = time;
        return answer;
    }
}
class Pair{
	int num, time;
	Pair(int num, int time){
		this.num = num;
		this.time = time;
	}
}