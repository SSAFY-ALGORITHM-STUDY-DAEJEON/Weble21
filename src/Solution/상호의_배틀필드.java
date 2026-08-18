package Solution;

import java.io.*;
import java.util.*;

public class 상호의_배틀필드 {
	static int[] tank;
	static char[][] arr;
	static int n, m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			String nm = bf.readLine();
			StringTokenizer nmtk = new StringTokenizer(nm);
			n = Integer.parseInt(nmtk.nextToken());
			m = Integer.parseInt(nmtk.nextToken());
			arr = new char[n][m];

			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					if (isTank(arr[i][j])) {
						tank = new int[] { i, j };
					}
				}
			}
			int k = Integer.parseInt(bf.readLine());
			String cmd = bf.readLine();
			for (int i = 0; i < k; i++) {
				switch (cmd.charAt(i)) {
				case 'U':
					up();
					break;
				case 'D':
					down();
					break;
				case 'L':
					left();
					break;
				case 'R':
					right();
					break;
				case 'S':
					shoot();
					break;
				default:
					break;

				}

			}
			System.out.print("#" + t + " ");
			for(int i =0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void up() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '^';
		if(x-1 > 0 && x-1 < n) {
			if(arr[x-1][y] == '.') {
				arr[x][y] = '.';
				arr[x-1][y] = '^';
				tank[0] = x-1;
				tank[1] = y;
			}
		}			
	}
	
	private static void down() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = 'v';
		if(x-1 > 0 && x+1 < n) {
			if(arr[x+1][y] == '.') {
				arr[x][y] = '.';
				arr[x+1][y] = 'v';
				tank[0] = x+1;
				tank[1] = y;
			}
		}	
	}
	
	private static void left() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '<';
		if(y-1 > 0 && y-1 < m) {
			if(arr[x][y-1] == '.') {
				arr[x][y] = '.';
				arr[x][y-1] = '<';
				tank[0] = x;
				tank[1] = y-1;
			}
		}	
	}
	
	private static void right() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '>';
		if(y+1 > 0 && y+1 < m) {
			if(arr[x][y+1] == '.') {
				arr[x][y] = '.';
				arr[x][y+1] = '>';
				tank[0] = x;
				tank[1] = y+1;
			}
		}	
	}
	
	private static void shoot() {
		int x = tank[0];
		int y = tank[1];
		if(arr[x][y] == '^') {
			for(int i = x; i >= 0; i--) {
				char tmp = arr[i][y];
				if(tmp == '#') {
					break;
				} else if (tmp == '*') {
					arr[i][y] = '.';
					break;
				} else {
					continue;
				}
			}
		}
		if(arr[x][y] == 'v') {
			for(int i = x; i < n; i++) {
				char tmp = arr[i][y];
				if(tmp == '#') {
					break;
				} else if (tmp == '*') {
					arr[i][y] = '.';
					break;
				} else {
					continue;
				}
			}
		}
		if(arr[x][y] == '<') {
			for(int i = y; i >= 0; i--) {
				char tmp = arr[x][i];
				if(tmp == '#') {
					break;
				} else if (tmp == '*') {
					arr[x][i] = '.';
					break;
				} else {
					continue;
				}
			}
		}
		
		if(arr[x][y] == '>') {
			for(int i = y; i < m; i++) {
				char tmp = arr[x][i];
				if(tmp == '#') {
					break;
				} else if (tmp == '*') {
					arr[x][i] = '.';
					break;
				} else {
					continue;
				}
			}
		}
	}

	static boolean isTank(char c) {
		if (c == '<' || c == '>' || c == '^' || c == 'v') {
			return true;
		} else {
			return false;
		}
	}
}
