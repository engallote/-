import java.util.*;

public class Main {
	public static void main(String[] args) {
		int N = 5;
		int[][] costs = {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}};
		
		System.out.println(solution(N, costs));
	}
	public static int solution(int N, int[][] costs) {
		int answer = 0;
		int[] par = new int[N];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			par[i] = i;
		
		int len = costs.length;
		
		for(int i = 0; i < len; i++)
			pq.offer(new Pair(costs[i][0], costs[i][1], costs[i][2]));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int a = find(p.v, par), b = find(p.u, par);
			
			if(a == b) continue;
			
			par[b] = a;
			answer += p.cost;
		}
		
		return answer;
	}
	private static int find(int x, int[] par) {
		if(par[x] == x) return x;
		return par[x] = find(par[x], par);
	}
}
class Pair implements Comparable<Pair>{
	int u, v, cost;
	Pair(int v, int u, int cost){		
		this.v = v;
		this.u = u;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}