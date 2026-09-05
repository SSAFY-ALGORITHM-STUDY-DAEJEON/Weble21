package Solution;

import java.io.*;
import java.util.*;

//stack
public class 쇠막대기_자르기 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= n; t++) {
			//Stack<> 사용하니 시간초과 -> ArrayDeque로 사용
			ArrayDeque<Integer> s = new ArrayDeque<>();
			String str = bf.readLine();
			int sum = 0;
			for(int i = 0; i<str.length() - 1; i++) {
				// 입력 확인
				if(str.charAt(i) == '(') {
					if(str.charAt(i+1) == ')') {
						// 레이저일때 확인 -> stack 크기만큼 sum 추가
						sum += s.size();
						// 다음꺼까지 탐색했으니, index 1 추가
						i++;
					} else {
						// 레이저 아님 '(' 이면 스택에 추가 -> 값은 1로 카운트 시작
						if(str.charAt(i) == '(') {
							s.add(1);
						} else {
							continue;
						}
					}
				} else {
					// ')' 이면 스택 크기 줄이고, 자르고 남은 막대 있으니 sum+1
					s.pop();
					sum++;
				}
			} // str 분석 for문 끝
			if(!s.isEmpty()) {
				s.pop();
				sum++;
			}
			
			System.out.println("#" + t + " " + sum);
		} //t for문 끝
	}
}
