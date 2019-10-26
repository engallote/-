class Solution {
    fun solution(n: Int): Int {
        var answer = solve(n,1, 1, 0)
        return answer
    }
    private fun solve(n:Int, idx: Int, l: Int, r: Int): Int {
        if(idx == n) return 1
        var ret:Int = 0
        if(l <= idx) ret += solve(n, idx + 1, l + 1, r)
        if(l > r) ret += solve(n, idx, l, r + 1)
        return ret
    }
}