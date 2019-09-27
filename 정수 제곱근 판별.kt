import kotlin.math.sqrt

class Solution {
    fun solution(n: Long): Long {
        var answer:Long = 0
        var num:Double = sqrt(n.toDouble())

        var idx:Int = num.toString().indexOf(".")
        var modNum:Long = num.toString().substring(idx+1).toLong()
        if(modNum.compareTo(0) != 0) return -1
        answer = ((num + 1) * (num + 1)).toLong()
        return answer
    }
}