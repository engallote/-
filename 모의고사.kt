import java.io.BufferedInputStream
import java.util.*
import kotlin.math.max

class Solution {
    fun main(args: Array<String>) = with(Scanner(BufferedInputStream(System.`in`))) {
        var answers = intArrayOf(1,2,3,4,5)
        println(solution(answers))
    }

    fun solution(answers:IntArray): IntArray {
        val len = answers.size
        var answer:IntArray;
        val ans1:IntArray = intArrayOf(1,2,3,4,5)
        val ans2:IntArray = intArrayOf(2,1,2,3,2,4,2,5)
        val ans3:IntArray = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var num:IntArray = IntArray(len)

        var idx1:Int = 0
        var idx2:Int = 0
        var idx3:Int = 0
        var number:Int = 0
        var max:Int = 0

        for(i in 0 until len){
            number = answers[i]
            if(ans1[idx1] == number) {
                num[0]++
                max = max(max, num[0])
            }
            if(ans2[idx2] == number) {
                num[1]++
                max = max(max, num[1])
            }
            if(ans3[idx3] == number) {
                num[2]++
                max = max(max, num[2])
            }

            idx1 = (idx1 + 1) % ans1.size
            idx2 = (idx2 + 1) % ans2.size
            idx3 = (idx3 + 1) % ans3.size
        }

        var q:Queue<Int> = LinkedList()
        for(i in 0 until 3)
            if(num[i] == max)
                q.offer(i+1)

        answer = IntArray(q.size)
        idx1 = 0
        while(!q.isEmpty())
            answer[idx1++] = q.poll()
        return answer
    }
}