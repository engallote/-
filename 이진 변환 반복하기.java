import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	solution("1111111");
	}
    public static int[] solution(String s) {
        int[] answer = new int[2];
        
        while(true) {
        	int zero = 0;
        	for(char ch : s.toCharArray())
        		if(ch == '0') ++zero;
        	
        	if(s.contains("0"))	s = s.replaceAll("0", "");
        	
        	int len = s.length();
        	s = Integer.toString(len, 2);
        	
        	answer[0] += 1;
        	answer[1] += zero;
        	
        	if(s.length() == 1) break;
        }
        
        return answer;
    }
}