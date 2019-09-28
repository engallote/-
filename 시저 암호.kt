class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        var num:Int = 0
        for(i in s.toCharArray()){
            if(i == ' '){
                answer += " "
                continue
            }
            if(i >= 'A' && i <= 'Z'){
                num = i - 'A' + n
                num %= 26
                answer += (num + 'A'.toInt()).toChar()
            }
            else{
                num = i - 'a' + n
                num %= 26
                answer += (num + 'a'.toInt()).toChar()
            }
        }

        return answer
    }
}