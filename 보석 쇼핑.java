import java.util.*;

public class Main {
	static ArrayList<Long> arr = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	public static void main(String[] args) {
		String[] gems = {"XYZ", "XYZ", "XYZ"};
		
		System.out.println(solution(gems));
	}
	public static int[] solution(String[] gems) {
		int[] answer = {1000000000, gems.length};
		HashSet<String> hs = new HashSet<>();
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < gems.length; i++)
			hs.add(gems[i]);
		
		int l = 0, r = 0, sum = 100000000, size = hs.size();
		while(r <= gems.length){
			if(hm.size() == size){
				if(sum > r - l){
					sum = r - l;
					answer[0] = l;
					answer[1] = r;
				}
				else{
					hm.replace(gems[l], hm.get(gems[l]) - 1);
					if(hm.get(gems[l]) == 0) hm.remove(gems[l]);
					++l;
				}
			}
			else{
				if(r < gems.length){
					if(!hm.containsKey(gems[r])) hm.put(gems[r], 1);
					else hm.replace(gems[r], hm.get(gems[r]) + 1);
				}
				++r;
			}
		}
		++answer[0];
		return answer;
	}
}