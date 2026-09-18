package codeTree;

import java.util.*;

public class 코드트리_비피하기 {

    static int n, h, m;
    static int[][] arr;
    static int[][] result;

    static ArrayList<Node> people = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 2) {
                    people.add(new Node(i, j, 0));
                }
            }
        }

        for (int i = 0; i < people.size(); i++) {

            Node person = people.get(i);

            result[person.x][person.y]
                    = bfs(person.x, person.y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static int bfs(int sx, int sy) {

        boolean[][] v = new boolean[n][n];
        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(sx, sy, 0));
        v[sx][sy] = true;

        while (!q.isEmpty()) {

            Node cur = q.poll();

            if (arr[cur.x][cur.y] == 3) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {

                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if (v[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    continue;
                }

                v[nx][ny] = true;

                q.offer(
                    new Node(nx, ny, cur.dist + 1)
                );
            }
        }

        return -1;
    }
}