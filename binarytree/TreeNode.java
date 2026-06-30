package binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }



//DFS------------------------------------------------------

    //Pre-order (Корень → Лево → Право)
    //in recursion
    public void  dfsPreOder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfsPreOder(root.left);
        dfsPreOder(root.right);
    }


    //iteeretion
    public void dfsPreOderIter(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            // Правый push первым, чтобы лево обрабатывалось раньше
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    //maybe that
    public void traversePreOrderWithoutRecursion() {
        Stack<TreeNode> stack = new Stack<Node>();
        TreeNode current = root;
        stack.push(root);
        while(!stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);
        
            if(current.right != null) {
                stack.push(current.right);
            }    
            if(current.left != null) {
                stack.push(current.left);
            }
        }        
    }



    //Post-order (Лево → Право → Корень)
    //in recorsion
    void dfsPostOrder(TreeNode root) {
        if (root == null) return;
        dfsPostOrder(root.left);
        dfsPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    //in iteretion(has 2 stack)
    public void dfsPostOrderIter(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
    
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val);
        }
    }   
         



}
