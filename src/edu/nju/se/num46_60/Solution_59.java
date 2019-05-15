package edu.nju.se.num46_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * 按之字形顺序打印二叉树
 * 
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 
 * @author zongk
 *
 */
public class Solution_59 {
	
	HashMap<Integer,ArrayList<Integer> > map = new HashMap<Integer, ArrayList<Integer>>();
	
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	
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
    		if(array[i] % 2 == 1) {
    			list.add(temp);
    		} else {
    			ArrayList<Integer> ls = new ArrayList<Integer>();
    			for(int k=temp.size()-1; k>=0; k--) {
    				ls.add(temp.get(k));
    			}
    			list.add(ls);
    		}
    		
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
