import java.util.*;

public class Main {
    public static void main(String[] args) {
    	solution("baabaa");
	}
    public static int solution(String s) {
        int answer = 0;
        
        Deque<Character> dq = new LinkedList<>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(!dq.isEmpty() && dq.peekLast() == s.charAt(i)) dq.pollLast();
    		else dq.offer(s.charAt(i));
        }
        
        if(dq.isEmpty()) answer = 1;
        
        return answer;
    }
}