package edu.nju.se.num46_60;

import java.util.ArrayList;

/**
 * 	删除链表中重复的结点
 * 
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * @author zongk
 *
 */
public class Solution_56 {
	
    public ListNode deleteDuplication(ListNode pHead) {
    	
    	if(pHead == null) {
    		return null;
    	}
    	
    	ArrayList<ListNode> list = new ArrayList<ListNode>();
    	ArrayList<ListNode> index = new ArrayList<ListNode>();
    	
    	while(pHead != null) { 
    		list.add(pHead);
    		pHead = pHead.next;
    	}
    	
    	for(int i=0; i<list.size(); i++) {
    		if(!index.contains(list.get(i))) {
	    		int num = 0;
	    		for(int j=i+1; j<list.size(); j++) {
	    			if(list.get(i).val == list.get(j).val) {
	    				if(num==0) {
	    					index.add(list.get(i));
	    				}
	    				index.add(list.get(j));
	    				num++;
	    			}
	    		}
    		}
    	}
    	
    	for(ListNode node: index) {
    		list.remove(node);
    	}
    	
    	if(list.size() == 0) {
    		return null;
    	}
    	for(int i=0; i<list.size()-1; i++) {
    		list.get(i).next = list.get(i+1);
    	}
    	list.get(list.size()-1).next = null;
    	return list.get(0);
    	
    }

    public class ListNode {
        @Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}

		int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
    	new Solution_56().test();
	}
    public void test() {
    	ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n31 = new ListNode(3);
		ListNode n32 = new ListNode(3);
		ListNode n41 = new ListNode(4);
		ListNode n42 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n31;
		n31.next = n32;
		n32.next = n41;
		n41.next = n42;
		n42.next = n5;
		deleteDuplication(n1);
    }
}
