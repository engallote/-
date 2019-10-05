import java.util.*

class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()
        var q:PriorityQueue<Int> = PriorityQueue()
        for(i in arr)
            if(i % divisor == 0) q.offer(i)

        if(q.isEmpty()){
            answer = intArrayOf(-1)
            return answer
        }
        var idx:Int = 0
        answer = IntArray(q.size)
        while(!q.isEmpty())
            answer[idx++] = q.poll()
        return answer
    }
}