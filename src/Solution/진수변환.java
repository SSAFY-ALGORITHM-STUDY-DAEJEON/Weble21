package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 진수변환 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		int tmp = Integer.parseInt(str, 2);
		int flag = str.charAt(0) - '0';
		if(flag == 1) {
			int negative = -128;
			tmp -= 128;
			tmp += negative;
		}
		System.out.println(tmp);
		
		
		
	}
}
