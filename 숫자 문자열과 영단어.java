import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	solution("one4seveneight");
	}
    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(), res = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("zero", 0);
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eight", 8);
        hm.put("nine", 9);
        
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++) {
        	if('0' <= ch[i] && ch[i] <= '9') res.append(ch[i]);
        	else {
        		sb.append(ch[i]);
        		
        		if(hm.containsKey(sb.toString())) {
        			res.append(hm.get(sb.toString()));
        			sb = new StringBuilder();
        		}
        	}
        }
        
        answer = Integer.parseInt(res.toString());
        
        return answer;
    }
}