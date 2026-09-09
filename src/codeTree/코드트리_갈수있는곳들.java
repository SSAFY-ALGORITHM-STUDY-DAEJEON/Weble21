package codeTree;

import java.util.*;

public class 코드트리_갈수있는곳들 {

    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();

        // 시작점 K개를 전부 큐에 넣는다.
        for (int i = 0; i < k; i++) {

            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            dq.addLast(new int[]{x, y});
            visited[x][y] = true;
        }

        int result = bfs(dq, n);

        System.out.println(result);
    }

    private static int bfs(Deque<int[]> dq, int n) {

        int count = dq.size(); // 시작점들도 갈 수 있는 곳에 포함

        while (!dq.isEmpty()) {

            int[] cur = dq.pollFirst();

            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 밖
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                // 이미 방문
                if (visited[nx][ny]) {
                    continue;
                }

                // 벽이면 이동 불가
                if (grid[nx][ny] == 1) {
                    continue;
                }

                visited[nx][ny] = true;
                dq.addLast(new int[]{nx, ny});
                count++;
            }
        }

        return count;
    }
}