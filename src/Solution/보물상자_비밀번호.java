package Solution;

import java.io.*;
import java.util.*;

public class 보물상자_비밀번호 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=1;t<=tc;t++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            char[] arr = new char[n];
            String s = br.readLine();

            for(int i=0;i<n;i++){
                arr[i] = s.charAt(i);
            }

            int l = n / 4;
            List<Long> list = new ArrayList<>();
            for(int r = 0; r < l; r++) {
                for(int i = 0; i<n; i += l) {
                    int tmp = i + r;
                    if(tmp == 0) tmp += n;
                    char[] hex = new char[l];
                    for(int j = 0; j<l; j++){
                        hex[j] = arr[tmp % n];
                        tmp++;
                    }

                    long res = hexaTodeci(hex);

                    if(list.indexOf(res) == -1) {
                        list.add(res);
                    }
                }
            }

            list.sort(Collections.reverseOrder());

            System.out.println("#" + t + " " + list.get(k - 1));
        }

    }

    static long hexaTodeci(char[] hex) {
        long sum = 0;
        for(int j = 0; j<hex.length; j++){
            int tmp;
            switch (hex[j]) {
                case 'A' : tmp = 10; break;
                case 'B' : tmp = 11; break;
                case 'C' : tmp = 12; break;
                case 'D' : tmp = 13; break;
                case 'E' : tmp = 14; break;
                case 'F' : tmp = 15; break;
                default : tmp = hex[j] - '0'; break;
            }
            sum = sum * 16 + tmp;
        }
        return sum;
    }
}
