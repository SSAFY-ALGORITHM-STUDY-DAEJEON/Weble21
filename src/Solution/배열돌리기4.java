package Solution;

import java.io.*;
import java.util.*;

public class 배열돌리기4 {
    static int N, M, K;
    static int[][] original;
    static int[][] operations;

    static int[] order;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        original = new int[N][M];
        operations = new int[K][3];
        order = new int[K];
        visited = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            // 배열 인덱스를 0부터 사용하므로 r, c에서 1을 뺀다.
            operations[i][0] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][1] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(answer);
    }

    // 회전 연산의 순서를 순열로 정한다.
    static void permutation(int depth) {
        if (depth == K) {
            int[][] arr = copyArray();

            for (int i = 0; i < K; i++) {
                int[] operation = operations[order[i]];
                rotate(arr, operation[0], operation[1], operation[2]);
            }

            calculate(arr);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            order[depth] = i;

            permutation(depth + 1);

            visited[i] = false;
        }
    }

    // 원본 배열을 행별로 복사한다.
    static int[][] copyArray() {
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            copy[i] = original[i].clone();
        }

        return copy;
    }

    // 중심 (r, c)를 기준으로 각 테두리를 시계 방향으로 한 칸 회전한다.
    static void rotate(int[][] arr, int r, int c, int s) {
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int bottom = r + layer;
            int left = c - layer;
            int right = c + layer;

            // 덮어쓰게 될 왼쪽 위 값을 미리 보관한다.
            int temp = arr[top][left];

            // 왼쪽 변: 아래 값을 위로 이동
            for (int i = top; i < bottom; i++) {
                arr[i][left] = arr[i + 1][left];
            }

            // 아래쪽 변: 오른쪽 값을 왼쪽으로 이동
            for (int j = left; j < right; j++) {
                arr[bottom][j] = arr[bottom][j + 1];
            }

            // 오른쪽 변: 위 값을 아래로 이동
            for (int i = bottom; i > top; i--) {
                arr[i][right] = arr[i - 1][right];
            }

            // 위쪽 변: 왼쪽 값을 오른쪽으로 이동
            for (int j = right; j > left + 1; j--) {
                arr[top][j] = arr[top][j - 1];
            }

            // 원래 왼쪽 위 값은 오른쪽 한 칸으로 이동한다.
            arr[top][left + 1] = temp;
        }
    }

    // 각 행의 합으로 정답을 갱신한다.
    static void calculate(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j < M; j++) {
                sum += arr[i][j];
            }

            answer = Math.min(answer, sum);
        }
    }
}