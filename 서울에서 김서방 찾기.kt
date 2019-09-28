class Solution {
    fun solution(seoul: Array<String>): String {
        var answer = ""
        var idx:Int = seoul.indexOf("Kim")
        answer = "김서방은 " + idx + "에 있다"
        return answer
    }
}