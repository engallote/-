import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] lottos = {44, 1, 0, 0, 31, 25};
    	int[] win_nums = {31, 10, 45, 1, 6, 19};
    	solution(lottos, win_nums);
	}
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0; i < 6; i++) hs.add(win_nums[i]);
        
        int cnt = 0, zero = 0;
        for(int i = 0; i < 6; i++) {
        	if(lottos[i] == 0) ++zero; 
        	if(hs.contains(lottos[i])) ++cnt;
        }
        
        if(cnt + zero <= 1) answer[0] = 6;
        else if(cnt + zero == 2) answer[0] = 5;
        else if(cnt + zero == 3) answer[0] = 4;
        else if(cnt + zero == 4) answer[0] = 3;
        else if(cnt + zero == 5) answer[0] = 2;
        else answer[0] = 1;
        
        if(cnt <= 1) answer[1] = 6;
        else if(cnt == 2) answer[1] = 5;
        else if(cnt == 3) answer[1] = 4;
        else if(cnt == 4) answer[1] = 3;
        else if(cnt == 5) answer[1] = 2;
        else answer[1] = 1;
        
        return answer;
    }
}