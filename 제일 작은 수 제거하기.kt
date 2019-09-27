class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        var min:Int = Int.MAX_VALUE
        var max:Int = Int.MIN_VALUE

        for(i in arr) {
            if(min > i) min = i
            if(max < i) max = i
        }

        if(min == max){
            answer = IntArray(1)
            answer[0] = -1
        }
        else{
            answer = IntArray(arr.size-1)
            var idx:Int = 0
            for(i in arr)
                if(i != min) answer[idx++] = i
        }
        return answer
    }
}