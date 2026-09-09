package codeTree;

import java.util.*;
import java.io.*;

public class 코드트리_최단경로3 {
    static int n, m;
    static class Edge {
        int x, y, z;
        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static int[][] graph;
    public static boolean[] v;
    public static int[] dist;
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer tt = new StringTokenizer(s);
        n = Integer.parseInt(tt.nextToken());
        m = Integer.parseInt(tt.nextToken());
        Edge[] edges = new Edge[m+1];
        graph = new int[n+1][n+1];
        v = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        edges[0] = new Edge(-1, -1, -1);
        for(int i = 1; i <= m; i++) {
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int node = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(node, end, value);
        }
        for(int i = 1; i <= m; i++) {
            int x = edges[i].x;
            int y = edges[i].y;
            int z = edges[i].z;
            graph[x][y] = z;
        }
        dist[1] = 0;
        
        dijkstra();
        
        for(int i = 2; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[i]);
            }
            
        }
    }

    private static void dijkstra() {
        for(int i = 1; i <= n; i++) {
            int idx = -1;
            for(int j = 1; j <= n; j++) {
                if(v[j]) continue;
                
                if(idx == -1 || dist[idx] > dist[j]) {
                    idx = j;
                }
            }

            if(idx == -1 || dist[idx] == Integer.MAX_VALUE) {
                break;
            }
            v[idx] = true;
            for(int j = 1; j <= n; j++) {
                if(graph[idx][j] == 0) {
                    continue;
                }
                dist[j] = Math.min(dist[j], graph[idx][j] + dist[idx]);
            }
        }
        
    }
}
