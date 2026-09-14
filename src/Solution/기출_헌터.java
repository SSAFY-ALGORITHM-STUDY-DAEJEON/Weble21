package Solution;

import java.util.*;
import java.io.*;

public class 기출_헌터 {
	public static class Hunt {
		int x;
		int y;
		int monster;
		Hunt(int x, int y, int monster) {
			this.x = x;
			this.y = y;
			this.monster = monster;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
			int[][] arr = new int[n][n];
			ArrayList<Hunt> canGo = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for(int j = 0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] != 0) {
						canGo.add(new Hunt(i, j, arr[i][j]));
					}
				}
			}
			result = 999999999;
			// 순열 만들기
			Hunt[] plan = new Hunt[canGo.size()];
			makePlan(0, canGo, plan, new boolean[canGo.size()]);
			
			
			
			
			System.out.println("#" + t + " " + result);
		}	
		
	}

	private static void makePlan(int k, ArrayList<Hunt> canGo, Hunt[] plan, boolean[] v) {
		// basis
		if(k == plan.length) {
//			for(int i = 0; i<plan.length; i++) {
//				System.out.print(plan[i].monster + " ");
//			}
//			System.out.println();
			
			calculate(plan);
			return;
		}
		
		
		//inductive
		for(int i = 0; i < canGo.size(); i++) {
			if(!v[i]) {
				Hunt tmp;
				tmp = canGo.get(i);
				if(tmp.monster < 0) {
					if(find(plan, tmp.monster, k)) {
						v[i] = true;
						plan[k] = tmp;
						makePlan(k+1, canGo, plan, v);
						v[i] = false;
					} else {
						continue;
					}
				} else {
					v[i] = true;
					plan[k] = tmp;
					makePlan(k+1, canGo, plan, v);
					v[i] = false;
				}
				
				
			}
			
		}
		
	}
	static int result = 999999999;

	private static boolean find(Hunt[] plan, int monster, int k) {
		if(k == 0) {
			return false;
		}
		for(int i = 0; i < k; i++) {
			if(plan[i].monster == monster * -1) {
				return true;
			}
		}
		return false;
		
	}

	private static void calculate(Hunt[] plan) {
		int x = 0;
		int y = 0;
		int sum = 0;
		for(int i = 0; i < plan.length; i++) {
			int dx = Math.abs(plan[i].x - x);
			int dy = Math.abs(plan[i].y - y);
			sum = dx + dy + sum;
			if(sum >= result) return;
			x = plan[i].x;
			y = plan[i].y;
		}
		result = Math.min(sum, result);
	}
}
