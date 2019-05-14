package edu.nju.se.num46_60;

import java.util.ArrayList;

/**
 * 链表中环的入口结点
 * 
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * @author zongk
 *
 */
public class Solution_55 {

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		
		ArrayList<ListNode> list = new ArrayList<ListNode>();
		
		while(pHead != null) {
			if(list.contains(pHead)) {
				return pHead;
			}
			list.add(pHead);
			pHead = pHead.next;
		}
		
		return null;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
