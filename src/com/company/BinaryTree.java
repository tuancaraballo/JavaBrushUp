package com.company;
/** Every field should have getters and setters but for the sake of simplicity we are making everything public **/
class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int data, TreeNode left,TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTree {
    public static TreeNode root;

    public BinaryTree(int data){
        root = new TreeNode(data, null, null);
    }

    public void AddTreeNode(TreeNode parent, int data, String orientation ){
        TreeNode new_node = new TreeNode(data, null, null);
        if(orientation == "left"){
            parent.left = new_node;
        }else{
            parent.right = new_node;
        }
    }
}
