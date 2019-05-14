package edu.nju.se.num46_60;

import java.util.ArrayList;

/**
 * 字符流中第一个不重复的字符
 * 
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 
 * @author zongk
 *
 */
public class Solution_54 {
	
	ArrayList<Character> list = new ArrayList<Character>();
	
	//Insert one char from stringstream
	public void Insert(char ch) {
        
		list.add(ch);
		
	}
	
	//return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		ArrayList<Character> temp = new ArrayList<Character>();
		for(int i=0; i<list.size(); i++) {
			boolean one = true;
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(i) == list.get(j)) {
					one = false;
					temp.add(list.get(i));
					j = list.size();
				}
			}
			if(one && (!temp.contains(list.get(i))) ) {
				return list.get(i);
			}
		}
		return '#';
	}
}
