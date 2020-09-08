import java.util.*;

public class Main {
	public static void main(String[] args) {
		String s = "{{123}}";
		
		System.out.println(solution(s));
	}
	public static int[] solution(String s) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		int N = 0, num = 0;
		
		for(char ch : s.toCharArray()){
			if(ch >= '0' && ch <= '9'){
				if(num == 0) num += ch - '0';
				else{
					num *= 10;
					num += ch - '0';
				}
			}
			else{
				if(num == 0) continue;
				if(hm.containsKey(num)) hm.replace(num, hm.get(num) + 1);
				else{
					hm.put(num, 1);
					++N;
				}
				num = 0;
			}
		}
		
		if(num > 0){
			if(hm.containsKey(num)) hm.replace(num, hm.get(num) + 1);
			else{
				hm.put(num, 1);
				++N;
			}
		}
		
		int answer[] = new int[N];
		Iterator<Integer> it = hm.keySet().iterator();
		while(it.hasNext()){
			int key = it.next();
			int value = hm.get(key);
			
			answer[N-value] = key;
		}
		
		return answer;
	}
}