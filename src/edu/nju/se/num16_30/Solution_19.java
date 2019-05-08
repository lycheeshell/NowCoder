package edu.nju.se.num16_30;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * @author zongk
 *
 */
public class Solution_19 {
	
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int i = matrix[0].length;
		int j = matrix.length;
		
		int index = 0;
		
		while( (i-2*index) > 0 && (j-2*index) > 0 ) {
			
			if((i-2*index) == 1) {
				for(int k=index; k<j-index; k++) {
					list.add(matrix[k][index]);
				}
				break;
			}
			
			if((j-2*index) == 1) {
				for(int k=index; k<i-index; k++) {
					list.add(matrix[index][k]);
				}
				break;
			}
			
			for(int k=index; k<i-index; k++) {
				list.add(matrix[index][k]);
			}
			for(int k=index+1; k<j-index-1; k++) {
				list.add(matrix[k][i-1-index]);
			}
			for(int k=i-1-index; k>=index; k--) {
				list.add(matrix[j-1-index][k]);
			}
			for(int k=j-2-index; k>=index+1; k--) {
				list.add(matrix[k][index]);
			}
			
			index++;
		}
		
		return list;
    }
}
