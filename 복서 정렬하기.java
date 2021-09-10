import java.util.*;

public class Main {
    public static void main(String[] args) {
    	int[] arr = {50,82,75,120};
    	String[] str = {"NLWL","WNLL","LWNW","WWLN"};
    	solution(arr, str);
	}
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0; i < weights.length; i++) {
        	char[] ch = head2head[i].toCharArray();
        	int win = 0, all = 0, winWeight = 0;
        	
        	for(int j = 0; j < weights.length; j++) {
        		if(ch[j] == 'W') {
        			++win;
        			
        			if(weights[i] < weights[j]) ++winWeight;
        		}
        		if(ch[j] == 'N') continue;
        		++all;
        	}
        	
        	double res = 0;
        	if(win == 0 || all == 0) res = 0;
        	else res = ((double)win / (double)all) * 100.0;
//        	System.out.println(res);
        	pq.offer(new Pair(i + 1, weights[i], res, winWeight, head2head[i]));
        }
        
        for(int i = 0; i < weights.length; i++)
        	answer[i] = pq.poll().idx;
        
        return answer;
    }
}
class Pair implements Comparable<Pair> {
	int idx, w, winW;
	double win;
	String str;
	Pair(int idx, int w, double win, int winW, String str){
		this.idx = idx;
		this.w = w;
		this.win = win;
		this.winW = winW;
		this.str = str;
	}
	
	@Override
	public int compareTo(Pair o) {
		if(this.win > o.win) return -1;
		else if(this.win == o.win) {
			if(this.winW > o.winW) return -1;
			else if(this.winW == o.winW) {
				if(this.w > o.w) return -1;
				else if(this.w == o.w) return Integer.compare(this.idx, o.idx);
				else return 1;
			}
			else return 1;
		}
		else return 1;
	}
}