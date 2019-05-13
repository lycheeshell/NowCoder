package edu.nju.se.num46_60;

/**
 * 	把字符串转换成整数
 * 
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 
 * 输入
 * +2147483647
    1a33
 * 输出
 * 2147483647
    0
 * 
 * @author zongk
 *
 */
public class Solution_49 {
	
    public int StrToInt(String str) {
        
    	if(str == null || str.length() == 0) {
    		return 0;
    	}
    	int sign = 0;
    	if(str.charAt(0) == '+') {
    		sign = 1;
    	} else if(str.charAt(0) == '-') {
    		sign = -1;
    	}
    	
    	int num = 0;
    	for(int i=Math.abs(sign); i<str.length(); i++) {
    		
    		if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
    			num = num*10 + (str.charAt(i) - '0');
    		} else {
    			return 0;
    		}
    	}
    	
    	if(sign == 0) {
    		sign++;
    	}
    	
    	return num * sign;
    }
    
}
