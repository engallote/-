import java.util.*

class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = longArrayOf()
        var q:Queue<Long> = LinkedList();
        var cnt:Int = 0
        var num:Long = 0
        while(cnt < n){
            num += x
            q.offer(num)
            cnt++
        }
        answer = LongArray(q.size)
        cnt = 0
        while(!q.isEmpty())
            answer[cnt++] = q.poll()
        return answer
    }
}