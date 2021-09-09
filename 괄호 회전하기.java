import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	solution("[](){}");
	}
    public static int solution(String s) {
        int answer = 0;
        int len = s.length();
        Deque<Character> dq = new LinkedList<>();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) dq.offer(c);
        
        for(int i = 0; i < len; i++) {
        	st.clear();
        	for(int j = 0; j < len; j++) {
        		char c = dq.peek();
        		if(c == '(' || c == '{' || c == '[') st.push(c);
        		else {
        			if(st.isEmpty()) st.push('e');
        			else {
        				if(c == '}' && st.peek() == '{') st.pop();
        				else if(c == ']' && st.peek() == '[') st.pop();
        				else if(c == ')' && st.peek() == '(') st.pop();
        			}
        		}
        		
        		dq.poll();
    			dq.offer(c);
        	}
        	
        	char c = dq.poll();
        	dq.offer(c);
        	if(st.isEmpty()) answer += 1;
        }
        
        return answer;
    }
}