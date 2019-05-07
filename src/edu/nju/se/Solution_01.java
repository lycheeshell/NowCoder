package edu.nju.se;

/**
 * 二位数组下的查找
 * 
 * @author zongk
 *
 */
public class Solution_01 {
	
	public boolean Find(int target, int [][] array) {
		int high = array.length;
		int length = array[0].length;
		
		for(int i=0; i<high; i++) {
			for(int j=0; j<length; j++) {
				if(array[i][j] == target) {
					return true;
				}
			}
		}
		
		return false;
    }
	
}
