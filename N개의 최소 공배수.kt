class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        var flag:Boolean = true
        arr.sort()
        for (i in arr[0]..1000000000){
            flag = true
            for(j in arr)
                if(i % j != 0){
                    flag = false
                    break
                }
            if(flag){
                answer = i
                break
            }
        }
        return answer
    }
}