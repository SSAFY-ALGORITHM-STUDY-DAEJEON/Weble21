package codeTree;

import java.util.*;

public class 코드트리_연속부분합의최댓값2 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int sum = 0;
        int max = arr[0];
        for(int i = 0; i < N; i++) {
        	sum += arr[i];
        	if(sum <= 0) {
        		sum = 0;
        		max = Math.max(max, arr[i]);
        	} else {
        		max = Math.max(max, sum);
        	}
        }
        System.out.println(max);
    }
}
