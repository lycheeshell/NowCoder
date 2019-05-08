package edu.nju.se.num16_30;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 * @author zongk
 *
 */
public class Solution_20 {
	
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> util = new Stack<Integer>();
	int min = Integer.MAX_VALUE;
	
	public void push(int node) {
		if(min > node) {
			min = node;
			util.push(node);
		} else {
			util.push(min);
		}
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
        util.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return util.peek();
    }

}
