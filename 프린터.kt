import java.io.BufferedInputStream
import java.lang.StringBuilder
import java.util.*

fun main(args : Array<String>){
	var priorities = intArrayOf(2, 2, 2, 1, 3, 4)
	println(solution(priorities, 3))
}
fun solution(priorities: IntArray, location: Int): Int {
	var answer = 0
	val len:Int = priorities.size
    var res:IntArray = IntArray(len,{i->0})
    var pq:PriorityQueue<Int> = PriorityQueue<Int>(Collections.reverseOrder())
    var num:Int = 0
    var idx:Int = 1
    var start:Int = 0

    for(i in 0..len-1) pq.offer(priorities[i])

	var flag:Boolean = false
    while(!pq.isEmpty()){
    	num = pq.poll()
		flag = false
    	for(i in start..len-1){
    		if(priorities[i] == num){
    			res[i] = idx
    			priorities[i] = -1
    			start = i + 1
				flag = true
    			if(start >= len) start = 0
    			break
    		}
    	}
		if(!flag){
			for(i in 0..start-1){
    			if(priorities[i] == num){
	    			res[i] = idx
	    			priorities[i] = -1
	    			start = i + 1
					flag = true
	    			if(start >= len) start = 0
	    			break
	    		}
	    	}
		}
	    idx++
	}
	
	answer = res[location]
	return answer
}