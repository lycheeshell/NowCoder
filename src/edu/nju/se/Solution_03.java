package edu.nju.se;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 
 * @author zongk
 *
 */
public class Solution_03 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        
		Stack<Integer> stack = new Stack<Integer>();
		if(listNode != null) {
			stack.push(listNode.val);
			while(listNode.next != null) {
				listNode = listNode.next;
				stack.push(listNode.val);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		
		return list;
    }
	
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	
}
