package edu.nju.se.num01_15;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中倒数第k个结点
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 
 * @author zongk
 *
 */
public class Solution_14 {
	
	public ListNode FindKthToTail(ListNode head,int k) {
		
		if(head == null || k <= 0) {
			return null;
		}
		
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		while(head.next != null) {
			head = head.next;
			list.add(head);
		}
		
		if(k > list.size()) {
			return null;
		}
		
		return list.get(list.size()-k);
		
    }
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
}
