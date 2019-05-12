package edu.nju.se.num31_45;

/**
 * 数字在排序数组中出现的次数
 * 
 * 统计一个数字在排序数组中出现的次数。
 * 
 * @author zongk
 *
 */
public class Solution_37 {
	
    public int GetNumberOfK(int [] array , int k) {
        
    	int num = 0;
    	for(int i=0; i<array.length; i++) {
    		if(k == array[i]) {
    			num++;
    		}
    	}
    	return num;
    	
    }
	
}
