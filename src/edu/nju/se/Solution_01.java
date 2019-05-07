package edu.nju.se;

/**
 * 二位数组下的查找
 * 
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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
