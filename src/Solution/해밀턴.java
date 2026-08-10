package Solution;

import java.io.*;
import java.util.*;



public class 해밀턴 {
	static int[][] cost;
	static int INF = 99999999; 
	static int n;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		cost = new int[n][n];
		
		
		for(int i = 0; i<n; i++) {
			String str = bf.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j = 0; j<n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1 << n][n];
		for(int i = 0; i<(1<<n); i++) {
			Arrays.fill(dp[i], -1);
		}
		
		int ans = recursive(0, 1);
		System.out.println(ans);
		
		
		
		
	}
	static int recursive(int now, int visited) {
		//다 돌고 다시 1번 도시로 복귀
		if(visited == (1<<n) -1) {
		    if(cost[now][0] == 0) {
		        return dp[visited][now] = INF;
		    }
		    
		    return dp[visited][now] = cost[now][0];
		}
				
		//이미 앞으로의 최소 비용을 알고 있는 경우
		if(dp[visited][now] != -1) {
			return dp[visited][now];
		}
		int sum = INF;
		
		for(int next = 0; next < n; next++) {
			//이미 방문한 도시 확인
			if((visited & (1 << next)) != 0 || cost[now][next] == 0) {
				continue;
			}
			int nextVisited = visited | (1 << next);
			int nextCost = recursive(next, nextVisited);
			if(nextCost == INF) {
				continue;
			}
			
			int tmp = cost[now][next] + nextCost; 
			sum = Math.min(sum, tmp);
		}
		dp[visited][now] = sum;
		return sum;
		
		
	}
	
	
}
