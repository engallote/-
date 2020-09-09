import java.util.*;

public class Main {
	public static void main(String[] args) {
		int[] number = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(solution(number, hand));
	}
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int lx = 3, ly = 0, rx = 3, ry = 2;
		Pair[] arr = new Pair[10];
		arr[0] = new Pair(3, 1);
		arr[1] = new Pair(0, 0);
		arr[2] = new Pair(0, 1);
		arr[3] = new Pair(0, 2);
		arr[4] = new Pair(1, 0);
		arr[5] = new Pair(1, 1);
		arr[6] = new Pair(1, 2);
		arr[7] = new Pair(2, 0);
		arr[8] = new Pair(2, 1);
		arr[9] = new Pair(2, 2);
		
		for(int i : numbers){
			if(i == 1 || i == 4 || i == 7){
				//왼손
				answer += "L";
				lx = arr[i].x;
				ly = arr[i].y;
			}
			else if(i == 3 || i == 6 || i == 9){
				//오른손
				answer += "R";
				rx = arr[i].x;
				ry = arr[i].y;
			}
			else{
				int ld = Math.abs(lx - arr[i].x) + Math.abs(ly - arr[i].y);
				int rd = Math.abs(rx - arr[i].x) + Math.abs(ry - arr[i].y);
				
				if(ld == rd){
					if(hand.equals("right")){
						answer += "R";
						rx = arr[i].x;
						ry = arr[i].y;
					}
					else{
						answer += "L";
						lx = arr[i].x;
						ly = arr[i].y;
					}
				}
				else if(ld < rd){
					answer += "L";
					lx = arr[i].x;
					ly = arr[i].y;
				}
				else{
					answer += "R";
					rx = arr[i].x;
					ry = arr[i].y;
				}
			}
		}
		
		return answer;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}