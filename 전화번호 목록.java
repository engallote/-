import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] phone_book = new String[N];
		
		for(int i = 0; i < N; i++)
			phone_book[i] = sc.next();
	}
    public boolean solution(String[] phone_book) {
        boolean flag = true;
        int N = phone_book.length;
        Arrays.sort(phone_book);

        for(int i = 0; i < N && flag; i++){
            for(int j = i + 1; j < N; j++){
                if(phone_book[i].charAt(0) == phone_book[j].charAt(0)){
                    int k = 0;
                    for(k = 0; k < phone_book[i].length(); k++)
                        if(phone_book[i].charAt(k) != phone_book[j].charAt(k)) break;

                    if(k == phone_book[i].length()){
                        flag = false;
                        break;
                    }
                }
                else break;
            }
        }
        return flag;
    }
}