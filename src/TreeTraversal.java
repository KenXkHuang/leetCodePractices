import java.util.ArrayList;
import java.util.List;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(3);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);

        System.out.println(inorderTraversal(root));
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null){
                return list;
            }
        if(root.left!=null){
            inorderTraversal(root.left).forEach(
                    node -> list.add(node));
        }
        list.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right).forEach(
                    node -> list.add(node)
            );
        }
        return list;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null){
            return list;
        }
        list.add(root.val);

        if(root.left!=null){

            preorderTraversal(root.left).forEach(
                    node -> list.add(node)
            );

        }
        if(root.right!=null){

            preorderTraversal(root.right).forEach(
                    node -> list.add(node)
            );

        }
        return list;
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null){
            return list;
        }
        if(root.left!=null){
            postorderTraversal(root.left).forEach(
                    node -> list.add(node)
            );
        }
        if(root.right!=null){
            postorderTraversal(root.right).forEach(
                    node -> list.add(node)
            );
        }
        list.add(root.val);

        return list;
    }
}