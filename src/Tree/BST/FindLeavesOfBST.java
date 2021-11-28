package Tree.BST;


import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> soln = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        getHieght(root);
        return soln;
    }
    int getHieght(TreeNode node){
        if(node==null) return -1;
        int left = getHieght(node.left);
        int right = getHieght(node.right);

        int height = Math.max(left, right) +1;

        if(height == soln.size()){
            soln.add(new ArrayList<>());
        }

        this.soln.get(height).add(node.val);

        return height;
    }

    class TreeNode {
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