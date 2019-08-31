import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*

class Solution {
    var dp:Array<IntArray> = Array<IntArray>(2500, {IntArray(2500, {i->-1})})
    fun main(args : Array<String>) = with(Scanner(BufferedInputStream(System.`in`))){
        var s:String = next()

        println(solution(s))
    }
    fun solution(s: String): Int {
        var answer = 0
        var l:Int = 0
        var r:Int = 0

        for(i in 0 until s.length){
            if(answer >= s.length - i) break
            for(j in s.length-1 downTo i+1)
            {
                if(s[i] != s[j]) continue
                l = i
                r = j
                while (l <= r){
                    if(s[l] == s[r]){
                        l++
                        r--
                    }
                    else break
                }
                if(l >= r) answer = Math.max(answer, j - i + 1)
            }
        }

        return answer
    }
}