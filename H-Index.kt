import java.lang.Integer.max

class Solution {
    fun main(args: Array<String>){
        var citations:IntArray = intArrayOf(3,0,6,1,5)
        println(solution(citations))
    }
    fun solution(citations: IntArray): Int {
        var answer = 0
        var l:Int = 0
        var r:Int = 10000
        var mid:Int = 0
        var up:Int = 0
        var down:Int = 0
        while(l <= r)
        {
            mid = (l + r) / 2
            up = 0
            down = 0
            for(i in citations)
            {
                if(i >= mid) up++
                if(i <= mid) down++
            }

            if(up >= mid && down <= mid)
            {
                answer = max(answer, mid)
                l = mid + 1
            }
            else r = mid - 1
        }
        return answer
    }
}