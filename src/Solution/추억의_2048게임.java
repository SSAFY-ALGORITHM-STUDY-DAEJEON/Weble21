<<<<<<< HEAD
package Solution;

import java.io.*;
import java.util.*;
 
public class 추억의_2048게임 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int n;
            String s;
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            s = st.nextToken();
 
            int[][] arr = new int[n][n];
 
            for(int i = 0; i< n; i++) {
                String li = br.readLine();
                StringTokenizer sli = new StringTokenizer(li);
                for(int j =0; j< n; j++) {
                    arr[i][j] = Integer.parseInt(sli.nextToken());
                }
            }
            int[][] res;
            switch (s) {
                case "up" : res = up(arr, n); break;
                case "down" : res = down(arr, n); break;
                case "right" : res = right(arr, n); break;
                case "left" : res = left(arr, n); break;
                default:
                    break;
            }
            System.out.println("#" + t);
            for(int i = 0; i< n; i++) {
                for(int j =0; j< n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
 
    }
 
    static int[][] up(int[][] arr, int n) {
        for(int j =0; j < n; j++) {
            for(int i =n-1; i>0; i--) {
                if(arr[i][j] == 0) {
                    for(int k = i; k < n-1; k++) {
                        arr[k][j] = arr[k+1][j];
                    }
                    arr[n-1][j] = 0;
                } else {
                    continue;
                }
            }
            for(int i =0; i< n-1; i++) {
                if(arr[i][j] == arr[i+1][j]) {
                    arr[i][j] += arr[i+1][j];
                    arr[i+1][j] = 0;
                    i++;
                } else {
                    continue;
                }
            }
        }
 
        for(int j =0; j < n; j++) {
            for(int i =0; i<n-1; i++) {
                if(arr[i][j] == 0) {
                    for(int k = i; k < n-1; k++) {
                        arr[k][j] = arr[k+1][j];
                    }
                    arr[n-1][j] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
 
    static int[][] down(int[][] arr, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n-1; i++) {
                if(arr[i][j] == 0) {
                    for(int k = i; k > 0; k--) {
                        arr[k][j] = arr[k-1][j];
                    }
                    arr[0][j] = 0;
                } else {
                    continue;
                }
            }
            for(int i = n-1; i > 0; i--) {
                if(arr[i][j] == arr[i-1][j]) {
                    arr[i][j] += arr[i-1][j];
                    arr[i-1][j] = 0;
                    i--;
                } else {
                    continue;
                }
            }
        }
 
        for(int j = 0; j < n; j++) {
            for(int i = n-1; i > 0; i--) {
                if(arr[i][j] == 0) {
                    for(int k = i; k > 0; k--) {
                        arr[k][j] = arr[k-1][j];
                    }
                    arr[0][j] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
 
    static int[][] left(int[][] arr, int n) {
        for(int i =0; i < n; i++) {
            for(int j =n-1; j>0; j--) {
                if(arr[i][j] == 0) {
                    for(int k = j; k < n-1; k++) {
                        arr[i][k] = arr[i][k+1];
                    }
                    arr[i][n-1] = 0;
                } else {
                    continue;
                }
            }
            for(int j =0; j<n-1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    arr[i][j] += arr[i][j+1];
                    arr[i][j+1] = 0;
                    j++;
                } else {
                    continue;
                }
            }
        }
 
        for(int i =0; i < n; i++) {
            for(int j =0; j<n-1; j++) {
                if(arr[i][j] == 0) {
                    for(int k = j; k < n-1; k++) {
                        arr[i][k] = arr[i][k+1];
                    }
                    arr[i][n-1] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
 
    static int[][] right(int[][] arr, int n) {
        for(int i =0; i < n; i++) {
            for(int j =0; j<n-1; j++) {
                if(arr[i][j] == 0) {
                    for(int k = j; k > 0; k--) {
                        arr[i][k] = arr[i][k-1];
                    }
                    arr[i][0] = 0;
                } else {
                    continue;
                }
            }
            for(int j =n-1; j > 0 ; j--) {
                if(arr[i][j] == arr[i][j-1]) {
                    arr[i][j] += arr[i][j-1];
                    arr[i][j-1] = 0;
                    j--;
                } else {
                    continue;
                }
            }
        }
 
        for(int i =0; i < n; i++) {
            for(int j =n-1; j>0; j--) {
                if(arr[i][j] == 0) {
                    for(int k = j; k > 0; k--) {
                        arr[i][k] = arr[i][k-1];
                    }
                    arr[i][0] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
=======
package Solution;

import java.io.*;
import java.util.*;
 
public class 추억의_2048게임 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            int n;
            String s;
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            s = st.nextToken();
 
            int[][] arr = new int[n][n];
 
            for(int i = 0; i< n; i++) {
                String li = br.readLine();
                StringTokenizer sli = new StringTokenizer(li);
                for(int j =0; j< n; j++) {
                    arr[i][j] = Integer.parseInt(sli.nextToken());
                }
            }
            int[][] res;
            switch (s) {
                case "up" : res = up(arr, n); break;
                case "down" : res = down(arr, n); break;
                case "right" : res = right(arr, n); break;
                case "left" : res = left(arr, n); break;
                default:
                    break;
            }
            System.out.println("#" + t);
            for(int i = 0; i< n; i++) {
                for(int j =0; j< n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
 
    }
 
    static int[][] up(int[][] arr, int n) {
        for(int j =0; j < n; j++) {
            for(int i =n-1; i>0; i--) {
                if(arr[i][j] == 0) {
                    for(int k = i; k < n-1; k++) {
                        arr[k][j] = arr[k+1][j];
                    }
                    arr[n-1][j] = 0;
                } else {
                    continue;
                }
            }
            for(int i =0; i< n-1; i++) {
                if(arr[i][j] == arr[i+1][j]) {
                    arr[i][j] += arr[i+1][j];
                    arr[i+1][j] = 0;
                    i++;
                } else {
                    continue;
                }
            }
        }
 
        for(int j =0; j < n; j++) {
            for(int i =0; i<n-1; i++) {
                if(arr[i][j] == 0) {
                    for(int k = i; k < n-1; k++) {
                        arr[k][j] = arr[k+1][j];
                    }
                    arr[n-1][j] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
 
    static int[][] down(int[][] arr, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < n-1; i++) {
                if(arr[i][j] == 0) {
                    for(int k = i; k > 0; k--) {
                        arr[k][j] = arr[k-1][j];
                    }
                    arr[0][j] = 0;
                } else {
                    continue;
                }
            }
            for(int i = n-1; i > 0; i--) {
                if(arr[i][j] == arr[i-1][j]) {
                    arr[i][j] += arr[i-1][j];
                    arr[i-1][j] = 0;
                    i--;
                } else {
                    continue;
                }
            }
        }
 
        for(int j = 0; j < n; j++) {
            for(int i = n-1; i > 0; i--) {
                if(arr[i][j] == 0) {
                    for(int k = i; k > 0; k--) {
                        arr[k][j] = arr[k-1][j];
                    }
                    arr[0][j] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
 
    static int[][] left(int[][] arr, int n) {
        for(int i =0; i < n; i++) {
            for(int j =n-1; j>0; j--) {
                if(arr[i][j] == 0) {
                    for(int k = j; k < n-1; k++) {
                        arr[i][k] = arr[i][k+1];
                    }
                    arr[i][n-1] = 0;
                } else {
                    continue;
                }
            }
            for(int j =0; j<n-1; j++) {
                if(arr[i][j] == arr[i][j+1]) {
                    arr[i][j] += arr[i][j+1];
                    arr[i][j+1] = 0;
                    j++;
                } else {
                    continue;
                }
            }
        }
 
        for(int i =0; i < n; i++) {
            for(int j =0; j<n-1; j++) {
                if(arr[i][j] == 0) {
                    for(int k = j; k < n-1; k++) {
                        arr[i][k] = arr[i][k+1];
                    }
                    arr[i][n-1] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
 
    static int[][] right(int[][] arr, int n) {
        for(int i =0; i < n; i++) {
            for(int j =0; j<n-1; j++) {
                if(arr[i][j] == 0) {
                    for(int k = j; k > 0; k--) {
                        arr[i][k] = arr[i][k-1];
                    }
                    arr[i][0] = 0;
                } else {
                    continue;
                }
            }
            for(int j =n-1; j > 0 ; j--) {
                if(arr[i][j] == arr[i][j-1]) {
                    arr[i][j] += arr[i][j-1];
                    arr[i][j-1] = 0;
                    j--;
                } else {
                    continue;
                }
            }
        }
 
        for(int i =0; i < n; i++) {
            for(int j =n-1; j>0; j--) {
                if(arr[i][j] == 0) {
                    for(int k = j; k > 0; k--) {
                        arr[i][k] = arr[i][k-1];
                    }
                    arr[i][0] = 0;
                } else {
                    continue;
                }
            }
        }
 
        return arr;
    }
>>>>>>> 6d3dbf7 (활주로 문제)
}