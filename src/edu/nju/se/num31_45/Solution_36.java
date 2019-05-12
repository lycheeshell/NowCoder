package edu.nju.se.num31_45;

import java.util.ArrayList;

/**
 * 两个链表的第一个公共结点
 * 
 * 输入两个链表，找出它们的第一个公共结点。
 * 
 * @author zongk
 *
 */
public class Solution_36 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	 
    	ArrayList<ListNode> list1 = new ArrayList<ListNode>();
    	ArrayList<ListNode> list2 = new ArrayList<ListNode>();
    	
    	while(pHead1 != null) {
    		list1.add(pHead1);
    		pHead1 = pHead1.next;
    	}
    	
    	while(pHead2 != null) {
    		list2.add(pHead2);
    		pHead2 = pHead2.next;
    	}
    	
    	if(list1.size() == 0 || list2.size() == 0) {
    		return null;
    	}
    	
    	int i = list1.size()-1;
    	int j = list2.size()-1;
    	
    	if(list1.get(i) != list2.get(j)) {
    		return null;
    	}
    	
    	while(i>=0 && j>=0) {
    		if(list1.get(i) != list2.get(j)) {
    			return list1.get(i+1);
    		}
    		i--;
    		j--;
    	}
    	if(i < 0) {
    		return list1.get(0);
    	}
    	if(j < 0) {
    		return list2.get(0);
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
