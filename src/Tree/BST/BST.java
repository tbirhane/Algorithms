package Tree.BST;

import java.util.*;

public class BST {
    Node root = null;
    static List<Integer> array = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,0,7,6,1,4};
        BST bst = new BST();
        for(int a:arr)
            bst.insert(a);
        bst.print();
        System.out.println("sorted : "+array);
        String a = "Java";
        String b = "java";
        System.out.println(a == b);
        System.out.println(" Level Order Sum: "+ bst.levelSumBST());
        System.out.println("Is valid Tree.BST.BST : " + bst.isValid());
        //Is Isomorphic
        System.out.println("Is Isomorphic: "+bst.isomorphic());
        //Print root to leaf path

    }
    public List<Integer> levelSumBST() {
        if(root == null) return null;
        Node head = root;
        List<Integer> sums = new LinkedList<>();
        Queue<Node> queu = new LinkedList<>();
        queu.add(root);
        while(!queu.isEmpty()){
            int count = queu.size();
            int sum = 0;
            while(count>0){
                Node root = queu.poll();
                sum += root.data;
                count--;
                if(root.left != null)
                    queu.add(root.left);
                if(root.right != null)
                    queu.add(root.right);
            }
            sums.add(sum);
        }
        return sums;
    }
    public void printLevelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return;
        queue.add(root);
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.println(tmp.data);
            if(tmp.left != null) queue.add(tmp.left);
            if(tmp.right != null) queue.add(tmp.right);
        }
    }
    public void print(){
        inorder(root);
        System.out.println("Print PreOrder");
        preOrder(root);
        System.out.println("Print Level Order");
        printLevelOrder(root);
        System.out.println("Reverse Order : ");
        printReverseOrder(root);
        System.out.println("Has a path with sume 8 " + hasPathSum(root, 8));
        //Print root to leaf paths
        List<String> paths = new ArrayList<>();
        printRootLeafPath(root, paths, "");
        System.out.println("All paths Root to leaf: "+paths);
        // Print all the paths from root, with a specified sum in Binary tree
        List<String> allPathsFromRootSumToK = new ArrayList<>();
        printAllPathsFromRootToLeafSumToK(allPathsFromRootSumToK, "", root, 12);
        System.out.println("Paths from root sum to 12: "+allPathsFromRootSumToK);
        /*
    Print all k-sum paths in a binary tree
    A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
    A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.
         */
        System.out.println("Print all k-sum paths in a binary tree: ");
        printAllKsumPaths(new ArrayList<>(), root, 7);
        //create a string for binary tree and sum of the path
        List<String> list = new ArrayList<>();
        createStringAndSumOfPath(list,"",root,0);
        System.out.println("create a string for binary tree and sum of the path");
        System.out.println(list);
        System.out.println("Print Spiral");
        printSpiral(root);
        System.out.println("print level N:");
        printLevelN(root, 3);
    }
    public void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        array.add(root.data);
        inorder(root.right);
    }
    public void printReverseOrder(Node node){
        if(node == null) return;
        printReverseOrder(node.right);
        System.out.println(node.data);
        printReverseOrder(node.left);
    }
    public void preOrder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public void insert(int a){
        if(root == null) root = new Node(a);
        else {
            Node tmp;
            tmp = root;
            Node n = new Node(a);
            boolean inserted = false;
            while(!inserted) {
                if (a < tmp.data) {
                    if(tmp.left == null){
                        tmp.left = n;
                        inserted = true;
                    }
                    else tmp = tmp.left;
                }
                if(a > tmp.data){
                    if(tmp.right == null){
                        tmp.right = n;
                        inserted = true;
                    }
                    else tmp = tmp.right;
                }
            }
        }
    }
    public boolean isValid(){
        if(root == null)
        return true;
        Stack<Node> stack = new Stack<>();
        int value = Integer.MIN_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.data <= value)
                return false;
            value = root.data;
            root = root.right;
        }
        return true;
    }
