package Solution;

import java.io.*;


public class 행운의문자열 {
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		char[] arr = new char[str.length()];
		for(int i = 0; i<str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		boolean[] v = new boolean[arr.length];
		dfs(0, new char[arr.length], v, arr);
		
		System.out.println(cnt);
	}

	private static void dfs(int k, char[] sel, boolean[] v, char[] arr) {
		//basis
		if(sel.length == k) {
			cnt++;
			return;
		}
		
		boolean[] used = new boolean[28];
		//inductive
		for(int i = 0; i<arr.length; i++) {
			
			if(v[i]) continue;
			if(k > 0 && sel[k-1] == arr[i]) continue;			
			if(used[arr[i] - 'a']) continue;
			
			used[arr[i] - 'a'] = true;
			
			v[i] = true;
			sel[k] = arr[i];
			
			dfs(k+1, sel, v, arr);
			v[i] = false;
			
			
		}
		
	}
	
}
