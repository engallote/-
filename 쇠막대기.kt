import java.util.*
class Solution {
    fun solution(arrangement: String): Int {
        var answer = 0
        var st:Stack<String> = Stack()
        var arr:Array<Boolean> = Array<Boolean>(arrangement.length, {i->false})
        
        for(i in arrangement.indices){
            if(arr[i]) continue
            if(arrangement[i] == '(' && arrangement[i + 1] == ')'){
                answer += st.size
                arr[i] = true
                arr[i + 1] = true
            }
            else if(arrangement[i] == '(' && arrangement[i + 1] == '('){
                st.push(arrangement[i]+"")
            }
            else if(arrangement[i] == ')'){
                answer++
                st.pop()
            }
        }
        return answer
    }
}