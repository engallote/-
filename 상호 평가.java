import java.util.*;

public class Main {
    public static void main(String[] args) {
    	int[][] arr = {{100,90,95,39,24}, {34,25,64,35,46}, {56, 75,49,34,37}, {57,96,54,78,20}, {53,75,25,76,76}};
    	solution(arr);
	}
    public static String solution(int[][] scores) {
        String answer = "";
        
        for(int j = 0; j < scores.length; j++) {
        	double score = 0, cnt = scores.length;
        	int max = -1, min = 1000000, midx1 = -1, midx2 = -1, mcnt1 = 0, mcnt2 = 0;
        	for(int i = 0; i < scores.length; i++) {
        		score += scores[i][j];
        		if(max < scores[i][j]) {
        			max = scores[i][j];
        			midx1 = i;
        			mcnt1 = 1;
        		}
        		else if(max == scores[i][j]) mcnt1 += 1;
        		if(min > scores[i][j]) {
        			min = scores[i][j];
        			midx2 = i;
        			mcnt2 = 1;
        		}
        		else if(min == scores[i][j]) mcnt2 += 1;
        	}
        	
        	if((midx1 == j && mcnt1 == 1) || (midx2 == j && mcnt2 == 1)) {
        		if(midx1 == j) score -= max;
        		else score -= min;
        		
        		cnt -= 1;
        	}
        	
        	score /= cnt;
        	
        	if(score >= 90) answer += "A";
        	else if(score >= 80) answer += "B";
        	else if(score >= 70) answer += "C";
        	else if(score >= 50) answer += "D";
        	else answer += "F";
        }
        return answer;
    }
}