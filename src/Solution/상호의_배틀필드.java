<<<<<<< HEAD
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
			// 맵에 Input 입력
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					// 현재 탱크 위치 저장
					if (isTank(arr[i][j])) {
						tank = new int[] { i, j };
					}
				}
			}
			int k = Integer.parseInt(bf.readLine());
			String cmd = bf.readLine();
			// command 입력 받기
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
			
			// 답 출력
			System.out.print("#" + t + " ");
			for(int i =0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

	// 방향 바꾸는 함수들. 로직은 같음. 구간과 위치만 다름
	private static void up() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '^';
		// 구간 검사
		if(x-1 >= 0 && x-1 < n) {
			//평지면 이동
			if(arr[x-1][y] == '.') {
				arr[x][y] = '.';
				arr[x-1][y] = '^';
				tank[0] = x-1;
				tank[1] = y;
			}
			//아니면 방향만 바꿈
			else {
				arr[x][y] = '^';
			}
		}			
	}
	
	private static void down() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = 'v';
		if(x+1 >= 0 && x+1 < n) {
			if(arr[x+1][y] == '.') {
				arr[x][y] = '.';
				arr[x+1][y] = 'v';
				tank[0] = x+1;
				tank[1] = y;
			} else {
				arr[x][y] = 'v';
			}
		}	
	}
	
	private static void left() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '<';
		if(y-1 >= 0 && y-1 < m) {
			if(arr[x][y-1] == '.') {
				arr[x][y] = '.';
				arr[x][y-1] = '<';
				tank[0] = x;
				tank[1] = y-1;
			} else {
				arr[x][y] = '<';
			}
		}	
	}
	
	private static void right() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '>';
		if(y+1 >= 0 && y+1 < m) {
			if(arr[x][y+1] == '.') {
				arr[x][y] = '.';
				arr[x][y+1] = '>';
				tank[0] = x;
				tank[1] = y+1;
			} else {
				arr[x][y] = '>';
			}
		}	
	}
	
	// S 입력 받으면
	private static void shoot() {
		int x = tank[0];
		int y = tank[1];
		// 현재 바라보는 방향 별로 for문의 범위 다름
		// '#' 만나면 break, '*' 만나면 평지로 바꾸고 break, 나머지는 continue;
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
	
	// 맵 좌표에서 tank인지 확인하는 함수
	static boolean isTank(char c) {
		if (c == '<' || c == '>' || c == '^' || c == 'v') {
			return true;
		} else {
			return false;
		}
	}
}
=======
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
			// 맵에 Input 입력
			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < m; j++) {
					arr[i][j] = str.charAt(j);
					// 현재 탱크 위치 저장
					if (isTank(arr[i][j])) {
						tank = new int[] { i, j };
					}
				}
			}
			int k = Integer.parseInt(bf.readLine());
			String cmd = bf.readLine();
			// command 입력 받기
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
			
			// 답 출력
			System.out.print("#" + t + " ");
			for(int i =0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}

	// 방향 바꾸는 함수들. 로직은 같음. 구간과 위치만 다름
	private static void up() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '^';
		// 구간 검사
		if(x-1 >= 0 && x-1 < n) {
			//평지면 이동
			if(arr[x-1][y] == '.') {
				arr[x][y] = '.';
				arr[x-1][y] = '^';
				tank[0] = x-1;
				tank[1] = y;
			}
			//아니면 방향만 바꿈
			else {
				arr[x][y] = '^';
			}
		}			
	}
	
	private static void down() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = 'v';
		if(x+1 >= 0 && x+1 < n) {
			if(arr[x+1][y] == '.') {
				arr[x][y] = '.';
				arr[x+1][y] = 'v';
				tank[0] = x+1;
				tank[1] = y;
			} else {
				arr[x][y] = 'v';
			}
		}	
	}
	
	private static void left() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '<';
		if(y-1 >= 0 && y-1 < m) {
			if(arr[x][y-1] == '.') {
				arr[x][y] = '.';
				arr[x][y-1] = '<';
				tank[0] = x;
				tank[1] = y-1;
			} else {
				arr[x][y] = '<';
			}
		}	
	}
	
	private static void right() {
		int x = tank[0];
		int y = tank[1];
		arr[x][y] = '>';
		if(y+1 >= 0 && y+1 < m) {
			if(arr[x][y+1] == '.') {
				arr[x][y] = '.';
				arr[x][y+1] = '>';
				tank[0] = x;
				tank[1] = y+1;
			} else {
				arr[x][y] = '>';
			}
		}	
	}
	
	// S 입력 받으면
	private static void shoot() {
		int x = tank[0];
		int y = tank[1];
		// 현재 바라보는 방향 별로 for문의 범위 다름
		// '#' 만나면 break, '*' 만나면 평지로 바꾸고 break, 나머지는 continue;
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
	
	// 맵 좌표에서 tank인지 확인하는 함수
	static boolean isTank(char c) {
		if (c == '<' || c == '>' || c == '^' || c == 'v') {
			return true;
		} else {
			return false;
		}
	}
}
>>>>>>> 6d3dbf7 (활주로 문제)
