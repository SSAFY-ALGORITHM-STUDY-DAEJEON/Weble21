package Solution;

import java.io.*;
import java.util.*;

public class 면접 {
	static int score, cnt;
	
	// 배열따라 계산하기 - false면 문제 맞음, true면 틀림 -> cnt 초기화
	private static void calculate(boolean[] arr, int k) {
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i]) {
				cnt++;
				score++;
				if(cnt == k) {
					score *= 2;
					cnt = 0;
				} 
			} else {
				cnt = 0;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			boolean[] arr = new boolean[n];
			
			score = 0;
			cnt = 0;
			// n과 m이 같으면 계산 필요 없음
			if(n != m) {
				// 틀릴수있는 갯수
				int wrong = n - m;
				// 넣을 수 있는 갯수
				int can = n / k;
				
				// 우선 배열 안에 k의 배수들은 다 틀리게 만들기
				int tmp = wrong;
				for (int i = n - 1; i >= 0; i--) {
					if(tmp == 0) break;
					
					if ((i + 1) % k == 0) {
						arr[i] = true;
						tmp--;
					} else {
						arr[i] = false;
					}
				}
				// 추가로 더 틀릴 수 있는게 남았다면 추가로 true 만들기
				int tmp2 = wrong - can;
				if(tmp2 > 0) {
					for(int i = 0; i< n; i++) {
						if(tmp2 == 0) break;
						if(arr[i]) {
							continue;
						} else {
							arr[i] = true;
							tmp2--;
						}
					}
				}
				
			}
			
			System.out.println(Arrays.toString(arr));
			calculate(arr, k);
			System.out.println(score);

		}
	}

}
