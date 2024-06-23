package com.adolfoeloy.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

    public int[] toArray() {
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(this);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            values.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return values.stream().mapToInt(i -> i).toArray();
    }

 }
