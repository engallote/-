import java.util.*;

public class Main {
    public static void main(String[] args) {
    	int[] a = {4, 5, 3};
    	boolean[] b = {true, false, true};
    	solution(a, b);
	}
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
        	if(signs[i]) answer += absolutes[i];
        	else answer -= absolutes[i];
        }
        
        return answer;
    }
}