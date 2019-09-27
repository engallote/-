class Solution {
    fun solution(arr: IntArray): Double {
        var answer:Double = 0.0

        for(i in arr)
            answer += i

        answer /= arr.size
        return answer
    }
}