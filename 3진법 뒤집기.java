class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(n, 3));
        sb.reverse();
        int c = 1;
        for(int i = sb.toString().length() - 1; i >= 0; i--) {
        	answer += (sb.toString().charAt(i) - '0') * c;
        	c *= 3;
        }
        
        return answer;
    }
}