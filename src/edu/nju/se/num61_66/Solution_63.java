package edu.nju.se.num61_66;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数据流中的中位数
 * 
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 
 * @author zongk
 *
 */
public class Solution_63 {
	
	ArrayList<Integer> list = new ArrayList<Integer>();

    public void Insert(Integer num) {
        
    	list.add(num);
    	
    }

    public Double GetMedian() {
    	
    	int[] nums = new int[list.size()];
    	for(int i=0; i<list.size(); i++) {
    		nums[i] = list.get(i);
    	}
    	
    	Arrays.sort(nums);
        
    	int size = list.size();
    	
    	if(size % 2 == 1) {
    		int num = size / 2;
    		return nums[num] * 1.0;
    	} else {
    		int num = size / 2;
    		int a = nums[num-1];
    		int b = nums[num];
    		return (a+b) / 2.0;
    	}
    	
    }
	
}
