class Solution {
    fun solution(n: Int): String {
        var answer = ""
        var str = arrayOf("¼ö","¹Ú")
        var sw:Int = 0

        for(i in 0 until n){
            answer += str[sw]
            sw += 1
            sw %= 2
        }
        return answer
    }
}