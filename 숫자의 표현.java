class Solution {
	public int solution(int n) {
	      int answer = 1;
	      int sum = 0;
	      for(int i = 1; i <= (int)n/2; i++){
	    	  sum = i;
	    	  for(int j = i + 1; j <= (int)n/2; j++){
	    		  sum += j;
	    		  if(sum == n)
	    		  {
	    			  ++answer;
	    			  break;
	    		  }
	    		  else if(sum > n) break;
	    	  }
	      }
	      
	      return answer;
	  }
}