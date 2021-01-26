package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public static void main(String[] args) {
        //write test
    }
    /*
    Given a binary tree, return the postorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode t = stack.peek();
            if(t.right != null){
                root = t.right;
                t.right = null;
            } else{
                t = stack.pop();
                list.add(t.val);
            }
        }
        return list;
    }
/*
Given a binary tree, return the inorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?

 */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode t = stack.pop();
            list.add(t.val);
            if(t.right != null){
                root = t.right;
            }
        }
        return list;
    }

    //  Definition for a binary tree node.
      public class TreeNode {
         int val;
         TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
