import java.util.*;

public class Main {
    public static void main(String[] args) {
    	int[] a = {1, 2, 3, 4}, b = {5, 6, 7, 8};
    	solution(a, b);
	}
    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++)
        	answer += a[i] * b[i];
        
        return answer;
    }
}