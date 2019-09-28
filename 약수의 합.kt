import kotlin.math.sqrt

class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        if(n == 0) return 0
        if(n == 1) return 1
        var num:Double = n.toDouble()
        answer = 1 + n
        for(i in 2..sqrt(num).toInt()){
            if(n % i == 0){
                if(i == n / i) answer += i
                else answer += i + (n / i)
            }
        }
        return answer
    }
}