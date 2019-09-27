import java.util.*

class Solution {
    fun solution(n: Long): Long {
        var answer:Long = 0
        var num:Long = n
        var pq:PriorityQueue<Int> = PriorityQueue(reverseOrder<Int>())

        while(num > 0){
            pq.offer(num.rem(10).toInt())
            num /= 10
        }
        while(!pq.isEmpty()) {
            answer *= 10
            answer += pq.poll()
        }
        return answer
    }
}