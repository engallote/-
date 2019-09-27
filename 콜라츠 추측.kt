class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        if(num == 1) return answer
        var n:Long = Integer.toUnsignedLong(num)

        while(true){
            if(n.rem(2).compareTo(0) == 0) n /= 2
            else{
                n *= 3
                n += 1
            }
            answer += 1
            if(n.compareTo(1) == 0) break
            if(answer > 500){
                answer = -1
                break
            }
        }

        return answer
    }
}