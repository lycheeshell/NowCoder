package edu.nju.se.num31_45;

import java.util.ArrayList;

/**
 * 丑数
 * 
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author zongk
 *
 */
public class Solution_33 {

	public int GetUglyNumber_Solution(int index) {

		if (index <= 0) {
			return 0;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while (list.size() < index)// 循环的条件
		{
			int m2 = list.get(i2) * 2;
			int m3 = list.get(i3) * 3;
			int m5 = list.get(i5) * 5;
			int min = Math.min(m2, Math.min(m3, m5));
			list.add(min);
			if (min == m2) i2++;
			if (min == m3) i3++;
			if (min == m5) i5++;
		}
		return list.get(list.size() - 1);

	}

//    public int GetUglyNumber_Solution(int index) {
//    	
//    	if(index == 0) {
//    		return 0;
//    	}
//        
//    	int count = 0;
//    	for(int i=1; ; i++) {
//    		boolean ugly = judge(i);
//    		if(ugly) {
//    			count++;
//    		}
//    		if(count == index) {
//    			return i;
//    		}
//    	}
//    }
//    
//    public boolean judge(int num) {
//    	while(num % 5 == 0) {
//    		num = num / 5;
//    	}
//    	while(num % 3 == 0) {
//    		num = num / 3;
//    	}
//    	while(num % 2 == 0) {
//    		num = num / 2;
//    	}
//    	if(num == 1) {
//    		return true;
//    	}
//    	return false;
//    }

	public static void main(String[] s) {
		System.out.println(new Solution_33().GetUglyNumber_Solution(10000));
	}

}
