import java.util.*;

public class Main {
	static ArrayList<Long> arr = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		
		System.out.println(solution(expression));
	}
	public static long solution(String expression) {
		long answer = 0;
		long num = 0;
		for(char ch : expression.toCharArray()){
			if(ch >= '0' && ch <= '9'){
				num *= 10;
				num += ch - '0';
			}
			else{
				op.add(ch);
				arr.add(num);
				num = 0;
			}
		}
		if(num > 0) arr.add(num);
		
		answer = Math.max(answer, calc('*','+','-'));
		answer = Math.max(answer, calc('*','-','+'));
		answer = Math.max(answer, calc('+','*','-'));
		answer = Math.max(answer, calc('+','-','*'));
		answer = Math.max(answer, calc('-','*','+'));
		answer = Math.max(answer, calc('-','+','*'));
		
		return answer;
	}
	private static long calc(char op1, char op2, char op3) {
		long num = 0;
		ArrayList<Long> tmp = new ArrayList<>();
		ArrayList<Character> oTmp = new ArrayList<>();
		tmp.addAll(arr);
		oTmp.addAll(op);
		boolean flag = true;
		
		while(flag){
			flag = false;
			long tNum = 0;
			for(int i = 0; i < oTmp.size(); i++)
				if(oTmp.get(i) == op1){
					flag = true;
					
					int lIdx = i, rIdx = i + 1;
					if(op1 == '*') tNum = tmp.get(lIdx) * tmp.get(rIdx);
					else if(op1 == '+') tNum = tmp.get(lIdx) + tmp.get(rIdx);
					else tNum = tmp.get(lIdx) - tmp.get(rIdx);
					
					tmp.remove(rIdx);
					tmp.remove(lIdx);
					oTmp.remove(i);
					tmp.add(lIdx, tNum);
					break;
				}
		}
		
		flag = true;
		while(flag){
			flag = false;
			long tNum = 0;
			for(int i = 0; i < oTmp.size(); i++)
				if(oTmp.get(i) == op2){
					flag = true;
					
					int lIdx = i, rIdx = i + 1;
					if(op2 == '*') tNum = tmp.get(lIdx) * tmp.get(rIdx);
					else if(op2 == '+') tNum = tmp.get(lIdx) + tmp.get(rIdx);
					else tNum = tmp.get(lIdx) - tmp.get(rIdx);
					
					tmp.remove(rIdx);
					tmp.remove(lIdx);
					oTmp.remove(i);
					tmp.add(lIdx, tNum);
					break;
				}
		}
		
		flag = true;
		while(flag){
			flag = false;
			long tNum = 0;
			for(int i = 0; i < oTmp.size(); i++)
				if(oTmp.get(i) == op3){
					flag = true;
					
					int lIdx = i, rIdx = i + 1;
					if(op3 == '*') tNum = tmp.get(lIdx) * tmp.get(rIdx);
					else if(op3 == '+') tNum = tmp.get(lIdx) + tmp.get(rIdx);
					else tNum = tmp.get(lIdx) - tmp.get(rIdx);
					
					tmp.remove(rIdx);
					tmp.remove(lIdx);
					oTmp.remove(i);
					tmp.add(lIdx, tNum);
					break;
				}
		}
		
		num = tmp.get(0);
		
		return Math.abs(num);
	}
}