package Solution;

import java.io.*;
import java.util.*;

public class Flatten {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);


            for (int i = 0; i < 100; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }


            for (int i = 0; i < n; i++) {
                int max = Collections.max(list);
                int idx_max = list.indexOf(max);
                int min = Collections.min(list);
                int idx_min = list.indexOf(min);

                list.set(idx_max, list.get(idx_max) - 1);
                list.set(idx_min, list.get(idx_min) + 1);
            }

            int max = Collections.max(list);
            int idx_max = list.indexOf(max);
            int min = Collections.min(list);
            int idx_min = list.indexOf(min);

            int result = list.get(idx_max) - list.get(idx_min);
            System.out.println("#" + tc + " " + result);
        }


    }
}
