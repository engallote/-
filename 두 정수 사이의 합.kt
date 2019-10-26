import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer:Long = 0
        for(i in min(a,b)..max(a,b))
            answer += i
        return answer
    }
}