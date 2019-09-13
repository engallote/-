import java.lang.Math.*
import java.util.*

class Solution {
    fun main(args: Array<String>){
        var numbers = intArrayOf(1,1,1,1,1)
        println(solution(numbers, 3))
    }

    fun solution(numbers: IntArray, target: Int): Int {
        var answer:Int = 0

        answer = find(0, 0, numbers, target)


        return answer
    }
    fun find(idx:Int, sum:Int, numbers: IntArray, target: Int):Int{
        if(idx == numbers.size){
            if(sum == target) return 1
            else return 0
        }
        var ret:Int = 0

        ret += find(idx + 1, sum + numbers[idx], numbers, target)
        ret += find(idx + 1, sum - numbers[idx], numbers, target)
        return ret
    }
}