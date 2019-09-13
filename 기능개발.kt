import java.util.*

class Solution {
    fun main(args: Array<String>){
        var progresses:IntArray = intArrayOf(93,30,55)
        var speeds:IntArray = intArrayOf(1,30,5)
        println(solution(progresses, speeds))
    }
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var days:IntArray = IntArray(progresses.size)
        var num:Int = 0
        for(i in progresses.indices){
            num = 1
            while(num * speeds[i] + progresses[i] < 100) num++
            days[i] = num
            if(i - 1 >= 0 && days[i-1] > days[i]) days[i] = days[i-1]
        }

        var q:Queue<Int> = LinkedList()
        var idx:Int = 0
        var cnt:Int = 1
        for(i in 1 until days.size){
            if(days[i-1] == days[i]) {
                cnt++
                continue
            }
            else {
                q.offer(cnt)
                cnt = 1
            }
        }
        q.offer(cnt)

        answer = IntArray(q.size)
        while(!q.isEmpty())
            answer[idx++] = q.poll()
        return answer
    }
}