import java.util.*;

public class Main {
    public static void main(String[] args) {
    	solution(3, 20, 4);
	}
    public static long solution(int price, int money, int count) {
        long answer = -1;
        long p = 0, cost = price;
        
        for(int i = 1; i <= count; i++) {
        	p += cost;
        	cost = (long)price * (long)(i + 1); 
        }
        answer = money - p <= 0 ? Math.abs(money - p) : 0;
        return answer;
    }
}