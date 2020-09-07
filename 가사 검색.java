import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		
		System.out.println(solution(words, queries));
	}
	public static int[] solution(String[] words, String[] queries) {
		int len = queries.length, N = words.length, strLen;
		int[] answer = new int[len];
		Trie[] pre = new Trie[10001], suf = new Trie[10001];
		
		for(int i = 1; i <= 10000; i++){
			pre[i] = new Trie();
			suf[i] = new Trie();
		}
		
		for(int i = 0; i < N; i++){
			strLen = words[i].length();
			pre[strLen].insert(words[i].toCharArray());
			suf[strLen].insert(new StringBuilder(words[i]).reverse().toString().toCharArray());
		}
		
		for(int i = 0; i < len; i++){
			strLen = queries[i].length();
			
			if(queries[i].charAt(0) != '?'){
				if(pre[strLen] != null)
					answer[i] = pre[strLen].search(queries[i].toCharArray());
			}
			else{
				if(suf[strLen] != null)
					answer[i] = suf[strLen].search(new StringBuilder(queries[i]).reverse().toString().toCharArray());
			}
		}
		
		return answer;
	}
}
class Trie{
	int num;
	Trie[] child;
	
	Trie(){
		child = new Trie[26];
		num = 0;
	}
	public void insert(char[] word){
		Trie par = this;
		for(char ch : word){
			++par.num;
			if(par.child[ch-'a'] == null)
				par.child[ch-'a'] = new Trie();
			par = par.child[ch-'a'];
		}
	}
	public int search(char[] word){
		Trie par = this;
		for(char ch : word){
			if(ch == '?') return par.num;
			if(par.child[ch-'a'] == null) return 0;
			else par = par.child[ch-'a'];
		}
		return par.num;
	}
}