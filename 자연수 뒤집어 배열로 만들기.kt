class Solution {
    fun solution(n: Long): IntArray {
        var answer = intArrayOf()
        var len:Int = n.toString().length
        answer = IntArray(len)
        var idx:Int = 0
        var num = n

        while(num > 0){
            answer[idx] = num.rem(10).toInt()
            num = num.div(10)
            idx++
        }

        return answer
    }
}