package edu.nju.se.num46_60;

/**
 * 	二叉树的下一个结点
 * 
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * @author zongk
 *
 */
public class Solution_57 {
	
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
    	
    	if(pNode.right != null && pNode.next != null) {
    		return pNode.right;
    	}
	    
    	if(pNode.next != null) {
    		if(pNode.next.left == pNode) {
    			return pNode.next;
    		} else {
    			if(pNode.next.next.left == pNode.next) {
    				return pNode.next.next;
    			} else {
    				return null;
    			}
    		}
    	}
    	
    	if(pNode.right != null) {
    		TreeLinkNode node = pNode.right;
    		while(node.left != null) {
    			node = node.left;
    		}
    		return node;
    	}
    	
    	return null;
    }
    
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
