import java.util.*
import java.io.BufferedInputStream

var pq:PriorityQueue<String> = PriorityQueue<String>()
    fun main(args : Array<String>) = with(Scanner(BufferedInputStream(System.`in`))){
        var tickets:Array<Array<String>> = Array<Array<String>>(5,{Array<String>(2,{i->""})})

        for(i in 0..4){
            tickets[i][0] = next()
            tickets[i][1] = next()
        } 

        println(solution(tickets))
    }
    fun solution(tickets:Array<Array<String>>):Array<String>{
        var answer = arrayOf<String>()
        var len = tickets.size
		var q:Queue<Int> = LinkedList<Int>()
        var chk:Array<Boolean> = Array<Boolean>(len, {i->false})
        var visit:Array<Int> = Array<Int>(len, {i->-1})
		var x:Int = 0
		for(i in 0..len-1)
			if(tickets[i][0].equals("ICN")) q.offer(i)
		
		while(!q.isEmpty()){
			x = q.poll()
//			println(">>> $x")
			Arrays.fill(chk, false)
			Arrays.fill(visit, -1)
			chk[x] = true
			visit[0] = x
			solve(1, tickets[x][1], len, chk, visit, tickets);
		}
        
        var tmp: List<String> = pq.peek().split(" ")
//		while(!pq.isEmpty()){
//			println(pq.poll())
//		}
		var size:Int = tmp.size
		answer = Array<String>(size, {i->""})
//		println(tmp)
        var idx:Int = 0
        for(str in tmp){
            answer[idx] = str
            idx++
        }
        return answer
    }
    fun solve(idx:Int, start:String, len:Int, chk:Array<Boolean>, visit:Array<Int>, tickets: Array<Array<String>>){
        if(idx == len) {
            var sb:StringBuilder = StringBuilder()
            sb.append("ICN " + tickets[visit[0]][1] + " ")
            for(i in 1..len-1)
                sb.append(tickets[visit[i]][1] + " ")

//			println(">> " + sb.toString())
            pq.offer(sb.toString().trim())
            return
        }

        for(i in 0..len-1){
            if(!chk[i] && tickets[i][0].equals(start)){
                chk[i] = true
                visit[idx] = i
                solve(idx + 1, tickets[i][1], len, chk, visit, tickets)
                chk[i] = false
                visit[idx] = -1
            }
        }
    }