package edu.nju.se.num01_15;

/**
 * 二进制中1的个数
 * 
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 * 
 * @author zongk
 *
 */
public class Solution_11 {

	public int NumberOf1(int n) {
		
		return Integer.toBinaryString(n).replaceAll("0", "").length();
		
    }
	
}
