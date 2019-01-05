import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class ZigzagTraversal {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(7);
        rootNode.left.right = new TreeNode(6);
        rootNode.right.left = new TreeNode(5);
        rootNode.right.right = new TreeNode(4);
        zigzagLevelOrder(rootNode);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       ArrayList<List<Integer>> resultList=new ArrayList<>();
        if(root==null){
            return resultList;
        }
        Stack<TreeNode> currentStack=new Stack(), nextStack=new Stack();
        boolean leftToRight=true;
        currentStack.add(root);
        ArrayList<Integer> levelList=new ArrayList<>();

        while(!currentStack.empty()){
            root=currentStack.pop();
            levelList.add(root.val);
            if(leftToRight){

                if(root.right!=null){
                    nextStack.add(root.right);
                }
                if(root.left!=null){
                    nextStack.add(root.left);
                }
            }else{
                if(root.left!=null){
                    nextStack.add(root.left);
                }
                if(root.right!=null){
                    nextStack.add(root.right);
                }
            }
            if(currentStack.empty()) {
                ArrayList<Integer> newList=new ArrayList<>(levelList);
                resultList.add(newList);
                levelList.clear();
                leftToRight = !leftToRight;
                Stack<TreeNode> temp=currentStack;
                currentStack=nextStack;
                nextStack=temp;
            }
        }
        return resultList;
    }
}
