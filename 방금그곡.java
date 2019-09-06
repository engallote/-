import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution("ABC", musicinfos));
	}
	public static String solution(String m, String[] musicinfos){
		String answer = "(None)";
		int len = musicinfos.length, minTime = -1;
		m = m.replaceAll("C#", "c");
		m = m.replaceAll("D#", "d");
		m = m.replaceAll("F#", "f");
		m = m.replaceAll("G#", "g");
		m = m.replaceAll("A#", "a");
		
		for(int i = 0; i < len; i++)
		{
			musicinfos[i] = musicinfos[i].replaceAll("C#", "c");
			musicinfos[i] = musicinfos[i].replaceAll("D#", "d");
			musicinfos[i] = musicinfos[i].replaceAll("F#", "f");
			musicinfos[i] = musicinfos[i].replaceAll("G#", "g");
			musicinfos[i] = musicinfos[i].replaceAll("A#", "a");
			String[] tmp = musicinfos[i].split(",");
			String[] startTime = tmp[0].split(":");
			String[] endTime = tmp[1].split(":");
			char[] ch = tmp[3].toCharArray();
			int H1 = Integer.parseInt(startTime[0]), M1 = Integer.parseInt(startTime[1]);
			int H2 = Integer.parseInt(endTime[0]), M2 = Integer.parseInt(endTime[1]);
			int time = 0, idx = 0, clen = ch.length, time2 = 0;
			StringBuilder sb = new StringBuilder();
			
			if(H1 < H2){
				if(M2 < M1)
				{
					time = 60 - M1 + M2;
					H2--;
				}
				else time = M2 - M1;
				time += (H2 - H1)*60;
				time2 = time;
				while(time > 0)
				{
					sb.append(ch[idx]);
					idx++;
					if(idx == clen) idx = 0;
					time--;
				}
			}
			else{
				time = M2 - M1;
				time2 = time;
				while(time > 0)
				{
					sb.append(ch[idx]);
					idx++;
					if(idx == clen) idx = 0;
					time--;
				}
			}
			if(sb.toString().length() == 0) continue;
			if(sb.toString().contains(m) && minTime < time2)
			{
				minTime = time2;
				answer = tmp[2];
			}
		}
		return answer;
	}
}