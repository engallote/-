import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String skill = sc.next();
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0, len = skill_trees.length;
		char[] ch = skill.toCharArray();
		int[] arr = new int[26];
		int idx = 1;
		
		for(char c : ch) arr[c-'A'] = idx++;
		
		for(int i = 0; i < len; i++){
			char[] tmp = skill_trees[i].toCharArray();
			int p = 0;
			for(int j = 0; j < tmp.length; j++){
				if(arr[tmp[j]-'A'] != 0 && p + 1 != arr[tmp[j]-'A']){
					p = -1;
					break;
				}
			}
			
			if(p != -1) ++answer;
		}
		
		return answer;
	}
}