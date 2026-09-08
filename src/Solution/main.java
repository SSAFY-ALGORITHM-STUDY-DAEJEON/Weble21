package Solution;

import java.util.Arrays;

/**
 * arr 배열에 있는 요소값 중 하나를 선택하는 프로그램을 구현하세요
 * 조합
 */
public class main {
	static int[] arr = { 1, 3 ,5};
	public static void main(String[] args) {
		
		recursive(0,new int[3],0);

	}
	/**
	 * @param idx : arr배열의 인덱스
	 * @param sel : 선택배열
	 * @param k   : 선택배열의 인덱스
	 */
	private static void recursive(int idx, int[] sel, int k) {
		// basis part
		if(k==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		// 더이상 선택할 arr 배열의 요소값이 없다
		if(idx == arr.length) return;
		
		// inductive part
		// 선택하는 경우
		sel[k] = arr[idx];
		recursive(idx+1, sel,k+1);
		
		// 선택한지 안는 경우
		recursive(idx+1, sel, k);
	}
}
