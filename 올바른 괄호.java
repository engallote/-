class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int open = 0;
        
        for(char c : s.toCharArray()){
        	if(c == '(') ++open;
        	else
        	{
        		if(open == 0)
        		{
        			answer = false;
        			break;
        		}
        		--open;
        	}
        }

        if(open > 0) answer = false;
        return answer;
    }
}