//Check if binary tree has path from root to leaf with given sum
     boolean hasPathSum(Node node, int sum) {
        if(node == null)
            return sum==0;
        else{
            int subsum = sum - node.data;
            boolean ans = false;
            if(subsum == 0 && node.left ==null && node.right == null)
                return true;
            if(node.left != null)
                ans = ans || hasPathSum(node.left, subsum);
            if(node.right != null)
                ans = ans || hasPathSum(node.right, subsum);
            return ans;
        }

    }
    void printAllPathsFromRootToLeafSumToK(List<String> paths, String path, Node root, int sum){
        if(root == null) return;
        path+= root.data + " ";
        sum = sum - root.data;
        /**
         * replace the followin if with
         *   if(sum == 0 && root.left == null && root.right == null)
         *   if the path we want is from root to leaf
         */
      if(sum == 0) {
            paths.add(path);
        }
        printAllPathsFromRootToLeafSumToK(paths, path, root.left, sum);
        printAllPathsFromRootToLeafSumToK(paths, path, root.right, sum);
    }
    /*

    Print all k-sum paths in a binary tree

    A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
    A path can start from any node and end at any node and must be downward only,
    i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.
     */
    void printAllKsumPaths(List<Integer> paths, Node root, int sum) {
        if(root == null) return;
        paths.add(root.data);
        printAllKsumPaths(paths, root.left, sum);
        printAllKsumPaths(paths, root.right,sum);
        int tmp = 0;
        for(int j = paths.size()-1; j > 0; j--){
            tmp += paths.get(j);
            if(sum == tmp){
                printPath(paths, j);
            }
        }
        paths.remove(paths.size()-1);
    }
    void printPath(List<Integer> list, int i){
        for(int j = i; j < list.size() ; j++)
            System.out.print(list.get(j)+ " ");
        System.out.println();
    }
    // check if two trees are Isomorphic
    boolean isomorphic(){
        Node tree1 = new Node(1);
        tree1.left = new Node(5);
        tree1.right = new Node(8);
        tree1.left.left = new Node(2);
        tree1.left.right = new Node(3);

        Node tree2 = new Node(1);
        tree2.left = new Node(8);
        tree2.right = new Node(5);
        tree2.right.right = new Node(3);
        tree2.right.left = new Node(2);
        tree2.left.left = new Node(6);
       return isIsomorphic(tree1, tree2);
    }
    boolean isIsomorphic(Node n1, Node n2){
        if(n1 == null && n2==null){
            return true;
        }
        if(n1 == null || n2 == null)
            return false;
        if(n1.data != n2.data)
            return false;
        return isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right) ||
                isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left);
    }
    void printRootLeafPath(Node root, List<String> paths, String path){
        if(root == null) return;
        path = path+root.data;
        if(root.left == null && root.right == null)
            paths.add(path);
        path = path + "->";
        printRootLeafPath(root.left, paths, path);
        printRootLeafPath(root.right, paths, path);
    }

    void createStringAndSumOfPath(List<String> list, String path, Node root, int sum){
        if(root == null) return;
        path += root.data;
        sum += root.data;
        if(root.left == null && root.right == null){
            list.add( path + " = " + sum);
        }
        path += "->";
        createStringAndSumOfPath(list, path, root.left, sum);
        createStringAndSumOfPath(list, path, root.right, sum);
    }
    /*
    Find SquarRoot of n
    Time: O(log(n))
     */
    static int squarRootOfN(int n)  {
        if(n==0 || n==1) return n;
        int start = 1, end = n;
        int ans = 0;
        while(start <= end){
            int m = (start+end)/2;
            if(m*m == n) return m;
            if(m*m <= n){
                start = m+1;
                ans = m;
            }
            else{
                end = m-1;
            }
        }
        return ans;
    }
    /*Print tree in anti-clock wise (spiral)
       5     this will print 5 2 4 8 3
    /   \
    3    8
   / \
  2   4
     */
    static void printSpiral(Node node) {
        int i = 1;
        int j = height(node);
        boolean flag = false;
        while(i <= j){
            if(!flag){
                rightToLeft(node, i);
                i++;
                flag = !flag;
            } else {
                leftToRight(node, j);
                j--;
                flag = !flag;
            }
        }
    }
    static int height(Node node){
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left+1, right+1);
    }
    static void leftToRight(Node node, int n) {
        if(node == null) return;
        if(n==1) System.out.println(node.data);
        else{
            leftToRight(node.left, n-1);
            leftToRight(node.right, n-1);
        }
    }
    static void rightToLeft(Node node, int n) {
        if(node == null) return;
        if(n==1) System.out.println(node.data);
        else{
            rightToLeft(node.right, n-1);
            rightToLeft(node.left, n-1);
        }
    }
    //Print elements which are at a certain distance from the root node.

    static void printLevelN(Node node, int n) {
        if(node==null) return;
        if(n==1) System.out.println(node.data);
        else{
            printLevelN(node.left, n-1);
            printLevelN(node.right, n-1);
        }
    }

    /**
     * Print binary tree in ZigZag
     */

        public List<List<Integer>> zigZagLevelOrder(Node root) {
            if(root==null) return new ArrayList<>();
            Deque<Node> dq = new LinkedList<>();
            dq.add(root);
            List<List<Integer>> list = new ArrayList<>();
            boolean flag=false;
            while(!dq.isEmpty()) {
                int count = dq.size();
                List<Integer> values = new ArrayList<>();
                if(!flag){
                    while(count > 0){
                        Node n = dq.pop();
                        values.add(n.data);
                        if(n.left!=null) dq.addLast(n.left);
                        if(n.right!=null) dq.addLast(n.right);
                        count--;
                    }
                    flag = !flag;
                } else {
                    while(count > 0) {
                        Node n = dq.removeLast();
                        values.add(n.data);
                        if(n.right!=null) dq.push(n.right);
                        if(n.left!=null) dq.push(n.left);
                        count--;
                    }
                    flag = !flag;
                }
                list.add(values);
            }
            return list;
        }

    class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }
}

