package edu.nju.se.num16_30;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排列
 * 
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 
 * @author zongk
 *
 */
public class Solution_27 {
	
	public ArrayList<String> Permutation(String str) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		if(str == null || str.length() == 0) {
			return list;
		}
	       
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		
		for(int i=0; i<chars.length; i++) {
			if((i == 0) || (i > 0 && chars[i] != chars[i-1])) {
				String tempStr = new String(chars);
				String subStr = tempStr.replaceFirst(chars[i] + "", "");
				ArrayList<String> temp = Permutation(subStr);
				if(temp == null || temp.size() == 0) {
					list.add(chars[i] + "");
				} else {
					for(int j=0; j<temp.size(); j++) {
						list.add(chars[i] + temp.get(j));
					}
				}
			}
		}
		
		
		return list;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution_27().Permutation("aa"));
	}
	
}
