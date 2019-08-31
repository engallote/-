import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] genres = {"classic", "pop","classic","classic","pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		System.out.println(solution(genres, plays));
	}
	public static int[] solution(String[] genres, int[] plays) {
		int[] ans = {};
		HashMap<String, Integer> gidx = new HashMap<>();
		HashMap<Integer, Integer> sum = new HashMap<>();
		PriorityQueue<Pair>[] pq = new PriorityQueue[100];
		PriorityQueue<Pair> sort = new PriorityQueue<>();
		int idx = 0, len = genres.length, len2 = 0;
		
		for(int i = 0; i < len; i++)
		{
			if(gidx.containsKey(genres[i]))
			{
				pq[gidx.get(genres[i])].offer(new Pair(i, plays[i]));
				sum.replace(gidx.get(genres[i]), sum.get(gidx.get(genres[i])) + plays[i]);
				if(pq[gidx.get(genres[i])].size() <= 2) len2++;
			}
			else
			{
				pq[idx] = new PriorityQueue<>();
				len2++;
				gidx.put(genres[i], idx);
				pq[idx].offer(new Pair(i, plays[i]));
				sum.put(idx, plays[i]);
				idx++;
			}
		}
		
		ans = new int[len2];
		Iterator<Integer> it = sum.keySet().iterator();
		while(it.hasNext())
		{
			int key = it.next();
			int value = sum.get(key);
			
			sort.offer(new Pair(key, value));
		}
		idx = 0;
		while(!sort.isEmpty())
		{
			Pair p = sort.poll();
			int cnt = 0;
			while(!pq[p.idx].isEmpty() && cnt < 2)
			{
				Pair p2 = pq[p.idx].poll();
				cnt++;
				
				ans[idx++] = p2.idx;
			}
		}
		
		return ans;
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num){
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return 1;
		else if(o.num == this.num)
		{
			if(o.idx > this.idx) return -1;
			else return 1;
		}
		else return -1;
	}
}