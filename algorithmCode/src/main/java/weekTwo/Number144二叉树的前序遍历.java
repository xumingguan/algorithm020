package weekTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号 144二叉树的前序遍历
 *
 * @author Ye-Ma
 */
public class Number144二叉树的前序遍历 {

    /**
     * 前序  二叉   根 左 右
     *
     * @param root 根
     * @return 结果
     */
    public List<Integer> preorderTraversal(Number94二叉树的中序遍历.TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        preorder(root, list);
        return list;
    }

    public void preorder(Number94二叉树的中序遍历.TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.getLeft(), list);
        preorder(root.getRight(), list);
    }

}
