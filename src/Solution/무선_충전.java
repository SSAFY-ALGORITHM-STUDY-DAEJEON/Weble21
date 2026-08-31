<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.*;

public class 무선_충전 {

	static class AP {
		int row;
		int col;
		int c;
		int p;

		AP(int row, int col, int c, int p) {
			this.row = row;
			this.col = col;
			this.c = c;
			this.p = p;
		}
	}

	static int[] curA;
	static int[] curB;
	static AP[] arrAP;

	static void move(int[] cur, int i) {
		switch (i) {
		case 1:
			cur[0]--;
			break;
		case 2:
			cur[1]++;
			break;
		case 3:
			cur[0]++;
			break;
		case 4:
			cur[1]--;
			break;
		default:
			break;
		}

	}
	
	static int distance(int cur[], AP ap) {
		int tmp1 = Math.abs(cur[1]-ap.col);
		int tmp2 = Math.abs(cur[0]-ap.row);
		return tmp1 + tmp2;
	}
	
	static int charge() {
		int max = 0;
		for(int i = -1; i<arrAP.length; i++) {
			for(int j = -1; j<arrAP.length; j++) {
				// 연결 전 초기화
				int tmpA = 0;
				int tmpB = 0;
				
				// 어떤거도 충전가능X
				if(i == -1 && j == -1) continue;
				// A 선택
				if(i != -1) {
					AP apA = arrAP[i];
					if(distance(curA, apA) <= apA.c) {
						tmpA = apA.p;
					}
				}
				
				// B 선택
				if(j != -1) {
					AP apB = arrAP[j];
					if(distance(curB, apB) <= apB.c) {
						tmpB = apB.p;
					}
				}
				int sum=0;
				// 고르는게 겹치는지 확인
				if(i == j) {
					AP apA = arrAP[i];
					AP apB = arrAP[j];
					if(distance(curA, apA) <= apA.c && distance(curB, apB) <= apB.c && i != -1) {
						sum = arrAP[i].p;
					}
				} else {
					sum = tmpA + tmpB;
				}
				max = Math.max(sum, max);
			}
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int m, a;
			String mastr = bf.readLine();
			StringTokenizer ma = new StringTokenizer(mastr);
			m = Integer.parseInt(ma.nextToken());
			a = Integer.parseInt(ma.nextToken());

			int[] arrA = new int[m];
			int[] arrB = new int[m];

			// a 이동 정보
			String strA = bf.readLine();
			StringTokenizer stA = new StringTokenizer(strA);
			for (int i = 0; i < m; i++) {
				arrA[i] = Integer.parseInt(stA.nextToken());
			}

			// b 이동 정보
			String strB = bf.readLine();
			StringTokenizer stB = new StringTokenizer(strB);
			for (int i = 0; i < m; i++) {
				arrB[i] = Integer.parseInt(stB.nextToken());
			}

			// AP 정보 입력받기
			arrAP = new AP[a];
			for (int j = 0; j < a; j++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int col = Integer.parseInt(st.nextToken()) - 1;
				int row = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				arrAP[j] = new AP(row, col, c, p);
			}

			// 이동
			curA = new int[] { 0, 0 };
			curB = new int[] { 9, 9 };
			int sum = 0;
			sum += charge();
			for (int i = 0; i < m; i++) {
				move(curA, arrA[i]);
				move(curB, arrB[i]);
				sum += charge();
				
			}
			
			System.out.println("#" + t + " " + sum);

		} // tc 끝
	}
}
=======
package Solution;

import java.io.*;
import java.util.*;

public class 무선_충전 {

	static class AP {
		int row;
		int col;
		int c;
		int p;

		AP(int row, int col, int c, int p) {
			this.row = row;
			this.col = col;
			this.c = c;
			this.p = p;
		}
	}

	static int[] curA;
	static int[] curB;
	static AP[] arrAP;

	static void move(int[] cur, int i) {
		switch (i) {
		case 1:
			cur[0]--;
			break;
		case 2:
			cur[1]++;
			break;
		case 3:
			cur[0]++;
			break;
		case 4:
			cur[1]--;
			break;
		default:
			break;
		}

	}
	
	static int distance(int cur[], AP ap) {
		int tmp1 = Math.abs(cur[1]-ap.col);
		int tmp2 = Math.abs(cur[0]-ap.row);
		return tmp1 + tmp2;
	}
	
	static int charge() {
		int max = 0;
		for(int i = -1; i<arrAP.length; i++) {
			for(int j = -1; j<arrAP.length; j++) {
				// 연결 전 초기화
				int tmpA = 0;
				int tmpB = 0;
				
				// 어떤거도 충전가능X
				if(i == -1 && j == -1) continue;
				// A 선택
				if(i != -1) {
					AP apA = arrAP[i];
					if(distance(curA, apA) <= apA.c) {
						tmpA = apA.p;
					}
				}
				
				// B 선택
				if(j != -1) {
					AP apB = arrAP[j];
					if(distance(curB, apB) <= apB.c) {
						tmpB = apB.p;
					}
				}
				int sum=0;
				// 고르는게 겹치는지 확인
				if(i == j) {
					AP apA = arrAP[i];
					AP apB = arrAP[j];
					if(distance(curA, apA) <= apA.c && distance(curB, apB) <= apB.c && i != -1) {
						sum = arrAP[i].p;
					}
				} else {
					sum = tmpA + tmpB;
				}
				max = Math.max(sum, max);
			}
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int m, a;
			String mastr = bf.readLine();
			StringTokenizer ma = new StringTokenizer(mastr);
			m = Integer.parseInt(ma.nextToken());
			a = Integer.parseInt(ma.nextToken());

			int[] arrA = new int[m];
			int[] arrB = new int[m];

			// a 이동 정보
			String strA = bf.readLine();
			StringTokenizer stA = new StringTokenizer(strA);
			for (int i = 0; i < m; i++) {
				arrA[i] = Integer.parseInt(stA.nextToken());
			}

			// b 이동 정보
			String strB = bf.readLine();
			StringTokenizer stB = new StringTokenizer(strB);
			for (int i = 0; i < m; i++) {
				arrB[i] = Integer.parseInt(stB.nextToken());
			}

			// AP 정보 입력받기
			arrAP = new AP[a];
			for (int j = 0; j < a; j++) {
				String str = bf.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int col = Integer.parseInt(st.nextToken()) - 1;
				int row = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				arrAP[j] = new AP(row, col, c, p);
			}

			// 이동
			curA = new int[] { 0, 0 };
			curB = new int[] { 9, 9 };
			int sum = 0;
			sum += charge();
			for (int i = 0; i < m; i++) {
				move(curA, arrA[i]);
				move(curB, arrB[i]);
				sum += charge();
				
			}
			
			System.out.println("#" + t + " " + sum);

		} // tc 끝
	}
}
>>>>>>> 6d3dbf7 (활주로 문제)
