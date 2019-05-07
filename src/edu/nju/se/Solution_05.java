package edu.nju.se;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * @author zongk
 *
 */
public class Solution_05 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	int outcome = stack2.pop();
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
    	return outcome;
    }
	
}
