package Solution;

import java.io.*;
import java.util.*;

public class 홈방범서비스 {
	static ArrayList<int[]> house;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n, m;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			house = new ArrayList<>();
			// 배열 받기
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) {
						house.add(new int[] {i, j});
					}
				}
			}
			int max = 0;
			for(int k = 1; k <= 2*n; k++) {
				int fee = ((k*2)-1) * ((k*2)-1) / 2 + 1;
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						//좌표 옮기기
						int cnt = 0;
						for(int l = 0; l < house.size(); l++) {
							if(chk(i, j, house.get(l), k)) {
								cnt++;
							}
						}
						if((cnt*m) >= fee) {
							max = Math.max(cnt, max);	
						}
						
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}

	private static boolean chk(int x, int y, int[] home, int k) {
		int dis_x = Math.abs(x - home[0]); 
				
		int dis_y = Math.abs(y - home[1]);
		
		int dis = dis_x + dis_y;
		
		if(k > dis) {
			return true;
		} else {
			return false;
		}
	
	}
}
