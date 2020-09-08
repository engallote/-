import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] room_number = {1,3,4,1,3,1};
		long k = 10;
		
		System.out.println(solution(k, room_number));
	}
	public static long[] solution(long k, int[] room_number) {
		int N = room_number.length;
		long[] answer = new long[N];
		HashMap<Long, Long> hm = new HashMap<>();
		
		for(int i = 0; i < N; i++)
			answer[i] = find(room_number[i], hm);
		
		return answer;
	}
	private static long find(long num, HashMap<Long, Long> hm) {
		if(!hm.containsKey(num)){
			hm.put(num, num + 1);
			return num;
		}
		long room = find(hm.get(num), hm);
		hm.put(num, room + 1);
		return room;
	}
}