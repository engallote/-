import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*

class Solution {
    fun main(args: Array<String>){
        var heights = intArrayOf(6,9,5,7,4)
        println(solution(heights))
    }
    fun solution(heights:IntArray): IntArray {
        val len = heights.size
        var answer:IntArray = IntArray(len)

        for(i in len-1 downTo 0)
        {
            for(j in i-1 downTo 0)
            {
                if(heights[i] < heights[j])
                {
                    answer[i] = j + 1
                    break
                }
            }
        }

        return answer
    }
}