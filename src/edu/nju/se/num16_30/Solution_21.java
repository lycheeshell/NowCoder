package edu.nju.se.num16_30;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 
 * @author zongk
 *
 */
public class Solution_21 {
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	      
		int length = pushA.length;
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		for(int i=length-1; i>=0; i--) {
			stack2.push(popA[i]);
		}
		
		for(int i=0; i<length; i++) {
			if(pushA[i] == stack2.peek()) {
				stack2.pop();
			} else {
				stack1.push(pushA[i]);
			}
		}
		
		while(!stack1.isEmpty()) {
			int temp = stack1.pop();
			if(temp == stack2.peek()) {
				stack2.pop();
			}
		}
		
		if(stack2.isEmpty()) {
			return true;
		}
		
		return false;
		
    }
	
}
