import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int l = 0, r = people.length - 1;
		
		while(l <= r){
			if(l == r){
				++answer;
				break;
			}
			else if(people[l] + people[r] <= limit){
				++answer;
				++l;
				--r;
			}
			else{
				++answer;
				--r;
			}
		}
		
		return answer;
	}
}