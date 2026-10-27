package samsung;

import java.io.*;
import java.util.*;

public class 수하물컨베이어벨트 {
	public static class Bag {
		int id;
		int turn;
		int row;
		int col;
		int weight;
		boolean inserted;
		int damage;
		boolean broken;
		int finishTurn;

		Bag(int turn, int row, int col, int weight) {
			this.turn = turn;
			this.row = row;
			this.col = col;
			this.weight = weight;
			this.inserted = false;
			this.damage = 0;
		}
	}

	static int n;
	static int[][] arr;
	static int b;
	static Bag[] bagList;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		arr = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		b = Integer.parseInt(bf.readLine());
		bagList = new Bag[b];
		for (int i = 0; i < b; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Bag b = new Bag(t, r, c, w);
			b.id = i + 1;
			bagList[i] = b;
		}

		Arrays.sort(bagList, (a, b) -> Integer.compare(a.turn, b.turn));
		cnt = 0;
		v = new Bag[n + 1][n + 1];
		doTurn(0);
		
		Arrays.sort(bagList, (a, b) -> Integer.compare(a.id, b.id));
		
		for(Bag bag : bagList) {
			int result = bag.finishTurn;
			
			if(bag.broken) {
				result *= -1;
			}
			System.out.print(result + " ");
		}

	}

	static Bag[][] v;

	private static void doTurn(int turn) {
		int curTurn = turn;
		while (cnt < b) {
			firstTurn(curTurn);
			secondTurn(curTurn);
			thirdTurn(curTurn);

			curTurn++;
		}
	}

	private static void firstTurn(int curTurn) {
		Bag[][] winner = new Bag[n + 1][n + 1];
		boolean[][] stopped = new boolean[n + 1][n + 1];
		Queue<Bag> q = new ArrayDeque<>();

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				// 현재 수하물
				Bag bag = v[row][col];

				// 없으면 생략
				if (bag == null) {
					continue;
				}

				// 다음칸 확인
				int[] next = check(row, col);
				int nr = next[0];
				int nc = next[1];
				
				// 제자리면 넘김
				if(nr == row && nc == col) {
					continue;
				}
				
				// 해당하는 좌표에 등록된 수하물이 없다면
				if (winner[nr][nc] == null) {
					winner[nr][nc] = bag;
				} else {
					// 이미 winner가 더 무거우면
					if (winner[nr][nc].weight > bag.weight) {
						continue;
					}
					// 무게가 같으면
					else if (winner[nr][nc].weight == bag.weight) {
						if (winner[nr][nc].id < bag.id) {
							// 이미 winner의 id가 더 작으면
							continue;
						} else {
							// bag의 id가 더 작으면, bag로 교체
							winner[nr][nc] = bag;
						}
					}
					// 지금 bag가 더 무거우면
					else {
						winner[nr][nc] = bag;
					}
				}
			}
		}
		
		for(int row = 1; row <= n; row++) {
			for(int col = 1; col <= n; col++) {
				// 현재 수하물
				Bag bag = v[row][col];

				// 없으면 생략
				if (bag == null) {
					continue;
				}
				
				// 다음칸 확인
				int[] next = check(row, col);
				int nr = next[0];
				int nc = next[1];
				
				// 제자리라 못 움직임
				if(nr == row && nc == col) {
					stopped[row][col] = true;
					q.offer(bag);
				}
				
				// 최종에서 밀려서 못 움직임
				else if (winner[nr][nc] != bag) {
					stopped[row][col] = true;
					q.offer(bag);
				}
				
			}
		}
		while(!q.isEmpty()) {
			Bag blocked = q.poll();
			
			int row = blocked.row;
			int col = blocked.col;
			
			// 이 자리로 들어오려던 winner 수하물 찾기
			Bag behind = winner[row][col];
			if(behind == null) {
				// 이 자리로 올 수하물이 없으면 다음꺼
				continue;
			}
			
			if(stopped[behind.row][behind.col]) {
				// 이미 못 움직이는 수하물이면 검사 안함
				continue;
			}
			
			stopped[behind.row][behind.col] = true;
			q.offer(behind);
			
		}
		
		// 새로운 배열 생성
		Bag[][] nextV = new Bag[n+1][n+1];
		for(int row = 1; row <= n; row++) {
			for(int col = 1; col <= n; col++) {
				// 현재 수하물
				Bag bag = v[row][col];

				// 없으면 생략
				if (bag == null) {
					continue;
				}
				
				if(stopped[row][col]) {
					// 이동 불가 -> 제자리 그대로
					nextV[row][col] = bag;
					bag.damage++;
				} else {
					// 이동
					int[] next = check(row, col);
					int nr = next[0];
					int nc = next[1];
					
					nextV[nr][nc] = bag;
					bag.row = nr;
					bag.col = nc;
					
					bag.damage = 0;
				}
				
			}
		}
		
		v = nextV;
		
	}

	private static int[] check(int row, int col) {
		switch (arr[row][col]) {
		case 0:
			return new int[] { row, col }; // 이동X
		case 1:
			return new int[] { row + 1, col }; // 아래
		case 2:
			return new int[] { row, col - 1 }; // 왼쪽
		case 3:
			return new int[] { row - 1, col }; // 위
		case 4:
			return new int[] { row, col + 1 }; // 오른쪽
		case 9:
		    return new int[] { row, col };
		}
		return null;
	}

	private static void secondTurn(int curTurn) {
		for(int row = 1; row <= n; row++) {
			for(int col = 1; col <= n; col++) {
				Bag bag = v[row][col];
				
				if(bag == null) {
					continue;
				}
				
				if(arr[row][col] == 9) {
					bag.finishTurn = curTurn;
					v[row][col] = null;
					cnt++;
					
					continue;
				}
				
				if(bag.damage >= 3) {
					bag.broken = true;
				}
			}
		}

	}

	private static void thirdTurn(int curTurn) {
		for (int i = 0; i < bagList.length; i++) {
			if (bagList[i].inserted) {
				continue;
			}

			if (bagList[i].turn <= curTurn) {
				int row = bagList[i].row;
				int col = bagList[i].col;
				if (v[row][col] == null) {
					// 그 칸에 없으면 투입
					v[row][col] = bagList[i];
					bagList[i].inserted = true;
				}
			} else {
				break;
			}
		}
	}

}
