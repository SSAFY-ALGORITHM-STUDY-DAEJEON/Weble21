package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 해밀턴_순환회로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		boolean[] visited = new boolean[n+1];
		int[][] arr = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j = 1; j<=n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j] = tmp;
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
		
		
	}
}
