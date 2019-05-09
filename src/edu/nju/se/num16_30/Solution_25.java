package edu.nju.se.num16_30;


/**
 * 复杂链表的复制
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author zongk
 *
 */
public class Solution_25 {
	
	public RandomListNode Clone(RandomListNode pHead) {
		
		if(pHead == null) { 
			return null;
		}
		
		RandomListNode newNext = null;
		if(pHead.next != null) {
			newNext = new RandomListNode(pHead.next.label);
		}
		RandomListNode newRandom = null;
		if(pHead.random != null) {
			newRandom = new RandomListNode(pHead.random.label);
		}
		
		RandomListNode newHead = new RandomListNode(pHead.label);
		newHead.next = newNext;
		newHead.random = newRandom;
		
		RandomListNode temp = newHead.next;
		
		while((pHead=pHead.next) != null) {
			
			if(pHead.random != null) {
				newRandom = new RandomListNode(pHead.random.label);
			} else {
				newRandom = null;
			}
			if(pHead.next != null) {
				newNext = new RandomListNode(pHead.next.label);
			} else {
				newNext = null;
			}
			temp.next = newNext;
			temp.random = newRandom;
			temp = temp.next;
		}
		
		return newHead;
        
    }
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
}
