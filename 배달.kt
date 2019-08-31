import java.util.*
import java.io.BufferedInputStream

fun main(args : Array<String>) = with(Scanner(BufferedInputStream(System.`in`))){
	var N:Int = nextInt()	
    var road:Array<IntArray> = Array<IntArray>(7, {IntArray(3)})
	
	for(i in 0..6){
		road[i][0] = nextInt()
		road[i][1] = nextInt()
		road[i][2] = nextInt()
	}
	
	var K:Int = nextInt()
    println(solution(N, road, K))
}
fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
	var answer:Int = 0
	var len:Int = road.size - 1
	var dist:IntArray = IntArray(N+1, {i->100000000})
	dist[1] = 0
	var flag:Boolean = true
	
	while(flag){
		flag = false
		
		for(i in 0..len){
			if(dist[road[i][0]] + road[i][2] < dist[road[i][1]]){
				flag = true
				dist[road[i][1]] = dist[road[i][0]] + road[i][2]
			}
			if(dist[road[i][1]] + road[i][2] < dist[road[i][0]]){
				flag = true
				dist[road[i][0]] = dist[road[i][1]] + road[i][2]
			}
		}
	}
	
	for(i in 1..N)
	{
		if(dist[i] <= k) answer++
//		println(">>>> ${dist[i]}")
	}
	
	return answer;
}