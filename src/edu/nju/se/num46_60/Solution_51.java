package edu.nju.se.num46_60;

/**
 * 	构建乘积数组
 * 
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * 
 * @author zongk
 *
 */
public class Solution_51 {

	public int[] multiply(int[] A) {
		
		if(A == null || A.length == 0) {
			return A;
		}
		
		int n= A.length;
		int[] B = new int[n];
		
		for(int i=0; i<n; i++) {
			
			B[i] = 1;
			if(i>=1) {
				for(int j=0; j<=i-1; j++) {
					B[i] = B[i] * A[j];
				}
			}
			if(i<=n-2) {
				for(int j=i+1; j<=n-1; j++) {
					B[i] = B[i] * A[j];
				}
			}
			
		}
		
		return B;
	}
	
}
