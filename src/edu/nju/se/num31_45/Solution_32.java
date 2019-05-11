package edu.nju.se.num31_45;

import java.util.ArrayList;

/**
 * 把数组排成最小的数
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * @author zongk
 *
 */
public class Solution_32 {
	
    public String PrintMinNumber(int [] numbers) {
    	
    	if(numbers == null || numbers.length == 0) {
    		return "";
    	}
    	
    	ArrayList<String> result = new ArrayList<String>();
    	
    	ArrayList<String> list = new ArrayList<String>();
    	
    	int len = numbers.length;
    	
    	for(int i=0; i<len; i++) {
    		list.add(numbers[i] + "");
    	}
    	
    	while(!list.isEmpty()) {
    		
    		int index = judgeMin(list);
    		result.add(list.get(index));
    		list.remove(index);
    		
    	}
    	
    	String str = "";
    	
    	for(String s : result) {
    		str = str + s;
    	}
    	
    	return str;
    }

	public int judgeMin(ArrayList<String> list) {
		
		int index = 0;
		String min = list.get(0);
		
		for(int i=0; i<list.size(); i++) {
			
			String s = list.get(i);
			boolean isMin = isMin(min, s);
			if(!isMin) {
				index = i;
				min = s;
			}
			
		}
		
		return index;
	}
	
	public boolean isMin(String min, String s) {
		
		int i = 0;
		while(i<min.length() || i<s.length()) {
			
			if(i >= min.length()) {
				if(min.charAt(min.length()-1) < s.charAt(i)) {
					return true;
				} else if(min.charAt(min.length()-1) > s.charAt(i)) {
					return false;
				} else {
					i++;
				}
			} else if(i >= s.length()) {
				if(min.charAt(i) < s.charAt(s.length()-1)) {
					return true;
				} else if(min.charAt(i) > s.charAt(s.length()-1)) {
					return false;
				} else {
					i++;
				}
			} else {
				if(min.charAt(i) < s.charAt(i)) {
					return true;
				} else if(min.charAt(i) > s.charAt(i)) {
					return false;
				} else {
					i++;
				}
			}
			
		}
		
		return false;
		
	}
	
}
