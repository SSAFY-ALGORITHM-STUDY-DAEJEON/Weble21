package codeTree;

import java.io.*;
import java.util.*;

public class 코드트리_단순한동전챙기기 {
	static int n;
	static char[][] arr;
	static int[] st = new int[2];
	static int[] end = new int[2];
	static boolean[][] v;
	static ArrayList<Coin> coin;
	
	static class Coin {
		int num;
		int x;
		int y;
		
		Coin(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new char[n][n];
		coin = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'S') {
					st[0] = i;
					st[1] = j;
				} else if (arr[i][j] == 'E') {
					end[0] = i;
					end[1] = j;
				} else if (arr[i][j] != '.') {
					Coin c = new Coin(arr[i][j]-'0', i, j);
					coin.add(c);
				}

			}
		}
		
		makeSet(0, new Coin[3], new boolean[coin.size()]);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		

	}

	private static void makeSet(int k, Coin[] plan, boolean[] v) {
		if (k == plan.length) {
//			for(int i = 0; i<plan.length; i++) {
//				System.out.print(plan[i].num + " ");
//			}
//			System.out.println();
			calculate(plan);
			return;
		}

		for (int i = 0; i < coin.size(); i++) {
			if(!v[i]) {
				Coin tmp;
				tmp = coin.get(i);
				if(k != 0) {
					if(plan[k-1].num > tmp.num) {
						// 이전에 더 큰 값이 있으면
						continue;
					}
					else {
						v[i] = true;
						plan[k] = coin.get(i);
						makeSet(k + 1, plan, v);
						v[i] = false;
					}
				} else {
					v[i] = true;
					plan[k] = coin.get(i);
					makeSet(k + 1, plan, v);
					v[i] = false;
				}
			}
			
		}

	}


	static int min = Integer.MAX_VALUE;
	

	private static void calculate(Coin[] plan) {
		int res = 0;
		int cur_x = st[0];
		int cur_y = st[1];
		for(int i = 0; i < plan.length; i++) {
			int disX = Math.abs(cur_x - plan[i].x);
			int disY = Math.abs(cur_y - plan[i].y);
			int dis = disX+disY;
			res += dis;
			cur_x = plan[i].x;
			cur_y = plan[i].y;
		}
		int disX = Math.abs(cur_x - end[0]);
		int disY = Math.abs(cur_y - end[1]);
		int dis = disX+disY;
		res += dis;
		
		min = Math.min(res, min);
	}

}
