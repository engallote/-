class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        var num:Int = 0
        var tmpX:Int = x

        while(tmpX > 0){
            num += tmpX % 10
            tmpX /= 10
        }

        if(x % num != 0) answer = false
        return answer
    }
}