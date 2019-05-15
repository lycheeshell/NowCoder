package edu.nju.se.num46_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 把二叉树打印成多行
 * 
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * @author zongk
 *
 */
public class Solution_60 {
	
	HashMap<Integer,ArrayList<Integer> > map = new HashMap<Integer, ArrayList<Integer>>();
	
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	
    	addNode(pRoot, 1);
    	
    	ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer>>();
    	
    	Set<Integer> set = map.keySet();
    	int[] array = new int[set.size()];
    	int n = 0;
    	for(Integer i : set) {
    		array[n++] = i;
    	}
    	Arrays.sort(array);
    	for(int i=0; i<array.length; i++) {
    		
    		ArrayList<Integer> temp = map.get(array[i]);
    		list.add(temp);
    		
    	}
    	
    	return list;
    }
    
    public void addNode(TreeNode node, int layer) {
    	if(node == null) {
    		return;
    	}
    	ArrayList<Integer> list = map.get(layer);
    	if(list != null) {
    		list.add(node.val);
    	} else {
    		list = new ArrayList<Integer>();
    		list.add(node.val);
    		map.put(layer, list);
    	}
    	addNode(node.left, layer+1);
    	addNode(node.right, layer+1);
    }
    
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
	
}
