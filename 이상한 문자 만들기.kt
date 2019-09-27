class Solution {
    fun solution(s: String): String {
        var answer = ""
        var sw:Int = 1

        for(i in s){
            if(i == ' '){
                sw = 1
                answer += i
                continue
            }
            if(sw == -1) answer += i.toLowerCase()
            else answer += i.toUpperCase()
            sw *= -1
        }
        return answer
    }
}