import java.util.ArrayList;

public class ConstructTreeFromInderAndPreorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
    }

    //preorder中的第一个代表root， 之后用rootIndex表示下标
    //在inorder中找到root的值，位置是rootPosition， 则左边都是left中的结点，右边都是right中的结点
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length <= 0 || inorder==null || inorder.length<=0){
            return null;
        }
        if(preorder.length!=inorder.length){
            return null;
        }
        return helper(preorder,inorder, 0, 0, preorder.length - 1);
    }
    private static TreeNode helper(int[] preorder, int[] inorder, int rootIndex, int start, int end){
        //注意break条件！！rootIndex >= preorder.length 不用写,因为rootIndex一定是valide的（使用for循环搜出来的）
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        if(start == end){
            return root;
        }
        int rootPosition = end;
        //i不要从0开始
        for(int i = end; i >= start; i--){
            if(inorder[i] == preorder[rootIndex]){
                rootPosition = i;
                break;
            }
        }
        root.left = helper(preorder,inorder, rootIndex + 1, start, rootPosition - 1);
        root.right = helper(preorder,inorder, rootIndex + 1+ rootPosition - start, rootPosition + 1, end);
        return root;
    }

}
