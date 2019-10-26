import java.util.*

class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)
        var pq:PriorityQueue<Int> = PriorityQueue()
        for((idx, i) in commands.indices.withIndex()) {
            pq.clear()
            for(j in commands[i][0]-1 until commands[i][1]) pq.offer(array[j])
            var num = commands[i][2]
            while(--num > 0 && !pq.isEmpty()) pq.poll()
            answer[idx] = pq.peek()
        }

        return answer
    }
}