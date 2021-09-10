import java.util.*;

public class Main {
    public static void main(String[] args) {
    	String[] str1 = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
    	String[] str2 = {"PYTHON", "C++", "SQL"};
    	int[] p = {7, 5, 5};
    	solution(str1, str2, p);
	}
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        
        int max = -1;
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int j = 0; j < 5; j++) {
    		String[] str = table[j].split(" ");
    		String name = str[0];
    		
    		int score = 0, sum = 0;
    		for(int i = 0; i < languages.length; i++) {
            	String lan = languages[i];
            	
            	score = 0;
            	for(int k = 1; k <= 5; k++)
        			if(str[k].equals(lan)) {
        				score = 6 - k;
        				break;
        			}
        		
        		System.out.println(name + " score : " + score + ", pre : " + preference[i]);
        		sum += score * preference[i];
            }
    		if(max < sum) {
    			max = sum;
    			pq.clear();
    			pq.offer(name);
    		}
    		else if(max == sum) pq.offer(name);
    	}
        
        answer = pq.poll();
        return answer;
    }
}