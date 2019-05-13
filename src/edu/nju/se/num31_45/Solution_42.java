package edu.nju.se.num31_45;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 对应每个测试案例，输出两个数，小的先输出。
 * 
 * @author zongk
 *
 */
public class Solution_42 {
	
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for(int i=0; i<array.length; i++) {
    		for(int j=i+1; j<array.length; j++) {
    			if(array[i] + array[j] == sum) {
    				if(list.size() == 0) {
    					list.add(array[i]);
    					list.add(array[j]);
    				} else {
    					if(list.get(0) * list.get(1) > array[i] * array[j]) {
    						list.remove(1);
    						list.remove(0);
    						list.add(array[i]);
        					list.add(array[j]);
    					}
    				}
    			}
    		}
    	}
    	
    	return list;
    }
	
}
