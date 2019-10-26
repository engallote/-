import kotlin.collections.HashMap

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var sum:Int = 0
        var hs:HashMap<String, Int> = HashMap()
        var len:Int = clothes.size
        for(i in 0 until len){
            if(hs.containsKey(clothes[i][1])) {
                var num:Int = hs[clothes[i][1]]?.plus(1) ?: 0
                hs.replace(clothes[i][1], num)
            }
            else hs.put(clothes[i][1], 1)
        }

        var it:Iterator<String> = hs.keys.iterator()
        while(it.hasNext()){
            var key:String = it.next()
            var value = hs.get(key)
            if (value != null) {
                sum = value + 1
                answer *= sum
            }
        }
        answer -= 1

        return answer
    }
}