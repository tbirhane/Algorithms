
    /**
     *
     *      1         1
     *    /  \       / \
     *   3   2      2  3
     *      / \    / \
     *     5  4   4   5
     *
     * /
     */

    import java.util.LinkedList;
    import java.util.Queue;


    class BSTMirrorImage{
        //  Node root1 = null;
        //  Node root2 = null;
        public  static void  main(String[] args){
            // int a[] = {2,4,5,6,7,8};
            Node tree1 = new Node(1);
            Node tree2 = new Node(1);
            //tree1
            tree1.left = new Node(3);
            tree1.right = new Node(2);
            tree1.right.left= new Node(5);
            tree1.right.right= new Node(4);

            //tree2
            tree2.right= new Node(3);
            tree2.left = new Node(2);
            tree2.left.right = new Node(5);
            tree2.left.left = new Node(4);
            boolean b = isMirrorImage(tree1,tree2);
            System.out.println(b);

        }
        //  void insert1(int n){
        //      Node node = new Node();
        //      node.data = n;
        //      if(root1 == null) root1 = node;

        //  }
        static boolean isMirrorImage(Node root1, Node root2){
            if(root1 == null && root2 == null) return true;
            if((root1 == null && root2 != null) || (root2 == null && root1 != null))
                return false;
            Queue<Node> queue1 = new LinkedList<>();
            Queue<Node> queue2 = new LinkedList<>();
            queue1.add(root1);
            queue2.add(root2);
            while(!queue1.isEmpty() && !queue2.isEmpty()){
                Node n1 = queue1.poll();
                Node n2 = queue2.poll();
                if(n1.data != n2.data)
                    return false;
                if(n1.left != null)
                    queue1.add(n1.left);
                if(n1.right != null)
                    queue1.add(n1.right);
                if(n2.right != null)
                    queue2.add(n2.right);
                if(n2.left != null)
                    queue2.add(n2.left);

            }
            if(queue1.isEmpty() && queue2.isEmpty())
                return true;
            return false;
        }
        static class Node{
            int data;
            Node left;
            Node right;
            Node(int a){
                this.data = a;
            }
        }
    }

