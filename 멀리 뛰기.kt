class Solution {
    fun solution(n: Int): Long {
        var answer:Long = 0
        if(n == 1) return 1
        if(n == 2) return 2
        var dp:Array<Long> = Array<Long>(n+1, {i->0})
        dp[1] = 1
        dp[2] = 2

        for(i in 3..n){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567
        }
        answer = dp[n]
        return answer
    }
}