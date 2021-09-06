import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	solution("abcdefghijklmn.p");
	}
    public static String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        //1
        new_id = new_id.toLowerCase();
        
        //2
        char[] ch = new_id.toCharArray();
        for(int i = 0; i < ch.length; i++) {
        	if(ch[i] == '-' || ch[i] == '_' || ch[i] == '.')
        		sb.append(ch[i]);
        	else if('a' <= ch[i] && ch[i] <= 'z')
        		sb.append(ch[i]);
        	else if('0' <= ch[i] && ch[i] <= '9')
        		sb.append(ch[i]);
        }
        
        ch = sb.toString().toCharArray();
        sb = new StringBuilder();
        
        //3
        char pre = '!';
        for(int i = 0; i < ch.length; i++) {
        	if(pre == ch[i] && ch[i] == '.') continue;
        	else {
        		sb.append(ch[i]);
        	}
        	pre = ch[i];
        }
        
        ch = sb.toString().toCharArray();
        sb = new StringBuilder();
        
        //4 (. 제거)
        int s = 0, e = 0;
        boolean sf = false, ef = false;
        for(int i = 0; i < ch.length; i++) {
        	s = i;
        	if(ch[i] != '.') {
        		sf = true;
        		break;
        	}
        }
        for(int i = ch.length - 1; i >= 0; i--) {
        	e = i;
        	if(ch[i] != '.') {
        		ef = true;
        		break;
        	}
        }
        
        if(sf && ef) {
        	for(int i = s; i <= e; i++)
            	sb.append(ch[i]);
        }
        
        if(sb.length() > 0) {
        	ch = sb.toString().toCharArray();
            sb = new StringBuilder();
        }
        else {
        	//5
        	ch = new char[1];
        	ch[0] = 'a';
        }
        
        //6
        if(ch.length >= 16) ch = new String(ch).substring(0, 15).toCharArray();
        
        while(ch[ch.length - 1] == '.') {//맨 끝 마침표 제거
        	ch = new String(ch).substring(0, ch.length - 1).toCharArray();
        }
        
        //7
        sb.append(new String(ch));
        
        for(int i = 0; i < 3 - ch.length; i++)
        	sb.append(ch[ch.length - 1]);
        
        answer = sb.toString();
        
        return answer;
    }
}