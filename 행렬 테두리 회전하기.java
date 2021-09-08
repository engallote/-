import java.util.*;

public class Main {
    public static void main(String[] args) {
    	int[][] arr = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
    	solution(6, 6, arr);
	}
    public static int[] solution(int rows, int columns, int[][] queries) {
    	int[][] map = new int[100][100];
    	int num = 1;
    	for(int i = 0; i < rows; i++)
    		for(int j = 0; j < columns; j++)
    			map[i][j] = num++;
    	
        int[] answer = new int[queries.length];
        
        for(int q = 0; q < queries.length; q++) {
        	int x1 = queries[q][0] - 1;
        	int y1 = queries[q][1] - 1;
        	int x2 = queries[q][2] - 1;
        	int y2 = queries[q][3] - 1;
        	int min = map[x1][y1];
        	num = map[x1][y1];
        	
        	int x = x1, y = y1;
        	
        	while(x < x2) {
        		map[x][y] = map[x + 1][y];
        		min = Math.min(map[x][y], min);
        		x += 1;
        	}
        	
        	while(y < y2) {
        		map[x][y] = map[x][y + 1];
        		min = Math.min(map[x][y], min);
        		y += 1;
        	}
        	
        	while(x > x1) {
        		map[x][y] = map[x - 1][y];
        		min = Math.min(map[x][y], min);
        		x -= 1;
        	}
        	
        	while(y > y1 + 1) {
        		map[x][y] = map[x][y - 1];
        		min = Math.min(map[x][y], min);
        		y -= 1;
        	}
        	
        	map[x][y] = num;
        	answer[q] = min;
        }
        
        return answer;
    }
}