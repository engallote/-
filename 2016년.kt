class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var str = arrayOf("MON","TUE","WED","THU","FRI","SAT","SUN")
        var idx:Int = 4
        var m:Int = 1
        var d:Int = 1
        while(true){
            if(m == a && d == b) break
            if(m == 2){
                idx = (idx + 1) % 7
                ++d
                if(d == 30){
                    ++m
                    d = 1
                }
            }
            else if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
                idx = (idx + 1) % 7
                ++d
                if(d == 32){
                    ++m
                    d = 1
                }
            }
            else{
                idx = (idx + 1) % 7
                ++d
                if(d == 31) {
                    ++m
                    d = 1
                }
            }
        }
        answer = str[idx]
        return answer
    }
}