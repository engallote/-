import java.util.*;

public class Main {
    public static void main(String[] args) {
    	String[][] arr = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
    	solution(arr);
	}
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        boolean flag;
        char[][] map = new char[5][5];
        
        for(int k = 0; k < 5; k++) {
        	flag = true;
        	//배열 담기
        	for(int j = 0; j < 5; j++)
        		map[j] = places[k][j].toCharArray();
        	
        	
        	//계산
        	loop:for(int i = 0; i < 5; i++)
        		for(int j = 0; j < 5; j++)
        			if(map[i][j] == 'P') {
        				if(j + 1 < 5 && map[i][j + 1] != 'X') {
        					if(map[i][j + 1] == 'P') {
        						flag = false;
        						break loop;
        					}
        					if(j + 2 < 5 && map[i][j + 2] == 'P') {
        						flag = false;
        						break loop;
        					}
        				}
        				
        				if(i + 1 < 5 && map[i + 1][j] != 'X') {
        					if(map[i + 1][j] == 'P') {
        						flag = false;
        						break loop;
        					}
        					if(i + 2 < 5 && map[i + 2][j] == 'P') {
        						flag = false;
        						break loop;
        					}
        				}
        				
        				if(i + 1 < 5 && j + 1 < 5 && map[i + 1][j + 1] == 'P') {
        					if(map[i][j + 1] != 'X' || map[i + 1][j] != 'X') {
        						flag = false;
        						break loop;
        					}
        				}
        				
        				if(i + 1 < 5 && j - 1 >= 0 && map[i + 1][j - 1] == 'P') {
        					if(map[i + 1][j] != 'X' || map[i][j - 1] != 'X') {
        						flag = false;
        						break loop;
        					}
        				}
        			}
        	
        	answer[k] = flag ? 1 : 0;
        }
        
        return answer;
    }
}