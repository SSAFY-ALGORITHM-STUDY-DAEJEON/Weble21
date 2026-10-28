package samsung;

import java.io.*;
import java.util.*;

public class 코디의퍼즐공방 {
	static int n;
	static Puzzle[][] arr;

	public static class Puzzle {
		int row;
		int col;
		int up;
		int right;
		int down;
		int left;

		Puzzle(int row, int col, int up, int right, int down, int left) {
			this.row = row;
			this.col = col;
			this.up = up;
			this.right = right;
			this.down = down;
			this.left = left;
		}

		Puzzle(int up, int right, int down, int left) {
			this.up = up;
			this.right = right;
			this.down = down;
			this.left = left;
		}
	}

	static ArrayList<Puzzle> spareList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());

		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 퍼즐판 준비
		int ord = Integer.parseInt(st.nextToken());
		if (ord == 100) {
			n = Integer.parseInt(st.nextToken());
			arr = new Puzzle[n + 1][n + 1];
		}
		spareList = new ArrayList<>();

		for (int tc = 1; tc < t; tc++) {
			String str = bf.readLine();

			getOrder(str);
		}
	}

	private static void getOrder(String order) {
		StringTokenizer st = new StringTokenizer(order);
		int o = Integer.parseInt(st.nextToken());
		if (o == 100) {
			// 퍼즐 판 준비
			n = Integer.parseInt(st.nextToken());
			arr = new Puzzle[n + 1][n + 1];
		}
		if (o == 200) {
			// 퍼즐 배치
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			Puzzle p = new Puzzle(row, col, u, r, d, l);
			arr[row][col] = p;
		}
		if (o == 300) {
			// 퍼즐 제거
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			arr[row][col] = null;
		}
		if (o == 400) {
			// spareList에 넣기
			int u = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			Puzzle p = new Puzzle(u, r, d, l);
			spareList.add(p);
		}
		if (o == 500) {
			findHole();

			// 가능하면 cnt++
			System.out.println(canPut());
		}

	}

	private static int canPut() {
		int cnt = 0;
		// spareList랑 holeList로 들어갈 수 있는지 찾기
		for(int[] hole : holeList) {
			int row = hole[0];
			int col = hole[1];
			
			int[] tmp = new int[4];
			
			for(int d = 0; d < 4; d++) {
				int nr = row + dx[d];
				int nc = col + dy[d]; 
				if (nr < 1 || nr > n || nc < 1 || nc > n) {
				    // 판 밖인 경우 처리
					tmp[d] = 1; 
					continue;
				}
				int neighborSide = 0;
				
				if (d == 0) {
	                neighborSide = arr[nr][nc].down;
	            } else if (d == 1) {
	                neighborSide = arr[nr][nc].left;
	            } else if (d == 2) {
	                neighborSide = arr[nr][nc].up;
	            } else {
	                neighborSide = arr[nr][nc].right;
	            }
				
				tmp[d] = 2 - neighborSide;
			}
			
			for(Puzzle pz : spareList ) {
				 // 여분 퍼즐의 변도 위, 오른쪽, 아래, 왼쪽 순서
	            int[] sides = {pz.up, pz.right, pz.down, pz.left};

	            // 회전 전, 90도, 180도, 270도 검사
	            for (int rotation = 0; rotation < 4; rotation++) {
	                if (sides[0] == tmp[0]
	                        && sides[1] == tmp[1]
	                        && sides[2] == tmp[2]
	                        && sides[3] == tmp[3]) {
	                    cnt++;
	                    break; // 같은 구멍과 퍼즐 조합은 한 번만 셈
	                }

	                rotate(sides);
	            }
			}
		}
		
		return cnt;
		
	}

	private static void rotate(int[] sides) {
		int last = sides[3];

	    sides[3] = sides[2];
	    sides[2] = sides[1];
	    sides[1] = sides[0];
	    sides[0] = last;
		
	}

	static ArrayList<int[]> holeList;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static void findHole() {
		holeList = new ArrayList<>();
		// holeList 만들고 findHole로 구멍 찾아서 넣기
		for(int row = 1; row <= n; row++) {
			for(int col = 1; col <= n; col++) {
				if(arr[row][col] != null) {
					continue;
				}
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nr = row + dx[d];
					int nc = col + dy[d];
					if(nr < 1 || nr >= n + 1 || nc < 1 || nc >= n + 1 || arr[nr][nc] != null) {
						cnt++;
					}
				}
				if(cnt == 4) {
					holeList.add(new int[] {row, col});
				}
			}
		}		
		
	}

}
