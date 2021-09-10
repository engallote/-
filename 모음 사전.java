import java.util.*;

public class Main {
    public static void main(String[] args) {
    	solution("AAAAE");
	}
    public static int solution(String word) {
        int answer = 0;
        ArrayList<String> path = new ArrayList<>();
        
        dfs(0, "", path);
        
        answer = path.indexOf(word) + 1;
        return answer;
    }
	private static void dfs(int idx, String str, ArrayList<String> path) {
		if(str.length() > 0) path.add(str);
		if(idx == 5) return;
		
		dfs(idx + 1, str + "A", path);
		dfs(idx + 1, str + "E", path);
		dfs(idx + 1, str + "I", path);
		dfs(idx + 1, str + "O", path);
		dfs(idx + 1, str + "U", path);
	}
}