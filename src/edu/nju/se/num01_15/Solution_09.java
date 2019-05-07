package edu.nju.se.num01_15;

/**
 * 变态跳台阶
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * @author zongk
 *
 */
public class Solution_09 {

	public int JumpFloorII(int target) {
		
		if(target == 0) {
			return 0;
		} else if(target == 1) {
			return 1;
		} else {
			int num = 1;
			for(int i=target-1; i>0; i--) {
				num = num + JumpFloorII(i);
			}
			return num;
		}
		
    }
	
}
