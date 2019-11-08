import java.lang.StringBuilder

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var sb:StringBuilder = StringBuilder()
        var ch = number.toString().toCharArray();
        var len:Int = number.length
        var start:Int = 0
        var max:Int = -1

        for(i in len - (len - k) until len){
            max = -1
            for(j in start..i){
                if(ch[j] == '9') {
                    start = j + 1
                    max = 9
                    break
                }
                else if(ch[j] - '0' > max) {
                    start = j + 1
                    max = ch[j] - '0'
                }
            }
            sb.append(max)
        }
        answer = sb.toString()
        return answer
    }
}