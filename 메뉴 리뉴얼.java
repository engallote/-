import java.util.*;

public class Main {
	static int min;
	static Queue<String> q = new LinkedList<>();
    public static void main(String[] args) {
    	String[] str = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}; 
    	int[] arr = {2, 3, 4};
    	solution(str, arr);
	}
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        PriorityQueue<String> pq = new PriorityQueue<>();
        
        for(int i = 0; i < course.length; i++) {
        	q.clear();
        	min = 0;
        	dfs(0, 0, course[i], "", orders);
        	while(!q.isEmpty()) pq.offer(q.poll());
        }
        
        int len = pq.size();
        answer = new String[len];
        
        for(int i = 0; i < len; i++)
        	answer[i] = pq.poll();
        
        return answer;
    }
	private static void dfs(int idx, int cnt, int len, String str, String[] orders) {
		if(cnt >= len) {
			char[] ch = str.toCharArray();
			int sum = 0;
			
			for(int i = 0; i < orders.length; i++) {
				boolean flag = true;
				for(char c : ch)
					if(!orders[i].contains(c+"")) {
						flag = false;
						break;
					}
				
				if(flag) sum += 1;
			}
			
//			System.out.println(str + " >> " + sum);
			if(sum >= 2) {
				if(min < sum) {
					min = sum;
					q.clear();
					q.offer(str);
				}
				else if(min == sum) q.offer(str);
			}
			
			return;
		}
		if(idx >= 26) return;
		dfs(idx + 1, cnt, len, str, orders);
		dfs(idx + 1, cnt + 1, len, str+""+(char)('A' + idx), orders);
	}
}