import kotlin.math.abs

class Solution {
    var col:IntArray = IntArray(12,{i->0})
    fun solution(n: Int): Int {
        var answer = 0
        answer = solve(0, n)
        return answer
    }
	
    private fun solve(idx: Int, n: Int): Int {
        var flag:Boolean = true
        if(idx >= n) return 1
        var ret:Int = 0

        for(i in 0 until n){
            flag = true
            for(j in 0 until idx){
                if(col[j] == i || abs(idx-j) == abs(i-col[j])){
                    flag = false
                    break
                }
            }
            if(flag){
                col[idx] = i
                ret += solve(idx + 1, n)
            }
        }

        return ret
    }
}