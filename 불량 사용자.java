import java.util.*;

public class Main {
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		System.out.println(solution(user_id, banned_id));
	}
	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		
		answer = dfs(0, 0, user_id, banned_id);
		return answer;
	}
	private static int dfs(int idx, int chk, String[] user_id, String[] banned_id) {
		if(idx == banned_id.length){
			if(hs.contains(chk)) return 0;
			hs.add(chk);
			return 1;
		}
		int ret = 0;
		
		for(int i = 0; i < user_id.length; i++){
			if((chk&(1<<i)) != 0 || user_id[i].length() != banned_id[idx].length()) continue;
			boolean flag = true;
			for(int k = 0; k < user_id[i].length(); k++)
				if(banned_id[idx].charAt(k) != '*' && banned_id[idx].charAt(k) != user_id[i].charAt(k)){
					flag = false;
					break;
				}
			
			if(flag) ret += dfs(idx + 1, chk|(1<<i), user_id, banned_id);
		}
		return ret;
	}
}