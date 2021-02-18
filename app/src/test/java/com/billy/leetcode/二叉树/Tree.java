package com.billy.leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Description：
 * Created by billy_Cui.
 * Date: 2020/9/2
 */
public class Tree {

/**
 * 1 ms	38.2 MB
 */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root==null){
            return list;
        }
        list.add(root.val);
        if (root.left!=null){
            list.addAll(preorderTraversal(root.left));
        }
        if (root.right!=null){
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }

    /**
     * 0 ms	37.9 MB
     * @param root
     * @return
     */

//    public List<Integer> preorderTraversal(TreeNode root) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        LinkedList<Integer> output = new LinkedList<>();
//        if (root==null){
//            return output;
//        }
//        stack.add(root);
//        while (!stack.isEmpty()){
//            TreeNode treeNode = stack.pollLast();
//            output.add(treeNode.val);
//            if (treeNode.right!=null){
//                stack.add(treeNode.right);
//            }
//            if (treeNode.left!=null){
//                stack.add(treeNode.left);
//            }
//        }
//        return output;
//    }
}
