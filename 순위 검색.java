import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String[] a = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
    	String[] b= {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
    	solution(a, b);
	}
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Integer>[][][][] aly = new ArrayList[3][2][2][2];
        
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 2; j++)
        		for(int k = 0; k < 2; k++)
        			for(int l = 0; l < 2; l++)
        				aly[i][j][k][l] = new ArrayList<>();
        
        for(int i = 0; i < info.length; i++) {
        	String[] str = info[i].split(" ");
        	int idx1 = 0, idx2 = 0, idx3 = 0, idx4 = 0;
        	
        	if(str[0].equals("java")) idx1 = 0;
        	else if(str[0].equals("cpp")) idx1 = 1;
        	else idx1 = 2;
        	
        	if(str[1].equals("backend")) idx2 = 0;
        	else idx2 = 1;
        	
        	if(str[2].equals("junior")) idx3 = 0;
        	else idx3 = 1;
        	
        	if(str[3].equals("chicken")) idx4 = 0;
        	else idx4 = 1;
        	
        	aly[idx1][idx2][idx3][idx4].add(Integer.parseInt(str[4]));
        }
        
        for(int i = 0; i < 3; i++)
        	for(int j = 0; j < 2; j++)
        		for(int k = 0; k < 2; k++)
        			for(int l = 0; l < 2; l++)
        				Collections.sort(aly[i][j][k][l]);
        
        
        for(int q = 0; q < query.length; q++) {
        	String[] str = query[q].split(" and ");
        	String[] str2 = str[3].split(" ");
        	int score = Integer.parseInt(str2[1]);
//        	System.out.println(str[0] + "," + str[1] + "," + str[2] + "," + str2[0]+"," + str2[1]);
        	int si = 0, ei = 0, sj = 0, ej = 0, sk = 0, ek = 0, sl = 0, el = 0, sum = 0;
        	
        	if(str[0].equals("java")) si = ei = 0;
        	else if(str[0].equals("cpp")) si = ei = 1;
        	else if(str[0].equals("python")) si = ei = 2;
        	else ei = 2;
        	
        	if(str[1].equals("backend")) sj = ej = 0;
        	else if(str[1].equals("frontend")) sj = ej = 1;
        	else ej = 1;
        	
        	if(str[2].equals("junior")) sk = ek = 0;
        	else if(str[2].equals("senior")) sk = ek = 1;
        	else ek = 1;
        	
        	if(str2[0].equals("chicken")) sl = el = 0;
        	else if(str2[0].equals("pizza")) sl = el = 1;
        	else el = 1;
        	
        	for(int i = si; i <= ei; i++)
        		for(int j = sj; j <= ej; j++)
        			for(int k = sk; k <= ek; k++)
        				for(int l = sl; l <= el; l++) {
        					if(aly[i][j][k][l].isEmpty()) continue;
        					
        					int le = 0, ri = aly[i][j][k][l].size() - 1, mid, idx = Integer.MAX_VALUE;
        					while(le <= ri) {
        						mid = (le + ri) / 2;
        						
        						if(aly[i][j][k][l].get(mid) < score) le = mid + 1;
        						else {
        							idx = mid;
        							ri = mid - 1;
        						}
        					}
        					
        					if(idx == Integer.MAX_VALUE) continue;
        					sum += aly[i][j][k][l].size() - idx;
        				}
        	answer[q] += sum;
        }
        
        return answer;
    }
}