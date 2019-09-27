class Solution {
    fun solution(n: Int, m: Int): IntArray {
        var answer = IntArray(2)

        var g:Int = gcd(n, m)
        answer[0] = g
        if(g == 1){
            answer[1] = n * m
        }
        else{
            if(m % n == 0) answer[1] = m
            var tmp:Int = g
            for(i in 1..100000000){
                tmp = g * i
                if(tmp % n == 0 && tmp % m == 0){
                    answer[1] = tmp
                    break
                }
            }
        }
        return answer
    }
    fun gcd(n:Int, m:Int) : Int{
        if(m == 0) return n
        if(n < m) return gcd(n, m % n)
        else return gcd(m, n % m)
    }
}