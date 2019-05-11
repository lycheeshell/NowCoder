package edu.nju.se.num31_45;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 	第一个只出现一次的字符位置
 * 
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 
 * 如果没有则返回 -1（需要区分大小写）.
 * 
 * @author zongk
 *
 */
public class Solution_34 {

    public int FirstNotRepeatingChar(String str) {
    	
    	if(str.length() == 0) {
    		return -1;
    	}
    	
    	LinkedHashMap<Character,ArrayList<Integer>> map = new LinkedHashMap<Character,ArrayList<Integer>>();
    	for(int i=0; i<str.length(); i++) {
    		
    		ArrayList<Integer> list;
    		if(map.containsKey(str.charAt(i))) {
    			list = map.get(str.charAt(i));
    			list.add(i);
    		} else {
    			list = new ArrayList<Integer>();
    			list.add(i);
    			map.put(str.charAt(i), list);
    		}
    		
    	}
    	
    	for(char c : map.keySet()) {
    		if(map.get(c).size() == 1) {
    			return map.get(c).get(0);
    		}
    	}
    	
        return -1;
    }
	
}
