class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var arr:IntArray = IntArray(n+1, {i->1})
        for(i in lost) arr[i] = -1
        for(i in reserve) arr[i] += 2
        for(i in reserve){
            if(arr[i] == 1) continue
            if(arr[i-1] == -1) arr[i-1] = 3
            else if(i + 1 <= n && arr[i+1] == -1) arr[i+1] = 3
        }

        for(i in 1..n){
            if(arr[i] > 0) answer++
        }
        return answer
    }
}