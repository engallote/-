class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        var len:Int = phone_number.length;

        len -= 4
        for(i in 1..len)
            answer += "*"
        answer += phone_number.substring(len)
        return answer
    }
}