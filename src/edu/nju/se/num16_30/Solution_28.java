package edu.nju.se.num16_30;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author zongk
 *
 */
public class Solution_28 {
	
    public int MoreThanHalfNum_Solution(int [] array) {
    	
    	if(array == null || array.length == 0) {
    		return 0;
    	}
        
    	int n = array.length / 2;
    	
    	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	
    	for(int i=0; i<array.length; i++) {
    		if(map.containsKey(array[i])) {
    			map.put(array[i], map.get(array[i]) + 1);
    		} else {
    			map.put(array[i], 1);
    		}
    	}
    	
    	for(Integer num : map.keySet()) {
    		if(map.get(num) > n) {
    			return num;
    		}
    	}
    	return 0;
    	
    }
	
}
