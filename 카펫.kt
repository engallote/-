class Solution {
    fun main(args: Array<String>){
        println(solution(24, 24))
    }
    fun solution(brown: Int, red: Int): IntArray {
        var answer = IntArray(2)
        var sum:Int = brown + red
        var num:Int = 0

        for(i in sum/2 downTo 3){
            if(sum % i == 0){

                if(red % (i - 2) != 0) continue
                num = red / (i - 2)
                if(sum / i == num + 2)
                {
                    answer[0] = i
                    answer[1] = sum / i
                    break
                }
            }
        }

        return answer
    }
}